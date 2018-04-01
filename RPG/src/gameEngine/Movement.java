package gameEngine;

import dataClasses.*;
import utility.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import players.*;
import gameDisplay.*;
import javax.swing.*;

public class Movement /*extends Thread*/{
	private Map map;
	private User player;
	private Monster monster;
	private TimeCounter timer;
	
	private boolean active;
	private String name;
	private int moveId;
	private int xMove, yMove;

	public Movement(Map map, User player, String name, int moveId)
	{
		this.map = map;
		this.player = player;
		active = false;
		this.name = name;
		this.moveId = moveId;
		
		// Determine the effect of this movement
		switch(moveId)
		{
		case 0: // Q key
			xMove = -1;
			yMove = 0;
			break;
		case 1: // D key
			xMove = 1;
			yMove = 0;
			break;
		case 2: // Z key
			xMove = 0;
			yMove = -1;
			break;
		case 3: // S key
			xMove = 0;
			yMove = 1;
			break;
		default: 
			System.out.println("Unknown movement - doing nothing");
			break;
		}
	}
	
	public void update()
	{
		System.out.println(this.name);
		player.setRoomInsidePositionX(player.getRoomInsidePositionX() + xMove);
		player.setRoomInsidePositionY(player.getRoomInsidePositionY() + yMove);
	}
	
	public boolean testMovement()
	{
		if(active == true)
		{
			int cellType = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+xMove][player.getRoomInsidePositionY()+yMove].type;
			Object cellContent = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+xMove][player.getRoomInsidePositionY()+yMove].content;
			if(cellType == 0 || cellType == 1) 
			{
				return false;
			}
			if(cellType == 3)
			{
				return false;
			}
			if(cellType == 4)
			{
				return false;
			}
			if(cellType == 5) 
			{
				// start the shop interface
				return false;
			}
			/*if(cellContent.getClass() == monster.getClass()) 
			{
				return false;
			}*/
			// if(cellContent.getClass() == boss.getClass)
			else
				return true;
		}
		else
			return false;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void run() {
		
	}
}
