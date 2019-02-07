package Assets;

import java.util.Scanner;

public class Menu {

    private final int MAX_ATTEMPTS = 3;
    private int menuId = 0;
    private int attempts = 0;


    /**
     * Asks for user input.
     *
     * */
    public void promptUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Navigate using numbers: ");
        String answer = sc.nextLine();
        int parsed;

        try {
            parsed = Integer.parseInt(answer);

        } catch (Exception e) {
            attempts++;
            System.err.println("You can only navigate using the numbers. Try again. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
            parsed = 0; // Guide to switch default.
            checkAttempts();
        }

        switch (parsed) {
            case 1:
                System.out.println("Not active. Exiting..");
                System.exit(0);
                break;
            case 2:
                System.out.println("Not active. Exiting..");
                System.exit(0);
                break;
            case 3:
                System.out.println("Exiting..");
                System.exit(0);
                break;
            default:
                attempts++;
                System.err.println("You can only navigate using the numbers. Try again. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
                checkAttempts();
                promptUserInput();
                break;
        }
    }

    private void checkAttempts() {
        if (attempts == MAX_ATTEMPTS){
            System.out.println("Too many attempts. Exiting..");
            System.exit(0);
        }
        else{
            promptUserInput();
        }
    }

    /**
     * Welcome screen.
     *
     * */
    public void printWelcome() {
        System.out.println("-------------------------\n     Hangman 0.1.1\n-------------------------");
        System.out.println("\n1. Play (inactive)");
        System.out.println("2. Highscore(inactive)");
        System.out.println("3. Exit");
    }
}
