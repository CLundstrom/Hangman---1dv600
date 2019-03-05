package Assets;

import java.util.Scanner;

public class Player {

    private String name;
    private int score;
    private final int MAX_NAME_CHARS = 15;
    private final int MIN_NAME_CHARS = 3;


    public Player(String name){
        setName(name);
        this.score = 0;
    }

    public Player(){
        this.score = 0;
        setName("Default Name");
    }


    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(name.length() > MAX_NAME_CHARS || name.length() < MIN_NAME_CHARS){
            System.out.println("Invalid amount of characters. (min 3, max 15)");
        }

        this.name = name;
    }

    public void promptPlayerName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        try{
            setName(sc.nextLine());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
