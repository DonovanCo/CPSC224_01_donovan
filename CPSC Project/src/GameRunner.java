import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameRunner extends JFrame
{
	GameRunner()
	{
		setTitle("Stick Skate");

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		menuPanel menu = new menuPanel();
		GamePanel gp = new GamePanel(menu.getLevel(), menu.getPlayer());
		add(menu);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		new GameRunner();
	}
}