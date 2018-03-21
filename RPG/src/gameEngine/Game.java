package gameEngine;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import gameDisplay.*;
import dataClasses.*;
import players.*;
import java.awt.event.*;
import java.awt.event.KeyEvent; 

public class Game extends Thread {
	
	
	// Both of these should only be initialized once (see : Singleton Pattern)
	public Map map = new Map();
	public User player = new User();
	
	// Create the panel containing the actual game
	private RoomDisplay displayer = new RoomDisplay(map, player);
	
	private boolean quit = false;
	
	public Game() {
		// Window of the whole Game (including HUD and Playable part)
		JFrame gameWindow = new JFrame();
		
		// Debug : print the layout of each room
		map.printMap(map);
		
		// Initialize the basic parameters
		gameWindow.setVisible(true);
		gameWindow.setSize(1280, 960);
		gameWindow.setDefaultCloseOperation(gameWindow.EXIT_ON_CLOSE);
		gameWindow.setResizable(true);
		gameWindow.setLocationRelativeTo(null);
		gameWindow.setTitle("RPG");
		
		// Set up the HUD
		HUD headUpDisplay = new HUD(gameWindow);
		
		// Displayer is used to draw every time it is possible
		gameWindow.setContentPane(displayer);
		
		// Game keeps running until the user quits
		while(!quit)
		{
			// Caution : May loop forever - for now, stop with xkill command
			displayRoom();
		}
		System.exit(0);
	}
	
	public void displayRoom()
	{
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		// Update the window of the game
		displayer.removeAll();
		displayer.revalidate();
		displayer.repaint();
	}
}
