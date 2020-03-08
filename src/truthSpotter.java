import java.io.File;
import java.util.*;

public class truthSpotter {
    
    public ArrayList<playerCharacters> players = new ArrayList<playerCharacters>();
    
    private char[][] play_key_pairs = {{'q','s'},{'x','c'},{'n','m'},{'l','p'}};//key pairs for yes and no the left key for yes and the right key for no
    
    private ArrayList<String[]> QA_pairs = new ArrayList<String[]>();
    
    public truthSpotter(int numPlayers, ArrayList<Scanner> catfiles) {
        //initializes everything in the game
        Scanner scr = new Scanner(System.in);
        for(int i=0;i<numPlayers;i++) {
            System.out.println("Please enter player "+i+"'s name");
            String name = scr.next();
            players.add(new playerCharacters(name, play_key_pairs[i][0], play_key_pairs[i][1]));
        }
        
        for(Scanner f : catfiles) {
            while(f.hasNextLine()) {
                String line = f.nextLine();
                System.out.println(line+f.nextLine());
                if(f.hasNextLine()) {
                    if(line.length() > 6) {
                        QA_pairs.add(new String[] {line,f.nextLine()});
                    }
                }
            }
        }
    }
    
    
    public String[] questionGen(ArrayList<Scanner> catfiles) {
        Random rand = new Random();
        
        return(QA_pairs.get(rand.nextInt(QA_pairs.size())));
    }
    
    
public static void main(String[] args){
    
    String fn = null;
    
    ArrayList<Scanner> rawCatagories = new ArrayList<Scanner>();
    
    //loops through the command line args where each input is a question catagory
    for(int i=0;i<args.length;i++) {
        if (args.length == 0){
            System.out.println("The name of the input data file"
            + " should be on the command line.\nTerminating.");
            return;
         }
         else{
            try{
               fn = args[i];
               rawCatagories.add(new Scanner(new File(fn)));
            }
            catch(Exception e){
               System.out.println("Could not open the file " + fn + '.');
               return;
            }
         }
    }

    Scanner scr = new Scanner(System.in);
    
    System.out.println("Welcome to TruthSpotter! The game where you have to find the truth in a sea of lies! Tell me, How many are playing today?");
    int numP = scr.nextInt();
    
    
    //while loop to check for the correct number of players
    while(true) {
        if (numP < 2) {
           System.out.println("at least 2 players are required for play");
           numP = scr.nextInt();
        }
        else if(numP > 4) {
            System.out.println("no more than 4 players are allowed to play");
            numP = scr.nextInt();
        }
        else {
            truthSpotter game = new truthSpotter(numP,rawCatagories);//if the number of players is correct a new instance of the truthSpotter Class is made called game
            break;
        }
    }
    
     
    
        
  }
}


