package gameEngine;

import dataClasses.*;
import utility.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import players.*;
import gameDisplay.*;
import javax.swing.*;

public class Movement{
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
		player.setRoomInsidePositionX(player.getRoomInsidePositionX() + xMove);
		player.setRoomInsidePositionY(player.getRoomInsidePositionY() + yMove);	
	}
	
	public boolean testMovement()
	{
		if(active == true)
		{
			Monster cellContent = new Monster(0, 0, 0, 0, 0, 0, false);
			int cellType = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+xMove][player.getRoomInsidePositionY()+yMove].type;
			cellContent = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+xMove][player.getRoomInsidePositionY()+yMove].monster;
			if(cellType == 0 || cellType == 1) 
			{
				return false;
			}
			if(cellType == 3)
			{
				player.setRoomPosition(player.getRoomPosition() - 1);
				System.out.println(player.getRoomPosition());
				//player.getRoomPosition()+1;
				//player.setRoomPosition(player.getRoomplayer.setRoomPosition() = Position() - 1);
				
				return true;
			}
			if(cellType == 4)
			{
				player.setRoomPosition(player.getRoomPosition() + 1);
				System.out.println(player.getRoomPosition());
				 
				return false;
			}
			if(cellType == 5) 
			{
				player.setRoomPosition(player.getRoomPosition() + 2);
				// start the shop interface
				return true;
			}
			if(cellType == 6) 
			{
				player.setRoomPosition(player.getRoomPosition() - 2);
				System.out.println(player.getRoomPosition());
				// start the shop interface
				return true;
			}
			if(cellType == 7) 
			{
				if(player.getFloorPosition()!= 2){
					player.setRoomPosition(0);
					player.setFloorPosition(player.getFloorPosition()+1);
				}
				// start the shop interface
				return true;
			}
			if(cellType == 8) 
			{
				if(player.getFloorPosition()!= 0){
					player.setRoomPosition(map.getLastRoom(map.floors[player.getFloorPosition()-1])); 
					player.setFloorPosition(player.getFloorPosition()-1);
				}
				// start the shop interface
				return true;
			}
			if(cellType == 9) 
			{
				// start the shop interface
				return false;
			}
			if(cellType == 10) 
			{
				// start the shop interface
				return false;
			}
			if(cellContent.isPresent()) 
			{
				return false;
			}
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
}