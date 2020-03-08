import java.util.*;

public class playerCharacters extends truthSpotter {

    
    
    private String name;
    private int score;
    private char yesKey;
    private char noKey;
    
    
    
    public playerCharacters(String nm, char yk, char nk) {
        name = nm;
        yesKey = yk;
        noKey = nk;
    }
    
    public void setScore(int scr){
        score = scr;
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
