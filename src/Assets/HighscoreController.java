package Assets;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class HighscoreController {

    private String path = "src/Scenes/highscores.dat";
    ArrayList<Player> list = new ArrayList<Player>();

    HighscoreController(){
        fillList();
    }

    public static String readText(String path, Charset cs) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)), cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void fillList() {

        String entries = readText(path, StandardCharsets.UTF_8);
        if(entries != null || !entries.isEmpty()){

            entries = entries.replaceAll("[\\s]+", "");
            String divide[] = entries.split(";");

            for (int i = 0; i < divide.length; i += 2) {
                list.add(new Player(divide[i], Integer.valueOf(divide[i+1])));
            }
        }
    }

    void printList() {

        System.out.println("-------HIGHSCORES------ ");
        System.out.println("RANK\t\tNAME\t\tSCORE\n");
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Player e = list.get(i);

            System.out.print(i + 1 + ".\t\t" + e.toString());
            System.out.print("\t\t\t" + e.getScore() + "\n");
        }
    }
    private void save() {
        try {
            PrintWriter p = new PrintWriter("src\\Scenes\\highscores.dat");
            // Save only top 10
            Iterator<Player> it = list.iterator();
            int i = 0;
            while (it.hasNext() && i < 10) {
                Player e = it.next();
                p.println(e.getName() + ";" + e.getScore() + ";");
                i++;
            }
            p.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Player player) {

        boolean playerFound = false;
        for(Player p: list){
            if (p.getName().equalsIgnoreCase(player.getName())){
                p.setScore(player.getScore()+p.getScore()); // Add scores together
                playerFound = true;
            }
        }

        if(!playerFound) list.add(player);

        Collections.sort(list);
        trimList();
        save();
    }

    public ArrayList<Player> getList(){
        return this.list;
    }
    private void trimList() {
        if (list.size() > 10){
            list.remove(10);
        }

    }
}
