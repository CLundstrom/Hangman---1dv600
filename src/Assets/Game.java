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
    private boolean roundOver = false;

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
        endRound();
    }

    private void endRound() {
        System.out.println("\nPress 'Enter' key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e) {e.printStackTrace();}
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
        if (isCorrectGuess(input)) {
            // Right guess, victory
            if (isVictory()) {
                System.out.println("\t");
                printMaskedWord(false);
                System.out.println("\n-------VICTORY!!-----------");
            } else {
                // Right guess, not victory
                sc.clear();
                sc.getCurrentScene().show();
                System.out.print("\nCorrect! ");
            }
        } else {
            attempts++;
            //Wrong guess, loss
            if (isRoundLost()) {
                sc.clear();
                sc.nextScene();
                sc.getCurrentScene().show();
                System.out.print("\nCorrect word: ");
                printMaskedWord(false);
                //showScore(); to be defined
            } else {
                // Wrong guess, not lost.
                sc.clear();
                sc.nextScene();
                sc.getCurrentScene().show();
                System.out.print("\n\n\t\tWrong! ");
            }
        }
    }

    private void showScore() {
        System.out.print("\nScore: " + score);

    }

    private boolean isRoundLost() {
        if(attempts == MAX_ATTEMPTS){
            roundOver = true;
        }
        else{
            roundOver = false;
        }
        return this.roundOver;
    }

    private boolean isVictory() {
        roundOver = score >= word.length();
        return roundOver;
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
        while (!roundOver) {
            guessCharacter(); // fetch and guess
            if(isRoundLost() || isVictory()){
                break;
            }
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