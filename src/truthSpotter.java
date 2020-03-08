import java.util.*;

public class truthSpotter {
    
    private ArrayList<playerCharacters> players = new ArrayList<playerCharacters>();
    
    private char[][] play_key_pairs = {{'q','s'},{'x','c'},{'n','m'},{'l','p'}};//key pairs for yes and no the left key for yes and the right key for no
    
    public truthSpotter(int numPlayers) {
        //initializes everything in the game
        Scanner scr = new Scanner(System.in);
        for(int i=0;i<numPlayers;i++) {
            System.out.println("Please enter player "+i+"'s name");
            String name = scr.nextLine();
            players.add(new playerCharacters(name, play_key_pairs[i][0], play_key_pairs[i][1]));
        }
        scr.close();
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
                scr.close();
                truthSpotter game = new truthSpotter(numP);
                break;
            }
        }
        
    }
    
}


