
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
			JOptionPane.showMessageDialog(null, "Welcome to Hangman!");
			JOptionPane.showMessageDialog(null, "1. Play a game with a random word");
			JOptionPane.showMessageDialog(null, "2. Play a game with a word from a friend");
			JOptionPane.showMessageDialog(null, "3. Exit the game");
			JOptionPane.showInputDialog("Enter the number of your choice");
			
			switch(choice)
			{
				case 1: 
					
			}
		}
	}
	
	public static char[] getPlayerWord()
	{
		
	}
	
	public static void showHangman()
	{
		
	}
	
	public static void playGame(char[] word)
	{
		
	}

}