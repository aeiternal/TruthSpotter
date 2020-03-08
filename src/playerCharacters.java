import java.util.*;

public class playerCharacters extends truthSpotter {

    
    
    private String name;
    private int score;
    private char yesKey;
    private char noKey;
    
    
    
    public playerCharacters(String nm, int scr, char yes, char no) {
        name = nm;
        score = scr;
        yesKey = yes;
        noKey = no;
    }
    
    
    
    public String getName() {
        return name;
    }
    
    
    public int getScore() {
        return score;
    }
    
    
    public char getTrue() {
        return yesKey;
    }
    
    
    public char getFalse() {
        return noKey;
    }

    
    
}
