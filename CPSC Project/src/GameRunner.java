import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameRunner extends JFrame
{

	GameRunner()
	{
		setTitle("Test");

		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		GamePanel tp = new GamePanel();
		add(tp);

		setVisible(true);
	}

	public static void main(String[] args)
	{
		new GameRunner();
	}
}