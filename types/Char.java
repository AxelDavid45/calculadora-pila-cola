package types;

public class Char {
    protected char x;

    public Char() {
        x = '\0';
    }

    public Char(char x) {
        this.x = x;
    }

    public char getValue() {
        return x;
    }

}
