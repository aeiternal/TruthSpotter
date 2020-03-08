import java.util.*;

public class playerCharacters extends truthSpotter {

    
    
    private String name;
    private int score;
    private char yes;
    private char no;
    
    
    
    public playerCharacters(String nm, int scr, char True, char False) {
        name = nm;
        scr = score;
        True = yes;
        False = no;
    }
    
    
    
    public String getName() {
        return name;
    }
    
    
    public int getScore() {
        return score;
    }
    
    
    public char getTrue() {
        return yes;
    }
    
    
    public char getFalse() {
        return no;
    }

    
    
}
