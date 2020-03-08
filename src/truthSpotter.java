import java.io.File;
import java.util.*;
import java.awt.event.KeyEvent;

public class truthSpotter {
    
    static int answerPoints = 5;
    static int bonusPoints = 5;
    
    public ArrayList<playerCharacters> players = new ArrayList<playerCharacters>();// list of players in the game
    
    private char[][] play_key_pairs = {{'q','s'},{'x','c'},{'n','m'},{'l','p'}};//key pairs for yes and no the left key for yes and the right key for no
    
    public ArrayList<String> askedQuestions = new ArrayList<String>();
    
    private ArrayList<String[]> QA_pairs = new ArrayList<String[]>();// pairs of questions and answer arrays pulled from the given resource files
    
    public truthSpotter(int numPlayers, ArrayList<Scanner> catfiles) {
        //initializes everything in the game
        // feed this method number of players and the rawCatagories list of scanners
        Scanner scr = new Scanner(System.in);
        for(int i=0;i<numPlayers;i++) {
            System.out.println("Please enter player "+i+"'s name");
            String name = scr.next();
            players.add(new playerCharacters(name, play_key_pairs[i][0], play_key_pairs[i][1]));
        }
        //TODO!!
        // the following searches through the catagory files 
        //and is intended to add a string array to the QA_pairs list with index 0 the question and index 1 the answer
        for(Scanner f : catfiles) {
            String word = "";
            while(f.hasNext()) {
                //System.out.println(word);
                String cword = f.next();
                
                System.out.println(cword);
                if(f.hasNext()) {
                    System.out.println(cword.contains("true") || cword.contains("false"));
                    if(cword.contains("true") || cword.contains("false")){
                        QA_pairs.add(new String[] {word,cword});
                        word = "";
                    }
                    else{
                        word += " "+cword;
                    }
                }
            }
        }
    }
    
    public void ask_question() {
        //asks random question and answer pairs from QA_pairs
        //users each enter in they're yes or no key and if you're 
        //key is found in the string and is correct points are added to your total
        Scanner scr = new Scanner(System.in);
        Random rand = new Random();
        String[] QA = QA_pairs.get(rand.nextInt(QA_pairs.size()));
        for(int i=0;i<askedQuestions.size();i++) {
            if(askedQuestions.get(i) == QA[0]){
                QA = QA_pairs.get(rand.nextInt(QA_pairs.size()));
                i=0;
            }
        }
        askedQuestions.add(QA[0]);
        System.out.println(QA[0]+"\n \n press enter when everyone has entered theyre answer");
        String answers = scr.next();
        int points = answerPoints;
        for(int i=0;i<answers.length();i++) {
            if(i == 0) {
               points = answerPoints+bonusPoints;
            }
            for(playerCharacters player : players) {
                System.out.println(QA[1]);
                if(player.getTrue() == answers.charAt(i)){ 
                    if(QA[1] == "true") {
                        player.scoreUp(points);
                    }
                }
                if(player.getFalse() == answers.charAt(i)){
                    if(QA[1] == "false") {
                        player.scoreUp(points);
                    }
                }
                System.out.println(player.getScore());
            }
            System.out.println(QA[0]+QA[1]);
        }
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
            break;
        }
    }
    
    truthSpotter game = new truthSpotter(numP,rawCatagories);//if the number of players is correct a new instance of the truthSpotter Class is made called game
    
    while(true) {
        game.ask_question();
    }
        
  }
}


