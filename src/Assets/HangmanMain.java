package Assets;

public class HangmanMain {


    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.printWelcome();
        int answer = menu.userInput();
        //int answer = 2;
        if(answer == 1){
            initiatePlay();
        }
        else if (answer == 2){
            initiateHighscore();
        }
    }

    private static void initiatePlay() {
        GameController gc = new GameController();
        gc.start();
    }

    private static void initiateHighscore() {
        //HighscoreController hc = new HighscoreController();
        HighscoreController hc1 = new HighscoreController();
        SceneController.clear();
        hc1.printList();

       // hc.printList();
    }
}
