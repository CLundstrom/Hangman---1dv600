package Assets;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Scene {

    private String scenePath;
    private String content;

    public Scene(String path) {
        this.scenePath = path;
        try{
            this.content = readText(path, StandardCharsets.UTF_8);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param path Path to the scene.
     * @param cs Encoding of txt-scene.
     * @return Returns contents of the scene.
     * @throws IOException
     */
    public static String readText(String path, Charset cs) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)), cs);
    }

    /**
     * Shows scene.
     */
    public void show(){
        System.out.print(this.content);
    }
}
