import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Creates the GUI for TicTacToe

public class GameBoard extends JFrame
{
	
	public GameBoard()
	{
		// Display a title.
	    setTitle("TicTacToe");
	    
	    //sets the size of the frame.
	    setSize(500, 500);

	    // Specify an action for the close button.
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Create a BorderLayout manager.
	    setLayout(new BorderLayout());
	}
	
}
