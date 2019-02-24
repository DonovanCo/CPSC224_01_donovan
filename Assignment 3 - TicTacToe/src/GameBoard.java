import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Creates the GUI for TicTacToe

public class GameBoard extends JFrame
{
	private PlayerPanel player;
	private BoardPanel board;
	private ButtonsPanel buttons;
	private final int WINDOW_WIDTH = 500; // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	
	public GameBoard()
	{
		// Display a title.
	    setTitle("TicTacToe"); 
	    
	    //sets the size of the frame.
	    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

	    // Specify an action for the close button.
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    // Create a BorderLayout manager.
	    setLayout(new BorderLayout());
	    
	    player = new PlayerPanel();
	    board = new BoardPanel();
	    buttons = new ButtonsPanel();
	    
	    add(player, BorderLayout.NORTH);
	    add(board, BorderLayout.CENTER);
	    add(buttons, BorderLayout.SOUTH);
	    
	    setVisible(true);
	    
	}
	
}
