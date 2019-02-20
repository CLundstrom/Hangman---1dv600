package Assets;

import java.util.ArrayList;

public class PlayerController {

    private ArrayList<Player> players = new ArrayList<>();
    private Player player;

    public void createPlayer(){
        player = new Player();
        player.promptPlayerName();
    }
}
