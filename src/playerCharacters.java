public class playerCharacters {

    private String name;
    private int score;
    private char yesKey;
    private char noKey;

    public playerCharacters(String nm, char yk, char nk, int scr) {
        name = nm;
        yesKey = yk;
        noKey = nk;
        score = scr;
    }

    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }


    public char getTrue() {
        return yesKey;
    }

    public char getFalse() {
        return noKey;
    }

}