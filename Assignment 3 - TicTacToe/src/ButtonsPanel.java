import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.border.EtchedBorder;

// creates the panel for the buttons to start a new game, reset the board, and exit the game

public class ButtonsPanel extends JPanel 
{
	private JButton newgame;
	private JButton reset;
	private JButton exit;
	private JPanel buttons;
	private JLabel status;
	
	public ButtonsPanel()
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
		
		setLayout(new BorderLayout());
		
		// add buttons and status bar to ButtonsPanel
		add(buttons, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
	}
	
	private class newButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	private class resetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
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
