import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menuPanel extends JPanel
{
	private JPanel menu;
	private JPanel game;
	private JLabel stickSkater;
	private JPanel levelSelect;
	private ButtonGroup levels;
	private JRadioButton level1;
	private JRadioButton level2;
	private JRadioButton level3;
	private JPanel playerSelect;
	private ButtonGroup players;
	private JRadioButton player1;
	private JRadioButton player2;
	private JRadioButton player3;
	private JPanel buttons;
	private JButton playGame;
	private JButton exit;

	public menuPanel()
	{
		setLayout(new CardLayout());
		menu = new JPanel(new GridLayout(4, 1));
		game = new GamePanel();

		stickSkater = new JLabel("STICK SKATER", SwingConstants.CENTER);
		stickSkater.setFont(new Font("nameFont", Font.BOLD, 40));

		levelSelect = new JPanel(new GridLayout(3, 1));
		level1 = new JRadioButton("Level 1", true);
		level2 = new JRadioButton("Level 2");
		level3 = new JRadioButton("Level 3");
		levels = new ButtonGroup();
		levels.add(level1);
		levels.add(level2);
		levels.add(level3);
		levelSelect.add(level1);
		levelSelect.add(level2);
		levelSelect.add(level3);
		levelSelect.setBorder(BorderFactory.createTitledBorder("Level Select"));

		playerSelect = new JPanel(new GridLayout(3, 1));
		player1 = new JRadioButton("Black Player", true);
		player2 = new JRadioButton("Red Player");
		player3 = new JRadioButton("Blue Player");
		players = new ButtonGroup();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		playerSelect.add(player1);
		playerSelect.add(player2);
		playerSelect.add(player3);
		playerSelect.setBorder(BorderFactory.createTitledBorder("Player Select"));

		buttons = new JPanel();
		playGame = new JButton("Play Game");
		exit = new JButton("Exit");
		buttons.add(playGame);
		buttons.add(exit);

		playGame.addActionListener(new playListener());
		exit.addActionListener(new exitListener());

		menu.add(stickSkater);
		menu.add(levelSelect);
		menu.add(playerSelect);
		menu.add(buttons);
		
		add(menu, "MENU");
		add(game, "GAME");
	}

	public int getLevel()
	{
		if (level1.isSelected())
			return 0;
		else if (level2.isSelected())
			return 1;
		else
			return 2;
	}

	public int getPlayer()
	{
		if (player1.isSelected())
			return 0;
		else if (player2.isSelected())
			return 1;
		else
			return 2;
	}

	private class playListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			CardLayout c1 = (CardLayout)(getLayout());
			c1.show(menuPanel.this, "GAME");
		}
	}

	private class exitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}