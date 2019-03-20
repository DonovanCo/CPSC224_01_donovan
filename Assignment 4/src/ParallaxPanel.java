import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ParallaxPanel extends JPanel implements ActionListener {

	private int delay = 25; // Timer should update 40 times per second
	protected Timer timer;
	
	public ParallaxPanel()
	{
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
	 
}