package gameEngine;

import dataClasses.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Movement /*implements KeyListener*/{
	public Movement()
	{
		
	}
	
	public int keyTyped(KeyEvent e)
	{
		return e.getKeyCode();
	}

	public int keyReleased(KeyEvent e) 
	{
		return e.getKeyCode();package gameEngine;

import dataClasses.*;
import utility.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import players.*;
import gameDisplay.*;
import javax.swing.*;

public class Movement extends Thread implements KeyListener{
	private Map map;
	private User player;
	private JFrame gamePane;
	private TimeCounter timer;
	private boolean stopKeyListening;
	
	public Movement(JFrame pane,Map map, User player)
	{
		this.map = map;
		this.player = player;
		gamePane = pane;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int eventSource = e.getKeyCode();
		int lastNumberOfIterations = 0;
		switch(eventSource) {
		case KeyEvent.VK_Q:
			timer = new TimeCounter(50);
			timer.run();
			while(!stopKeyListening)
			{
				if(lastNumberOfIterations+1 == timer.getIterations()) {
					lastNumberOfIterations = timer.getIterations();
					if(testMovement(-1, 0)) {
						player.setRoomInsidePositionX(player.getRoomInsidePositionX()-1);
					}
				}
			}
			timer.setKeepRunning(false);
			break;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		stopKeyListening = true;
	}
	public void keyTyped(KeyEvent e) 
	{
		
	}
	public boolean testMovement(int xMove, int yMove)
	{
		int cellType = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()][player.getRoomInsidePositionY()].type;
		Object cellContent = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()][player.getRoomInsidePositionY()].content;
		if(cellType == 0 || cellType == 1) {
			return false;
		}
		if(cellType == 3)
		{
			player.setRoomPosition(player.getRoomPosition() - 1);
			return false;
		}
		if(cellType == 4)
		{
			player.setRoomPosition(player.getRoomPosition() + 1);
			return false;
		}
		if(cellType == 5) {
			// start the shop interface
			return false;
		}
		return false;
	}
	
	public void run() {
		gamePane.addKeyListener(this);
	}
}
	}

	public int keyPressed(KeyEvent e) 
	{
		return e.getKeyCode();
	}
}
