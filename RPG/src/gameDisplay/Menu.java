package gameDisplay;

import dataClasses.*;
import gameEngine.Game;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Menu implements ActionListener{
	private boolean startGame = false;
	private boolean quitMenu = false;
	
	// Create the frame of the menu and the two buttons inside (play and quit)
	JFrame menuWindow = new JFrame();
	JPanel menuPan = new JPanel();
	JButton playButton = new JButton("Play");
	JButton quitButton = new JButton("Quit");
	
	public Menu() 
	{
		// Basic parameters of the window
		menuWindow.setVisible(true);
		menuWindow.setAlwaysOnTop(false);
		menuWindow.setTitle("RPG");
		menuWindow.setDefaultCloseOperation(menuWindow.EXIT_ON_CLOSE);
		menuWindow.setLocationRelativeTo(null);
		menuWindow.setSize(640, 480);
		menuWindow.setContentPane(menuPan);
		
		menuPan.add(playButton);
		menuPan.add(quitButton);
		playButton.addActionListener(this);
		quitButton.addActionListener(this);
		
		// menuPan.setLayout(new BoxLayout());
		menuPan.setVisible(true);
		
		playButton.setVisible(true);
		quitButton.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == playButton)
		{
			new Game();
		}
		if(e.getSource() == quitButton)
			System.exit(0);
	}
}
