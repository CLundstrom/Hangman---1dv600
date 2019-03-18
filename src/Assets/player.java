package Assets;

import java.util.Scanner;

public class Player implements Comparable<Player> {

    private String name;
    private int score;
    private final int MAX_NAME_CHARS = 15;
    private final int MIN_NAME_CHARS = 3;


    public Player(String name, int score) {
        setName(name);
        this.score = score;
    }

    public Player() {
        this.score = 0;
        setName("Default Name");
    }


    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        if (name.length() > MAX_NAME_CHARS || name.length() < MIN_NAME_CHARS) {
            System.out.println("Invalid amount of characters. (min 3, max 15)");
        }

        this.name = name;
    }

    public void promptPlayerName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        try {
            setName(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Player o) {
        return o.score - this.score;
    }
}
