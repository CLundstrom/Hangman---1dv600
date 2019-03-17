package Assets;

import java.util.ArrayList;

public class PlayerController {

    private ArrayList<Player> players = new ArrayList<>();
    private Player player;
    private int score;

    public void createPlayer(){
        player = new Player();
        player.promptPlayerName();
    }

    Player getPlayer(){
        return player;
    }

}
