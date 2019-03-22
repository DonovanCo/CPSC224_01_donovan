import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
			g.fillOval(230 + (int)(xOffset*.05), 30+ (int)(yOffset*.05), 30, 30);
			// First mountain
			g.setColor(Color.GRAY);
			g.fillPolygon(mountainOneX, mountainOneY, 3);
			// Second Mountain
			g.setColor(Color.DARK_GRAY);
			g.fillPolygon(mountainTwoX, mountainTwoY, 3);
			// Ground
			g.setColor(Color.green);
			g.fillRect(-60 + (int)(xOffset*.4), 200 + (int)(yOffset*.4), 420, 150);
			// Tree
			g.setColor(Color.getHSBColor((float)38, (float).545, (float).43));
			g.fillRect(25 + (int)(xOffset*.5), 215 + (int)(yOffset*.5), 10, 40);
			g.setColor(Color.red);
			g.fillOval(15 + (int)(xOffset*.5), 180 + (int)(yOffset*.5), 30, 55);
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
	    	  xOffset = e.getX() - 150;
	    	  yOffset = e.getY() - 150;
	      }
	   }
	 
}