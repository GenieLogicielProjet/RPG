package gameDisplay;

import gameEngine.*;
import players.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class HUD {
	private JFrame gameWindow;
	private JPanel hudPanel = new JPanel();
	
	public HUD(JFrame window)
	{
		hudPanel.setVisible(true);
		gameWindow = window;
		gameWindow.add(hudPanel);
	}
	
	public void drawHUD(Graphics g)
	{
		g.setColor(Color.pink);
	}
}
