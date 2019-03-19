package Assets;

import java.nio.file.Paths;
import java.util.ArrayList;

public class SceneController {

    private int sceneIndex = 0;
    private Scene currentScene;
    private ArrayList<Scene> scenes = new ArrayList<>();



    public SceneController(){
        loadScenes();
        currentScene = scenes.get(0); //first scene.
    }

    public void loadScenes(){
        scenes.add(new Scene(Paths.get("src/Scenes/scene1.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene2.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene3.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene4.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene5.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene6.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene7.txt").toString()));
        scenes.add(new Scene(Paths.get("src/Scenes/scene8.txt").toString()));
    }

    /**
     *  Clears the console window. ( Modern problems require modern solutions lol )
     */
    public static void clear(){

        for(int i=0; i < 10;i++){
            System.out.println();
        }
    }

    public Scene getCurrentScene(){

        return this.currentScene;
    }

    public void nextScene(){
        if(sceneIndex < scenes.size()){
            sceneIndex++;
            currentScene = scenes.get(sceneIndex);
        }
        else{
            throw new NullPointerException("No scenes to load.");
        }
    }
}
