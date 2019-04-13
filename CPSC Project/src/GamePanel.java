import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel  implements ActionListener {
	private boolean slow = false;
	private boolean fast = false;
	private int score = 0;
	private int delay = 25;
	private int count = 0;
	private int baseScore = 2;
	protected Timer timer;
	
	public GamePanel() {
		timer = new Timer(delay, this);
		timer.start();
		//addKeyListener(new MyKeyListener());
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0,0,600,600);
		g.setColor(Color.red);
		g.setFont(new Font("SansSerif", Font.BOLD, 10)); 
		g.drawString(Integer.toString(score), 10, 10);

	}
	
	public void actionPerformed(ActionEvent e) {
		count++;
		if(count%delay==0)
		{
			if(slow)
				score+=baseScore/2;
			else if(fast)
				score+=baseScore*2;
			else
				score+=baseScore;
		}
		repaint();
	}
	
	
	
}