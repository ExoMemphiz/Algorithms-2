package helpers;

public class Word {

    private String word;
    private int count;

    public Word(String word) {
        this.word = word;
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "[" + this.word + ": " + this.count + "]";
    }
}
