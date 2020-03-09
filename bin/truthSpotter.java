import java.io.File;
import java.util.*;
import java.awt.event.KeyEvent;

public class truthSpotter {

	static int answerPoints = 100;
	static int bonusPoints = 75;
	
	
	//Creates an arrayList to store our string values for questions and answers
	private ArrayList<String[]> QA_pairs = new ArrayList<String[]>();
	
	//Creates an arrayList to store our characters 
	public ArrayList<playerCharacters> players = new ArrayList<playerCharacters>();

	private char[][] play_key_pairs = { { 'q', 's' }, { 'x', 'c' }, { 'n', 'm' }, { 'l', 'p' } };// key pairs for yes
																									// and no the left
																									// key for yes and
																									// the right key for
																									// no

	public truthSpotter(int numPlayers, ArrayList<Scanner> catfiles) {
		// initializes everything in the game
		// feed this method number of players and the rawCatagories list of scanners

		Scanner scr = new Scanner(System.in);

		// Creates the playerCharacters based on number entered
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Please enter player " + (i+1) + "'s name");
			String name = scr.next();
			players.add(new playerCharacters(name, play_key_pairs[i][0], play_key_pairs[i][1], 0));
		}
		// the following searches through the catagory files
		// and is intended to add a string array to the QA_pairs list with index 0 the
		// question and index 1 the answer
		String prevLine;
		String currLine = null;
		
		for (Scanner f : catfiles) {
			while (f.hasNext()) {
				prevLine = currLine;
				currLine = f.nextLine();
				
				if (currLine.contains("true")|| currLine.contains("false")){
					QA_pairs.add(new String[] { prevLine, currLine });
				}
				
			}
		}

	}

	public void ask_question() {
		// asks random question and answer pairs from QA_pairs
		// users each enter in they're yes or no key and if you're
		// key is found in the string and is correct points are added to your total
		Scanner scr = new Scanner(System.in);
		Random rand = new Random();
		
		//Gets a question number from the randomizer
		int questionNum = rand.nextInt(QA_pairs.size());
		
		//Gets a Q/A pair based on the random rolled
		String[] QA = QA_pairs.get(questionNum);
		
		
		
		System.out.println(QA[0] + "\n \n Press Enter when everyone has entered their answer.");
		String answers = scr.next();
		
		int points = answerPoints;
		System.out.println("The answer is: " + QA[1]);
		for (int i = 0; i < answers.length(); i++) {
			if (i == 0) {
				points = answerPoints + bonusPoints;
			}
			for (playerCharacters player : players) {
				if (player.getTrue() == answers.charAt(i)) {
					if (QA[1] == "true") {
						player.setScore(player.getScore() + points);
					}
				}
				if (player.getFalse() == answers.charAt(i)) {
					if (QA[1] == "false") {
						player.setScore(player.getScore() + points);
					}
				}

			}
		}
		System.out.println("Current scores are:");
		for (playerCharacters player : players) {
			System.out.println(player.getName()  + ": " +  player.getScore());
		}
		QA_pairs.remove(questionNum);
		
		System.out.println("\n\nThe next question is: ");
	}

	public static void main(String[] args) {

		String fn = null;

		ArrayList<Scanner> rawCatagories = new ArrayList<Scanner>();

		// loops through the command line args where each input is a question catagory
		for (int i = 0; i < args.length; i++) {
			if (args.length == 0) {
				System.out.println("The name of the input data file" + " should be on the command line.\nTerminating.");
				return;
			} else {
				try {
					fn = args[i];
					rawCatagories.add(new Scanner(new File(fn)));
				} catch (Exception e) {
					System.out.println("Could not open the file " + fn + '.');
					return;
				}
			}
		}

		Scanner scr = new Scanner(System.in);

		System.out.println(
				"Welcome to TruthSpotter! The game where you have to find the truth in a sea of lies! Tell me, How many are playing today?");
		int numP = scr.nextInt();

		// while loop to check for the correct number of players
		while (true) {
			if (numP < 2) {
				System.out.println("At least 2 players are required for play.");
				numP = scr.nextInt();
			} else if (numP > 4) {
				System.out.println("No more than 4 players are allowed to play.");
				numP = scr.nextInt();
			} 
			else {
				break;
			}
		}

		truthSpotter game = new truthSpotter(numP, rawCatagories);// if the number of players is correct a new instance
																	// of the truthSpotter Class is made called game

		while (true) {
			game.ask_question();
		}

	}
}
