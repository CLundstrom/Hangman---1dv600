package Assets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Highscore {

    private String path = "src/Scenes/highscores.dat";
    private ArrayList<String> list;


    Highscore(){
        list = new ArrayList<>();
        //list.add(loadHighscores());
    }

    /*private String loadHighscores() {
        try {
            return Scene.readText(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/



    public ArrayList<String> getList(){
        return this.list;
    }

    public static String readText(String path, Charset cs) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)), cs);
    }

}
