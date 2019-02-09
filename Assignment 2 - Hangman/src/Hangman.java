
/****************************************
	Homework #2
	Due Date: 02-11-2019
	Names: Ian Gioffre and Cole Donovan
	Repo URL: https://github.com/DonovanCo/CPSC224_01_donovan.git
****************************************/

import javax.swing.JOptionPane;

public class Hangman
{

	// main: serves only to call other functions
	// to run the main hangman game.
	public static void main(String[] args)
	{
		menu();
	}
	
	public static String randomWord()
	{
		String list[] = {"psychic", "gonzaga", "coding", "hemmingson", "metamorphosis", "balloon", "valentine", "chip", "extra", "bulldog"};
		int num = (int)(Math.random()*10);
		return list[num];
	}
	
	public static void menu()
	{
		String input;
		int choice;
		
		while(choice < 1 || choice > 3)
		{
			input = JOptionPane.showInputDialog("Welcome to Hangman!\n"
												+ "1. Play a game with a random word\n"
												+ "2. Play a game with a word from another person\n"
												+ "3. Exit the game\n"
												+ "Enter the number of your choice");
			choice = Integer.parseInt(input);
			
			switch(choice)
			{
				case 1: 
					Player game = new Player(randomWord());
					playGame(game.getGuessWord());
					break;
				case 2:
					Player game = new Player(getPlayerWord());
					playGame(game.getGuessWord());
					break;
				case 3:
					showMessageDialog(null, "Thanks for playing!");
					System.exit(0);
					break;
				default:
					showMessageDialog(null, "That is not an option. Try again.");
			}
		}
	}
	
	public static String getPlayerWord()
	{
		return JOptionPane.showInputDialog("Enter a word for another player to guess.");
	}
	
	public static String hangman(int strikes)
	{
		String output;
		
		switch(strikes)
		{
			case 0:
				output = "      \n"
					   + "      \n"
					   + "      \n";
				break;
			case 1:
				output = "  o   \n"
					   + "      \n"
					   + "      \n";
				break;
			case 2:
				output = "  o   \n"
			 	 	   + "  |   \n"
			 	 	   + "      \n";
				break;
			case 3:
				output = "  o   \n"
				 	   + "/ |   \n"
				 	   + "      \n";
				break;
			case 4:
				output = "  o   \n"
				 	   + "/ | \\\n"
				 	   + "      \n";
				break;
			case 5:
				output = "  o   \n"
					   + "/ | \\\n"
					   + " /    \n";
				break;
			case 6:
				output = "  o   \n"
				 	   + "/ | \\\n"
				 	   + " / \\ \n";
				break;
		}
		return output;
	}
	
	public static void playGame(char[] word)
	{
		
		
		showHangman(game.getStrikes());
	}

}