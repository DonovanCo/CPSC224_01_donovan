import java.util.Arrays;
// Player class: a simple class that will hold the number of strikes,
// word to be guessed, and the string of letters guessed so far.
  
public class Player {
	
	private int strikes;
	private int size;
	private char[] guessWord;
	private char[] dummyWord;
	
	public Player(String a)
	{
		strikes = 0;
		size = a.length();
		guessWord = new char[size];
		dummyWord = new char[size];
		for(int i = 0; i<size; i++)
		{
			guessWord[i]=a.charAt(i);
			dummyWord[i]='-';
		}
		
	}

	public int getStrikes() {
		return strikes;
	}

	public void setStrikes(int s) {
		strikes = s;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int s) {
		size = s;
	}

	public char[] getGuessWord() 
	{
		return guessWord;
	}

	public void setGuessWord(char[] guess) 
	{
		guessWord = guess;
	}

	public char[] getDummyWord() 
	{
		return dummyWord;
	}

	public void setDummyWord(char[] dummy)
	{
		dummyWord = dummy;
	}
	
	// Returns true if both char arrays are NOT equal.
	// False otherwise.
	public boolean isNotEqual()
	{
		return !Arrays.equals(guessWord, dummyWord);
	}
	
	// Returns true if the guessed char is in the word.
	public boolean isFoundInWord(char ch)
	{
		for(char i : guessWord)
		{
			if(i==ch)
				return true;
		}
		return false;
	}
	
}
