package Assets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class HighscoreTest {

    HighscoreController hc;

    @BeforeEach
    void setUp() {
        hc = new HighscoreController();
    }

    @Test
    void isHighscoreSortedAndCorrect() {
        hc.fillList();
        hc.add(new Player("Bob", 31));
        hc.add(new Player("Bob", 31));
        hc.add(new Player("Sam", 14));
        hc.add(new Player("Frodo", 15));
        hc.sort();

        assertEquals(hc.getList().get(0).getScore(), 62);
        assertEquals(hc.getList().get(1).getScore(), 15);
        assertEquals(hc.getList().get(2).getScore(), 14);
    }

    @Test
    void ensureFileExistsTest() {
        String path = "src/Scenes/highscores.dat";
        try {
            Files.delete(Paths.get(path));
            hc = new HighscoreController();
            ArrayList<Player> list = hc.getList();
            assertTrue(Files.exists(Paths.get(path)));
            assertNotNull(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void ensureListSize() {

        hc.add(new Player("Abb", 1));
        hc.add(new Player("Bbb", 1));
        hc.add(new Player("Cbb", 1));
        hc.add(new Player("Dbb", 1));
        hc.add(new Player("Ebb", 1));
        hc.add(new Player("Fbb", 1));
        hc.add(new Player("Gbb", 1));
        hc.add(new Player("Hbb", 1));
        hc.add(new Player("Ibb", 1));
        hc.add(new Player("Jbb", 1));
        hc.add(new Player("Kbb", 1));

        assertEquals(hc.getList().size(), 10);
    }
}
