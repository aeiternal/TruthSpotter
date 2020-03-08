import java.util.*;

public class truthSpotter {
    
    public  int numPlayers;
    private char[][] play_key_pairs = {{'q','s'},{'x','c'},{'n','m'},{'l','p'}};//key pairs for yes and no the left key for yes and the right key for no
    
    public void truthSpotter(int numP) {
        numPlayers = numP;
    }
    
    public static void initializePlayers(int x) {
        
        
        
    }
    
    //public int scoreKeeping() {
        
    //}
    
    
public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Welcome to TruthSpotter! The game where you have to find the truth in a sea of lies! Tell me, How many are playing today?");
       
        int numP = scr.nextInt();
        
        //while loop to check for the correct number of players
        while(true) {
            if (numP < 2) {
               System.out.println("at least 2 players are required for play");
               numP = scr.nextInt();
            }
            else {
                
                break;
            }
        }
        
    }
    
}


