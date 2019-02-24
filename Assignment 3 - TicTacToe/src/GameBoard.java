import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.*;

//Creates the GUI for TicTacToe

public class GameBoard extends JFrame
{
	private PlayerPanel player;
	private BoardPanel board;
	private final int WINDOW_WIDTH = 500; // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	
	private JButton newgame;
	private JButton reset;
	private JButton exit;
	private JPanel buttons;
	private JPanel bottomPanel;
	private JLabel status;
	
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
	    createButtonsPanel();
	    
	    add(player, BorderLayout.NORTH);
	    add(board, BorderLayout.CENTER);
	    add(bottomPanel, BorderLayout.SOUTH);
	    
	    setVisible(true);
	}
	
	private void createButtonsPanel()
	{		
		// create a panel for buttons and set to center flow layout
		buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		// create buttons for new game, reset, and exit
		newgame = new JButton("New Game");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		
		// Register an event listener with all 3 buttons.
		newgame.addActionListener(new newButtonListener());
		reset.addActionListener(new resetButtonListener());
		exit.addActionListener(new exitButtonListener());
		
		// add buttons to buttons panel
		buttons.add(newgame);
		buttons.add(reset);
		buttons.add(exit);
		
		//create status label for bottom
		status = new JLabel("status");
		status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		bottomPanel = new JPanel(new BorderLayout());
		
		// add buttons and status bar to bottomPanel
		bottomPanel.add(buttons, BorderLayout.CENTER);
		bottomPanel.add(status, BorderLayout.SOUTH);
	}
	
	private class newButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player.setEditable(false); // prohibit name changes
			
			
		}
	}
	
	private class resetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player.reset(); // sets win counts to 0
			clearBoard();
		}
	}
	
	private class exitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}
