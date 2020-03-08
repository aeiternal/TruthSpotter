import java.util.*;

public class truthSpotter {
    
    public  int numPlayers;
    
    public void truthSpotter(int numP) {
        
    }
    
    public static void initializePlayers(int x) {
        
        
        
    }
    
    //public int scoreKeeping() {
        
    //}
    
    
public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        
        System.out.println("Welcome to TruthSpotter! The game where you have to find the truth in a sea of lies! Tell me, How many are playing today?");
       
        int numP = scr.nextInt();
        
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


