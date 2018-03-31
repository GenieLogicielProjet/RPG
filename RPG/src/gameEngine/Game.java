package gameEngine;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import gameDisplay.*;
import dataClasses.*;
import players.*;
import java.awt.event.*;
import java.awt.event.KeyEvent; 

public class Game extends Thread{
	public long now;
	public long then;
	public long frameTime;
	public long frameRate;
	
	// Both of these should only be initialized once (see : Singleton Pattern)
	public Map map = new Map();
	public User player = new User();
	
	private RoomDisplay displayer = new RoomDisplay(map, player);
	private Movement movement;
	
	private boolean quit = false;
	
	public Game() {		
		// Window of the whole Game (including HUD and Playable part)
		JFrame gameWindow = new JFrame();
		
		// Debug : print the layout of each room
		map.printMap(map);
		
		// Initialize the basic parameters
		gameWindow.setVisible(true);
		gameWindow.setSize(1280, 960);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			// To measure time
			// Put code between the two measures for maximum accuracy
			then = System.nanoTime();
			
			// Caution : May loop forever - for now, stop with xkill command
			this.run();
			System.out.println("Frame refreshed");
			
			// Use this as a time unit
			now = System.nanoTime();
			frameTime = now - then;
			frameRate = 1 / frameTime;
		}
		System.exit(0);
	}
	public void run() {
		displayer.removeAll();
		displayer.revalidate();
		displayer.repaint();	
	}
}
