import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import DrawBoxes.MyMouseListener;
import DrawBoxes.MyMouseMotionListener;

public class ParallaxPanel extends JPanel implements ActionListener {

	private int delay = 25; // Timer should update 40 times per second
	protected Timer timer;
	
	private int xOffset = 0;
	private int yOffset = 0;
	
	private int [] OriginOneX = {0, 100, 200};
	private int [] OriginOneY = {300, 75, 300};
	private int [] OriginTwoX = {100, 200, 300};
	private int [] OriginTwoY = {300, 95, 300}; 
	
	private int [] mountainOneX = {0, 100, 200};
	private int [] mountainOneY = {300, 75, 300};
	private int [] mountainTwoX = {100, 200, 300};
	private int [] mountainTwoY = {300, 95, 300}; 
	
	ParallaxPanel()
	{
		timer = new Timer(delay, this);
		timer.start();
		addMouseListener(new MyMouseListener());
	    addMouseMotionListener(new MyMouseMotionListener());
	}
	
	public void paint(Graphics g)
	   {   
			// Draws the different layers
			// Skybox
			g.setColor(Color.cyan);
			g.fillRect(0, 0, 300, 300);
			//Sun
			g.setColor(Color.yellow);
			g.fillOval(230 + (int)(xOffset*.10), 30+ (int)(yOffset*.10), 30, 30);
			// First mountain
			g.setColor(Color.GRAY);
			g.fillPolygon(mountainOneX, mountainOneY, 3);
			// Second Mountain
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(mountainTwoX, mountainTwoY, 3);
			// Ground
			g.setColor(Color.green);
			g.fillRect(-50 + (int)(xOffset*.6), 200 + (int)(yOffset*.6), 400, 100);
			// Tree
			g.setColor(Color.getHSBColor((float)38, (float).545, (float).43));
			g.fillRect(25 + (int)(xOffset*.7), 215 + (int)(yOffset*.7), 10, 40);
			g.setColor(Color.red);
			g.fillOval(15 + (int)(xOffset*.7), 180 + (int)(yOffset*.7), 30, 55);
	   }
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	 private class MyMouseListener implements MouseListener
	   {
	      public void mousePressed(MouseEvent e)
	      {
	      }

	      public void mouseClicked(MouseEvent e)
	      {
	      }

	      public void mouseReleased(MouseEvent e)
	      {
	      }

	      public void mouseEntered(MouseEvent e)
	      {
	      }

	      public void mouseExited(MouseEvent e)
	      {
	      }
	   }

	   private class MyMouseMotionListener implements MouseMotionListener
	   {
	      public void mouseDragged(MouseEvent e)
	      {
	      }
	      
	      public void mouseMoved(MouseEvent e)
	      {
	      }
	   }
	 
}