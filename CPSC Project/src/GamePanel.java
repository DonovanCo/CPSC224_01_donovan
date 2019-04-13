import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener
{
	private boolean slow = false;
	private boolean fast = false;
	private int score = 0;
	private int delay = 25;
	private int count = 0;
	private int baseScore = 2;
	private int dX = 2;
	protected Timer timer;

	private int mapX[] = { 0 };
	private int mapY[] = { 450 };

	public GamePanel()
	{
		timer = new Timer(delay, this);
		timer.start();
		addKeyListener(new MyKeyListener());
		setFocusable(true);
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.black);
		g.fillRect(mapX[0], mapY[0], 1000, 150);
		g.setColor(Color.red);
		g.setFont(new Font("SansSerif", Font.BOLD, 10));
		g.drawString(Integer.toString(score), 10, 10);

	}

	public void actionPerformed(ActionEvent e)
	{
		count++;
		if (slow)
		{
			score += baseScore / 2;
			dX = baseScore / 2;
		} else if (fast)
		{
			score += baseScore * 2;
			dX = baseScore * 2;
		} else
		{
			score += baseScore;
			dX = baseScore;
		}
		reMap();
		repaint();
	}

	class MyKeyListener extends KeyAdapter
	{

		@Override
		public void keyReleased(KeyEvent e)
		{
			resetSpeed();
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			char ch = e.getKeyChar();
			if (ch == 'a')
				goSlow();
			else if (ch == 'd')
				goFast();
			else
				resetSpeed();
		}
	}

	public void reMap()
	{
		for (int i = 0; i < 1; i++)
		{
			mapX[i] = mapX[i] - dX;
		}
	}

	public void goSlow()
	{
		slow = true;
		fast = false;
	}

	public void goFast()
	{
		slow = false;
		fast = true;
	}

	public void resetSpeed()
	{
		slow = false;
		fast = false;
	}
}