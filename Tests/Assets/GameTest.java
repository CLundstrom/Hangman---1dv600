package Assets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    // Testing the incomplete test-function
    @Test
    public void loadHighscores(){
        HighscoreController hs = new HighscoreController();
        // Make sure list is loaded correctly.
        assertNotNull(hs.getList());
    }

    @Test
    public void isPlayerNameSet(){
        Player player = new Player();
        assertNotNull(player.getName());
    }


    @Test
    public void isCorrectGuessIgnoreCasing(){
        Game game = new Game(true);
        game.setWord("test");

        assertTrue(game.isCorrectGuess("T"));
        assertTrue(game.isCorrectGuess("E"));
        assertTrue(game.isCorrectGuess("S"));
    }

    @Test
    public void isWrongGuessWhenAmountOfCharMismatch(){
        Game game = new Game(true);
        game.setWord("Test");

        assertFalse(game.isCorrectGuess("Ta"));
        assertFalse(game.isCorrectGuess("_^0000xas00"));
    }

    @Test
    public void isCorrectGuess(){
        Game game = new Game(true);
        game.setWord("Test");

        assertFalse(game.isCorrectGuess("ö"));
        assertFalse(game.isCorrectGuess("k"));
        assertTrue(game.isCorrectGuess("e"));
        assertTrue(game.isCorrectGuess("s"));
    }
    @Test
    public void isCorrectScore(){
        Game game = new Game(true);
        game.setWord("Test");
        game.isCorrectGuess("t");
        game.isCorrectGuess("e");
        game.isCorrectGuess("s");
        assertEquals(3, game.getScore());
        game = new Game(true);
        game.setWord("Hi");
        game.isCorrectGuess("h");
        game.isCorrectGuess("i");
        assertEquals(2, game.getScore());

    }

    @Test
    public void isRoundLostWhenOutOfAttempts(){
        Game game = new Game(true);
        game.setWord("Test");
        int MAX_ROUNDS = 7;
        for (int i=0; i < MAX_ROUNDS;i++){
            game.increaseAttempts();
        }
        assertTrue(game.isRoundLost());
    }

    @Test
    public void isRoundLost(){
        Game game = new Game(true);
        game.setWord("Test");
        int MAX_ROUNDS = 6;
        for (int i=0; i < MAX_ROUNDS;i++){
            game.increaseAttempts();
            assertFalse(game.isRoundLost());
        }
    }
}