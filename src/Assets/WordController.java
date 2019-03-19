package Assets;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordController {


    private ArrayList<Word> words = new ArrayList<>();
    private File wordsFile = new File(Paths.get("src/Scenes/words.txt").toUri());


    public WordController(){
        loadWords();
    }


    public Word getRandom(){
        int rand = new Random().nextInt(words.size());
        return words.get(rand);
    }

    public void loadWords(){
        try {
            Scanner sc = new Scanner(wordsFile);
            while(sc.hasNextLine()){
                words.add(new Word(sc.nextLine()));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
