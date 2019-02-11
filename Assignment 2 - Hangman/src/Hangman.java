
/*******************************************************************
	Homework #2
	Due Date: 02-11-2019
	Names: Ian Gioffre and Cole Donovan
	Repo URL: https://github.com/DonovanCo/CPSC224_01_donovan.git
*******************************************************************/

import javax.swing.JOptionPane;

public class Hangman
{

	// main: serves only to call other functions
	// to run the main hangman game.
	public static void main(String[] args)
	{
		while(true)
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
		String input = null;
		int choice = 0;
		
		while(choice < 1 || choice > 3)
		{
			input = JOptionPane.showInputDialog("Welcome to Hangman!\n"
												+ "1. Play a game with a random word\n"
												+ "2. Play a game with a word from another person\n"
												+ "3. Exit the game\n"
												+ "Enter the number of your choice");
			choice = Integer.parseInt(input);
			
			if(choice < 1 || choice > 3)
				JOptionPane.showMessageDialog(null, "That is not an option. Please try again.");
		}
		
		switch(choice)
		{
			case 1: 
				Player randomGame = new Player(randomWord());
				playGame(randomGame);
				break;
			case 2:
				Player inputGame = new Player(getPlayerWord());
				playGame(inputGame);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Thanks for playing!");
				System.exit(0);
				break;
		}
		
		JOptionPane.showMessageDialog(null, "Thanks for playing!");
	}
	
	public static String getPlayerWord()
	{
		return JOptionPane.showInputDialog("Enter a word for another player to guess.");
	}
	
	public static String hangman(int strikes)
	{
		String output = null;
		
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
	
	public static char getPlayerGuess(Player game)
	{
		String dummy = game.getDummyWord();
		String input = null;
		char guess = ' ';
		
		while(!( ((int) guess >= 65 && (int) guess <= 90) || ((int) guess >= 97 && (int) guess <= 122)))
		{
			input = JOptionPane.showInputDialog(dummy + "\n" + hangman(game.getStrikes()) + "Enter your guess");
			guess = input.charAt(0);
			
			if(!( ((int) guess >= 65 && (int) guess <= 90) || ((int) guess >= 97 && (int) guess <= 122)))
				JOptionPane.showMessageDialog(null, "That is not a valid guess. Please try again.");
		}
		
		return guess;
	}
	
	public static void playGame(Player game)
	{
		while(game.getStrikes() < 6 && game.isNotEqual())
		{
			char guess;
			guess = getPlayerGuess(game);
			
			if(game.isFoundInWord(guess))
			{
				game.setDummyCharacter(guess);
				JOptionPane.showMessageDialog(null, "Nice! That letter is in the word.");
			}
			else
			{
				game.setStrikes(game.getStrikes() + 1);
				JOptionPane.showMessageDialog(null, "That letter is not in the word. Please try again.");
			}
		}
		
		gameEnd(game);
	}
	
	public static void gameEnd(Player game)
	{
		if(game.getStrikes() >=6)
			JOptionPane.showMessageDialog(null, "You lost! The word was " + game.getGuessWord() + ".\n" + hangman(game.getStrikes()));
		else
			JOptionPane.showMessageDialog(null, "You won! The word was " + game.getGuessWord() + ". Congratulations!");
	}

}