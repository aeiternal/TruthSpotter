import java.util.*;

public class truthSpotter {
    
    public  int numPlayers;
    
    
    
    public static void initializePlayers(int x) {
        
        
        
    }
    
    public int scoreKeeping() {
       
        
        
        
    }
    
    
    public void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Welcome to TruthSpotter! The game where you have to find the truth in a sea of lies! Tell me, How many are playing today?");
       
        numPlayers = scr.nextInt();
        
        
        if (numPlayers < 2) {
           
        }
        else {
            initializePlayers(numPlayers);
        }
        
        
    }
    
}


