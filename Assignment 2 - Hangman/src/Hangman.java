
/****************************************
	Homework #2
	Due Date: 02-11-2019
	Names: Ian Gioffre and Cole Donovan
****************************************/

public class Hangman {

	// main: serves only to call other functions
	// to run the main hangman game.
	public static void main(String[] args) {
		// comment
		
	}
	
	public static String randomWord()
	{
		String list[] = {"psychic", "gonzaga", "coding", "hemmingson", "metamorphosis", "balloon", "valentine", "chip", "extra", "bulldog"};
		int num = (int)(Math.random()*10);
		return list[num];
	}

}
