package Assets;

import java.util.Scanner;

/**
 * Game object. Will provide logic for a game round.
 */
public class Game {

    private WordController wh = new WordController();
    private SceneController sc = new SceneController();
    private PlayerController pc = new PlayerController();
    private int attempts = 0;
    private int MAX_ATTEMPTS = 7;
    private Word word = wh.getRandom();
    private String compareWord = word.getWord();
    private String[] maskedWord = new String[word.length()];
    private int score = 0;

    /**
     * Initiates the Game by preparing the scenes and words.
     */
    public Game() {
        pc.createPlayer();
        wh.loadWords(); // load words to memory
        maskWord();
        sc.loadScenes(); // loading scenes into memory
        sc.getCurrentScene().show(); // display first scene
        wordPrompt();
    }

    /**
     * Masks the word for use during gameplay.
     */
    private void maskWord() {
        for (int i = 0; i < word.getWord().length(); i++) {
            maskedWord[i] = ("_");
        }
    }

    /**
     * Checks whether the game-word contains the letter of the guess.
     * <p>
     *
     * @param guess Entered guess.
     * @return True if guess is correct.
     */
    private boolean isCorrectGuess(String guess) {
        if (compareWord.toLowerCase().contains(guess)) {
            // loop to replace all instances of the guess in masked.
            while (compareWord.contains(guess)) {
                //increase score
                score++;
                //get index
                int index = compareWord.indexOf(guess);
                // replace masked with guess.
                maskedWord[index] = guess;

                char[] tmp = compareWord.toCharArray();
                tmp[index] = '-';

                compareWord = String.valueOf(tmp);
            }
            return true;
        } else {
            return false;
        }
    }


    /**
     * Guesses character and checks if it's correct, wrong, victory or loss.
     * <p>
     * Adjusts scenes accordingly.
     */
    private void guessCharacter() {
        String input = getCharacter();

        // Right guess, victory
        if (isCorrectGuess(input) && isVictory()) {
            printMaskedWord(false);
            System.out.println("\tVICTORY!!\nScore: " + score);
        }

        // Right guess, not victory
        else if (isCorrectGuess(input)) {
            sc.clear();
            sc.getCurrentScene().show();
            System.out.print("\nCorrect! ");
        }

        //Wrong guess, loss
        else if (!isCorrectGuess(input) && isRoundLost()) {
            System.out.print("Correct word: ");
            printMaskedWord(false);
        }
        // Wrong guess, not lost.
        else {
            attempts++;
            sc.clear();
            sc.nextScene();
            sc.getCurrentScene().show();
            System.out.print("\n\n\t\tWrong! ");
        }
    }

    private boolean isRoundLost() {
        return attempts == MAX_ATTEMPTS;
    }

    private boolean isVictory() {
        return score >= word.length();
    }

    /**
     * Prints word as masked. (true/false)
     */
    private void printMaskedWord(boolean masked) {
        for (int i = 0; i < word.length(); i++) {
            if (masked) {
                System.out.print(maskedWord[i] + " ");
            } else {
                System.out.print(word.getWord().charAt(i) + " ");
            }
        }
    }

    /**
     * Main word loop prompt.
     */
    private void wordPrompt() {
        System.out.println("\nGuess a character. Fails left: " + (MAX_ATTEMPTS - attempts) + "\n");
        System.out.print("       ");
        printMaskedWord(true);
        System.out.print("\n\nEnter: ");
        while (!isRoundLost() || !isVictory()) {
            guessCharacter(); // fetch and guess
            wordPrompt(); // recursive.
        }

    }

    /**
     * Prompts character guess.
     *
     * @return Character guess.
     */
    private String getCharacter() {
        Scanner sc = new Scanner(System.in);
        String c = "";
        try {
            c = sc.next();
            while (c.length() > 1) {
                System.out.print("\nYou may only enter one character.\nEnter: ");
                c = sc.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

}
