import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener
{
	private boolean slow = false;
	private boolean fast = false;
	private boolean isJumping = false;
	int currentLevel = 0;
	int currentSprite = 0;
	private int score = 0;
	private int delay = 25;
	private int count = 0;
	private int baseScore = 2;
	private int dX = 2;
	private int dY = 0;
	private int playerY = 350;
	private double progress = 0;
	protected Timer timer;
	private Image standingImg;
	private Image crouchingImg;

	private int currLevel = 0;
	private int maxLevel = 11;
	private int mapX[][] = { { 0, 1100, 1425, 1650, 1850, 2100, 2500, 2700, 2850, 3250, 3600 }, {}, {} };
	private int mapY[][] = { { 450, 450, 430, 410, 510, 560, 500, 440, 400, 350, 380 }, {}, {} };
	private int mapWidth[][] = { { 1000, 250, 150, 100, 200, 350, 150, 50, 300, 250, 2000 }, {}, {} };
	private int mapHeight[][] = { { 150, 150, 170, 190, 90, 40, 100, 160, 200, 250, 220 }, {}, {} };
	private int finishLine[] = { 4600, 0, 0 };
	private int totalLength = 0;

	private String idleImg[] = { "standingBlack.png", "standingRed.png", "standingBlue.png" };
	private String crouchImg[] = { "crouchingBlack.png", "crouchingRed.png", "crouchingBlue.png" };

	public GamePanel(int lvl, int sprite)
	{
		timer = new Timer(delay, this);
		timer.start();
		currentLevel = lvl;
		currentSprite = sprite;
		crouchingImg = Toolkit.getDefaultToolkit().getImage(crouchImg[currentSprite]);
		standingImg = Toolkit.getDefaultToolkit().getImage(idleImg[currentSprite]);
		this.setFocusable(true);
		this.requestFocus();
		this.addKeyListener(new MyKeyListener());
		setTotalLength();
	}

	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);

		for (int i = 0; i < maxLevel; i++)
		{
			g.setColor(Color.black);
			g.fillRect(mapX[currentLevel][i], mapY[currentLevel][i], mapWidth[currentLevel][i],
					mapHeight[currentLevel][i]);
		}

		g.setColor(Color.red);
		g.setFont(new Font("SansSerif", Font.BOLD, 10));
		g.drawString(Integer.toString(score), 10, 25);

		playerY += dY;

		if (dY != 0)
		{
			g2d.drawImage(crouchingImg, 50, playerY, this);
		} else
			g2d.drawImage(standingImg, 50, playerY, this);

		g.setColor(Color.red);
		g.fillRect(0, 0, (int) (progress * 600), 10);

		g.setColor(Color.blue);
		g.fillRect(finishLine[currentLevel], 0, 15, 600);

		g.fillRect(584, 0, 10, 10);

		if (playerY >= 600)
		{
			g.setColor(Color.red);
			g.setFont(new Font("SansSerif", Font.BOLD, 70));
			g.drawString("GAME OVER!", 80, 300);
			baseScore = 0;
		}

		if (finishLine[currentLevel] <= -50)
		{
			g.setColor(Color.green);
			g.setFont(new Font("SansSerif", Font.BOLD, 50));
			g.drawString("LEVEL COMPLETE", 70, 300);
			baseScore = 0;
		}

	}

	public void actionPerformed(ActionEvent e)
	{
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

		if (isJumping)
		{
			dY = -2;
			count++;
		}
		if (count == 35)
		{
			count = 0;
			isJumping = false;
		} else if (!isJumping && playerY < mapY[currentLevel][currLevel] - 62)
		{
			dY = 2;
		} else if (mapX[currentLevel][currLevel] + mapWidth[currentLevel][currLevel] <= 50 && !isJumping)
		{
			dY = 2;
		} else if (playerY >= mapY[currentLevel][currLevel] - 62 && playerY <= mapY[currentLevel][currLevel] - 60)
		{
			dY = 0;
			playerY = mapY[currentLevel][currLevel] - 62;
		}

		if (mapX[currentLevel][currLevel] + mapWidth[currentLevel][currLevel] <= 15 && currLevel < maxLevel - 1)
		{
			currLevel++;
		}

		progress = (double) (totalLength - finishLine[currentLevel]) / totalLength;

		reMap();
		repaint();

	}

	class MyKeyListener extends KeyAdapter
	{

		@Override
		public void keyReleased(KeyEvent e)
		{
			char ch = e.getKeyChar();

			if (ch == 'a')
				resetSpeed();
			else if (ch == 'd')
				resetSpeed();
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			char ch = e.getKeyChar();

			if (ch == ' ')
			{
				jump();
			} else if (ch == 'a')
				goSlow();
			else if (ch == 'd')
				goFast();
			else
				resetSpeed();
		}
	}

	public void jump()
	{
		if (!isJumping && dY == 0)
		{
			isJumping = true;
			playerY--;
		}
	}

	public void reMap()
	{
		for (int i = 0; i < maxLevel; i++)
		{
			mapX[currentLevel][i] = mapX[currentLevel][i] - dX;
		}
		finishLine[currentLevel] -= dX;
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

	public void setTotalLength()
	{
		totalLength = finishLine[currentLevel];
	}
}