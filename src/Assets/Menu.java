package Assets;

import java.util.Scanner;

public class Menu {

    private final int MAX_ATTEMPTS = 3;
    private int menuId = 0;
    private int attempts = 0;
    int parsed;


    /**
     * Asks for user input.
     *
     * */
    public int userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Navigate using numbers: ");
        String answer = sc.nextLine();

        try {
            parsed = Integer.parseInt(answer);

        } catch (Exception e) {
            attempts++;
            System.err.println("You can only navigate using the numbers. Try again. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
            parsed = 0; // Guide to switch default.
            checkAttempts();
        }
        finally {
            switch (parsed) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    System.out.println("Exiting..");
                    System.exit(0);
                    break;
                default:
                    attempts++;
                    System.err.println("You can only navigate using the numbers. Try again. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
                    checkAttempts();
                    userInput();
                    break;
            }
        }
        return 0;
    }

    private void checkAttempts() {
        if (attempts == MAX_ATTEMPTS){
            System.out.println("Too many attempts. Exiting..");
            System.exit(0);
        }
        else{
            userInput();
        }
    }

    /**
     * Welcome screen.
     *
     * */
    public void printWelcome() {
        System.out.println("-------------------------\n     Hangman 0.1.2\n-------------------------");
        System.out.println("\n1. Play");
        System.out.println("2. Highscore");
        System.out.println("3. Exit");
    }
}
