package Assets;

public class HangmanMain {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.printWelcome();
        if(menu.userInput() == 1){
            initiatePlay();
        }

    }

    private static void initiatePlay() {
        GameController gc = new GameController();
        gc.start();
    }


}
