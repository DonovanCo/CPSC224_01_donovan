import java.awt.*;
import javax.swing.*;

// Creates the 3x3 TicTacToe Board.

public class BoardPanel extends JPanel
{
	private JButton b11;
	private JButton b12;
	private JButton b13;
	private JButton b21;
	private JButton b22;
	private JButton b23;
	private JButton b31;
	private JButton b32;
	private JButton b33;
	
	public BoardPanel()
	{
		setLayout(new GridLayout(3,3));
		
		b11 = new JButton("");
		b12 = new JButton("");
		b13 = new JButton("");
		b21 = new JButton("");
		b22 = new JButton("");
		b23 = new JButton("");
		b31 = new JButton("");
		b32 = new JButton("");
		b33 = new JButton("");
		
		b11.setEnabled(false);
		b12.setEnabled(false);
		b13.setEnabled(false);
		b21.setEnabled(false);
		b22.setEnabled(false);
		b23.setEnabled(false);
		b31.setEnabled(false);
		b32.setEnabled(false);
		b33.setEnabled(false);
		
		add(b11);
		add(b12);
		add(b13);
		add(b21);
		add(b22);
		add(b23);
		add(b31);
		add(b32);
		add(b33);
	}
}
