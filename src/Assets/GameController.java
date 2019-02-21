package Assets;

public class GameController {

    private boolean running = false;
    private Game game;

    public GameController() {

    }

    public void start() {
        this.running = true;
        this.game = new Game();
        stop();

    }

    public void stop() {
        this.running = false;
        HangmanMain.main(null);
    }

}
