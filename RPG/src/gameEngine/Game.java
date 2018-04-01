package gameEngine;

import javax.swing.*;
import utility.*;
import java.util.*;
import java.awt.*;
import gameDisplay.*;
import dataClasses.*;
import players.*;
import java.awt.event.*;
import java.awt.event.KeyEvent; 

public class Game extends Thread implements KeyListener{
	public long now;
	public long then;
	public long frameTime;
	public long frameRate;
	private TimeCounter timer;
	
	// Both of these should only be initialized once (see : Singleton Pattern)
	public Map map = new Map();
	public User player = new User();
	
	// Panel of the game
	private RoomDisplay displayer = new RoomDisplay(map, player);
	
	// Array of the 4 different moves
	private Movement[] moves = new Movement[4];
	
	private boolean quit = false;
	private int numberOfSimultaneousMoves = 0;
	
	public Game() {		
		// Window of the whole Game (including HUD and Playable part)
		JFrame gameWindow = new JFrame();
		
		// Debug : print the layout of each room
		// map.printMap(map);
		
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
		gameWindow.addKeyListener(this);
		
		// Define all the 4 different movement types
		moves[0] = new Movement(map, player, "left", 0);
		moves[1] = new Movement(map, player, "right", 1);
		moves[2] = new Movement(map, player, "up", 2);
		moves[3] = new Movement(map, player, "down", 3);
		
		// Game keeps running until the user quits
		while(!quit)
		{
			this.run();
		}
		System.exit(0);
	}
	public void run() {
		displayer.removeAll();
		displayer.revalidate();
		displayer.repaint();
		// System.out.println("frame refreshed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// Handles only the latest move
		//if(numberOfSimultaneousMoves <= 1)
		//{
			switch(e.getKeyCode()) 
			{
			case KeyEvent.VK_Q:
			//	int nbLoops;
				System.out.println(moves[0].getName());
				moves[0].setActive(true);
				
				// Stop all other events
				moves[1].setActive(false);
				moves[2].setActive(false);
				moves[3].setActive(false);
				
				// Check if the movement is possible
				if(moves[0].testMovement()) {
					moves[0].update();
					timer = new TimeCounter(500);
				}
				break;
			case KeyEvent.VK_D:
				System.out.println(moves[1].getName());
				moves[1].setActive(true);
				
				moves[0].setActive(false);
				moves[2].setActive(false);
				moves[3].setActive(false);
				if(moves[1].testMovement()) {
					moves[1].update();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				break;
			case KeyEvent.VK_Z:
				System.out.println(moves[2].getName());
				moves[2].setActive(true);
				
				moves[0].setActive(false);
				moves[1].setActive(false);
				moves[3].setActive(false);
				if(moves[2].testMovement()) {
					moves[2].update();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				break;
			case KeyEvent.VK_S:
				System.out.println(moves[3].getName());
				moves[3].setActive(true);
				
				moves[0].setActive(false);
				moves[1].setActive(false);
				moves[2].setActive(false);
				if(moves[3].testMovement()) {
					moves[3].update();
					timer = new TimeCounter(500);
				}
				break;
			}
			// Count the number of buttons being pressed
			for(int i = 0; i < 4; i++) {
				if(moves[i].isActive() == true)
					numberOfSimultaneousMoves ++;
			}
		//}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_Q:
			moves[0].setActive(false);
			break;
		case KeyEvent.VK_D:
			moves[1].setActive(false);
			break;
		case KeyEvent.VK_Z:
			moves[2].setActive(false);
			break;
		case KeyEvent.VK_S:
			moves[3].setActive(false);
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
