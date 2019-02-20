package Assets;

public class Word {

    private String word;
    private int nrOfChars;

    public Word(String word) {
        this.word = word;
        nrOfChars = word.length();
    }

    public String getWord() {
        return this.word;
    }

    public int length() {
        return this.nrOfChars;
    }
}
