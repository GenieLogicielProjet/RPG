package gameEngine;

import javax.swing.*;
import utility.*;
import java.util.*;
import java.awt.*;
import gameDisplay.*;
import dataClasses.*;
import players.*;
import java.awt.event.*; 

public class Game extends Thread implements KeyListener, MouseListener{
	// Both of these should only be initialized once (see : Singleton Pattern)
	public Map map = new Map();
	public User player = new User(20, 0, 0, 25, 10);
	
	// Panel of the game
	private GameDisplay displayer = new GameDisplay(map, player);
	
	// Array of the 4 different moves
	private Movement[] moves = new Movement[4];
	private Attack []attacks = new Attack[5];
	
	// Utility variables
	private boolean quit = false;
	private int numberOfSimultaneousMoves = 0;
	private long lastCall = 0;
	private long now;
	private long generalNow;
	private long generalThen = 0;
	private long elapsedTime;
	private boolean start = true;
	private boolean aiming;
	private int currentSpellAiming;
	
	private HUD headUpDisplay;
	private LifeBar lifeBar;
	private ManaBar manaBar;
	private XpBar xpBar;
	
	private int playerSpeed = player.getSwiftness() * 10000000;
	
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
		headUpDisplay = new HUD();
		lifeBar = new LifeBar();
		manaBar = new ManaBar();
		xpBar = new XpBar();
		headUpDisplay.setXpBar(xpBar);
		headUpDisplay.setManaBar(manaBar);
		// Displayer is used to draw every time it is possible
		//gameWindow.setContentPane(displayer);
		//gameWindow.addKeyListener(this);
		headUpDisplay.setHpBar(lifeBar);
		headUpDisplay.setGameView(displayer);
		headUpDisplay.createHUD();
		headUpDisplay.addKeyListener(this);
		
		// Displayer is used to draw every time it is possible
		// gameWindow.addKeyListener(this);
		displayer.addMouseListener(this);
		
		// Define all the 4 different movement types
		moves[0] = new Movement(map, player, "left", 0);
		moves[1] = new Movement(map, player, "right", 1);
		moves[2] = new Movement(map, player, "up", 2);
		moves[3] = new Movement(map, player, "down", 3);
				
		// Define all the different spells
		attacks[0] = new Attack(map, player, player.spells[0], "Basic Attack", 0);
		attacks[1] = new Attack(map, player, player.spells[1], "Ultimate Spell", 1);
		attacks[2] = new Attack(map, player, player.spells[2], "Mystic Teleport", 2);
		attacks[3] = new Attack(map, player, player.spells[3], "Smart Allocation", 3);
		attacks[4] = new Attack(map, player, player.spells[4], "Kick Slash", 4);

		// Game keeps running until the user quits
		while(!quit)
		{
			// Define Then on the first loop
			if(start) {
				generalThen =  System.nanoTime();
				start = false;
			}
			this.run();
			generalNow = System.nanoTime();
			elapsedTime = generalNow - generalThen;
			generalThen = generalNow;
			updateGame(elapsedTime);
		}
		System.exit(0);
	}
	
	// Used for doing several actions at a time ; this part prints the interface
	public void run() {
		displayer.removeAll();
		displayer.revalidate();
		displayer.repaint();
		lifeBar.removeAll();
		lifeBar.revalidate();
		lifeBar.repaint();
		manaBar.removeAll();
		manaBar.revalidate();
		manaBar.repaint();
		xpBar.removeAll();
		xpBar.revalidate();
		xpBar.repaint();
		headUpDisplay.repaint();
	}
	
	// Updates all the classes with the time that has passed since the last game loop
	public void updateGame(long elapsedTime)
	{
		playerSpeed = player.getSwiftness() * 10000000;
		for(int i = -1; i < player.getRoomPosition(); i++)
		{
			for(int j = 0; j < 16; j++)
			{
				for(int k = 0; k < 15; k++)
				{
					map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[j][k].monster.update(elapsedTime);	
				}
			}
		}
		player.update(elapsedTime);
	}
	
	public void aimed() {
		aiming = false;
	}
	
	
	/***********************************************************************
	 *	 Here is the part where we handle all the key presses by the user  *
	 *   We use a passive listener that is called anytime an event occurs  *
	 *   																   *
	 ***********************************************************************/
	
	@Override
	public void keyPressed(KeyEvent e) {
		// Handles only the latest move
		
		if(numberOfSimultaneousMoves <= 1)
		{
			numberOfSimultaneousMoves = 0;
			switch(e.getKeyCode()) 
			{
			case KeyEvent.VK_Q:
				moves[0].setActive(true);
				
				// Stop all other events
				moves[1].setActive(false);
				moves[2].setActive(false);
				moves[3].setActive(false);
				
				// Check if the movement is possible
				if(moves[0].testMovement()) {
					now = System.nanoTime();
					// Start a timer to wait 200ms before moving again
					// in order to avoid moving too fast.
					if(now - lastCall >= playerSpeed)
					{
						// Update the player's position
						moves[0].update();
						lastCall = System.nanoTime();
					}
					else
						now = System.nanoTime();
				}
				break;
			case KeyEvent.VK_D:
				moves[1].setActive(true);
				
				moves[0].setActive(false);
				moves[2].setActive(false);
				moves[3].setActive(false);
				
				if(moves[1].testMovement()) {
					now = System.nanoTime();
					// Start a timer to wait 200ms before moving again
					// in order to avoid moving too fast.
					if(now - lastCall >= playerSpeed)
					{
						// Update the player's position
						moves[1].update();
						lastCall = System.nanoTime();
					}
					else
						now = System.nanoTime();
				}
				break;
			case KeyEvent.VK_Z:
				moves[2].setActive(true);
				
				moves[0].setActive(false);
				moves[1].setActive(false);
				moves[3].setActive(false);
				if(moves[2].testMovement()) {
					now = System.nanoTime();
					// Start a timer to wait 200ms before moving again
					// in order to avoid moving too fast.
					if(now - lastCall >= playerSpeed)
					{
						// Update the player's position
						moves[2].update();
						lastCall = System.nanoTime();
					}
					else
						now = System.nanoTime();
				}
				break;
			case KeyEvent.VK_S:
				moves[3].setActive(true);
				
				moves[0].setActive(false);
				moves[1].setActive(false);
				moves[2].setActive(false);
				if(moves[3].testMovement()) {
					now = System.nanoTime();
					// Start a timer to wait 200ms before moving again
					// in order to avoid moving too fast.
					if(now - lastCall >= 200000000)
					{
						// Update the player's position
						moves[3].update();
						lastCall = System.nanoTime();
					}
					else
						now = System.nanoTime();
				}
				break;
			case KeyEvent.VK_ESCAPE :
				quit = true;
			}
			
			// Count the number of buttons being pressed
			for(int i = 0; i < 4; i++) {
				if(moves[i].isActive() == true)
					numberOfSimultaneousMoves ++;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		// Handles the 4 times of movement
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
			
		// Handles the different attacks
		case KeyEvent.VK_R:
			if(attacks[1].testAttack())
				attacks[1].update(0, 0);
			break;
		case KeyEvent.VK_SPACE:
			if(attacks[2].testAttack())
			{
				aiming = true;
				currentSpellAiming = 2;
			}
			break;
		case KeyEvent.VK_A:
			// DELETE THIS LOOP
			while(player.getLevel() < 15)
			{
				player.levelUp();
			}
			if(attacks[4].testAttack())
			{
				aiming = true;
				currentSpellAiming = 4;
			}
			break;
		case KeyEvent.VK_E:
			if(attacks[3].testAttack())
				attacks[3].update(0, 0);
			break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// Serves no purpose
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!aiming) {
			if(attacks[0].testAttack())
			{
				int xLocation = arg0.getX() / 48;
				int yLocation = arg0.getY() / 48;
				if((Math.abs(player.getRoomInsidePositionX() - xLocation) <= 1) && (Math.abs(player.getRoomInsidePositionY() - yLocation) <= 1))
					attacks[0].update(xLocation, yLocation);
			}
		}
		else
		{
			int dirX = arg0.getX()/48;
			int dirY = arg0.getY()/48;
			int x = player.getRoomInsidePositionX() - dirX;
			int y = player.getRoomInsidePositionY() - dirY;
			if(currentSpellAiming == 2) {
				if(Math.abs(x) <= 3 && Math.abs(y) <= 3) {
					attacks[currentSpellAiming].update(x, y);
				}
				currentSpellAiming = -1;
			}
			if(currentSpellAiming == 4) {
				if(Math.abs(x) == 1 ^ Math.abs(y) == 1)
				{
					attacks[currentSpellAiming].update(x, y);
				}
				currentSpellAiming = -1;
			}
			aiming = false;
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
