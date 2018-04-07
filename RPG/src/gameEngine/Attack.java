package gameEngine;

import dataClasses.*;
import gameDisplay.*;
import players.*;

public class Attack {
	private Map map;
	private Spell spell;
	private int attackId;
	private String name;
	private User player;
	private int damageDealt;
	
	public Attack(Map map, User player, Spell spell, String name, int attackId) 
	{
		this.map = map;
		this.spell = spell;
		
		this.name = name;
		this.attackId = attackId;
		this.player = player;
	}
	
	public boolean testAttack() {
		if(!spell.isAvailable())
			return false;
		if(player.getCurrentManaPoints() < spell.getManaCost())
			return false;
		if(!spell.isUnlocked())
			return false;
		return true;
	}
	
	public void update(int dirX, int dirY) {
		Monster localMonster = new Monster(0, 0, 0, 0, 0, 0, false);
		switch(attackId) {
		// Basic attack
		case 0 :
			damageDealt = player.getStrength();
			localMonster = map.floors[player.getFloorPosition()].
					rooms[player.getRoomPosition()].
					roomLayout[dirX][dirY].monster;
			localMonster.setCurrentHealthPoints(localMonster.getCurrentHealthPoints() - damageDealt);
			break;
		// Ultimate
		case 1 :
			damageDealt = player.getPower() * 4;
			for(int i = -2; i <= 2; i++) {
				for(int j = -2; j <= 2; j++) {
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+i]
							[player.getRoomInsidePositionY()+j].monster;
					if(localMonster.isPresent())
						localMonster.setCurrentHealthPoints(localMonster.
								getCurrentHealthPoints() - damageDealt);
				}
			}
			player.setCurrentManaPoints(player.getCurrentManaPoints() - spell.getManaCost());
			spell.setCurrentCooldown(spell.getMaxCooldown());
			break;
		// Mystic Teleport
		case 2 :
			damageDealt = player.getPower() * 2;
			int type = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()]
					.roomLayout[player.getRoomInsidePositionX()-dirX]
							[player.getRoomInsidePositionY()-dirY].type;			
			if(type != 2)
			{
				int clock = 0;
				while(type != 2) 
				{
					if(clock%2 == 0)
					{
						if(dirX > 0)
							dirX--;
						else if(dirX < 0)
							dirX++;
					}
					else
					{
						if(dirY > 0)
							dirY--;
						if(dirY < 0)
							dirY++;
					}
					clock ++;
					type = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()]
							.roomLayout[player.getRoomInsidePositionX()-dirX]
									[player.getRoomInsidePositionY()-dirY].type;
				}
			}
			player.setRoomInsidePositionX(player.getRoomInsidePositionX() - dirX);
			player.setRoomInsidePositionY(player.getRoomInsidePositionY() - dirY);
			for(int i = -1; i <= 1; i++)
			{
				for(int j = -1; j <= 1; j++)
				{
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+i]
							[player.getRoomInsidePositionY()+j].monster;
					if(localMonster.isPresent())
						localMonster.setCurrentHealthPoints(localMonster.
								getCurrentHealthPoints() - damageDealt);
				}
			}
			player.setCurrentManaPoints(player.getCurrentManaPoints() - spell.getManaCost());
			spell.setCurrentCooldown(spell.getMaxCooldown());
			break;
		// Self-heal
		case 3 :
			damageDealt = player.getPower() * 3;
			player.setCurrentHealthPoints(player.getCurrentHealthPoints() + damageDealt);
			player.setCurrentManaPoints(player.getCurrentManaPoints() - spell.getManaCost());
			spell.setCurrentCooldown(spell.getMaxCooldown());
			break;
		// Kick Slash
		case 4 :
			damageDealt = (player.getStrength() + 5)*2;
			for(int i = -1; i <= 1; i++) {
				if(dirX == 0)
				{
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+i]
							[player.getRoomInsidePositionY()+dirY].monster;
				}
				else
				{
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+dirX]
							[player.getRoomInsidePositionY()+i].monster;
				}	
				if(localMonster.isPresent())
					localMonster.setCurrentHealthPoints(localMonster.
							getCurrentHealthPoints() - damageDealt);
			}
			spell.setCurrentCooldown(spell.getMaxCooldown());
			break;
		}
		System.out.println("You used : " + name);
	}
}
