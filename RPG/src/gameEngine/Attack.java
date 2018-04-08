package gameEngine;

import dataClasses.*;
import java.util.Random;
import gameDisplay.*;
import players.*;

public class Attack {
	private Map map;
	private Spell spell;
	private int attackId;
	private String name;
	private User player;
	private int damageDealt;
	private Random random;
	
	public Attack(Map map, User player, Spell spell, String name, int attackId) 
	{
		this.map = map;
		this.spell = spell;
		
		this.name = name;
		this.attackId = attackId;
		this.player = player;
		random = new Random();
	}
	
	public boolean testAttack() {
		if(!spell.isAvailable())
		{
			System.out.println("not available");
			return false;
		}
		if(player.getCurrentManaPoints() < spell.getManaCost())
		{
			System.out.println("not enough mana");
			return false;
		}
		if(!spell.isUnlocked())
		{
			System.out.println("not unlocked yet");
			return false;
		}
		return true;
	}
	
	public void update(int dirX, int dirY) {
		// Variable used to avoid writing long lines endlessly
		Monster localMonster = new Monster(0, 0, 0, 0, 0, 0, false);
		switch(attackId) {
		// Basic attack
		case 0 :
			// Randomly deal double damage depending on the player's "agility" stat
			if(random.nextInt(100) < player.getAgility())
				damageDealt = player.getStrength()*2;
			else
				damageDealt = player.getStrength();
			
			// Deal damage to the monster targeted if it exists
			localMonster = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[dirX][dirY].monster;
			if(localMonster.isPresent())
				localMonster.setCurrentHealthPoints(localMonster.getCurrentHealthPoints() - damageDealt);
			this.spell.setCurrentCooldown(this.spell.getMaxCooldown());
			// Start the animation procedure
			player.spells[0].getAnimation().setAreaOfEffect(dirX, dirY, true, player.getFloorPosition(), player.getRoomPosition());
			player.spells[0].getAnimation().setActive(true);
			player.spells[0].getAnimation().setTimeRemaining(player.spells[0].getAnimation().getAnimationTime());
			break;
			
		// Ultimate
		case 1 :
			damageDealt = player.getPower() * 4;
			for(int i = -2; i <= 2; i++) {
				for(int j = -2; j <= 2; j++) {
					if(player.getRoomInsidePositionX() + i >= 0 && player.getRoomInsidePositionY() + j >= 0 && player.getRoomInsidePositionX() + i <= 16 && player.getRoomInsidePositionY() + j <= 15)
					{
						localMonster = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+i][player.getRoomInsidePositionY()+j].monster;
						if(localMonster.isPresent())
						{
							// Deal damage
							localMonster.setCurrentHealthPoints(localMonster.getCurrentHealthPoints() - damageDealt);
						}
						// Define the cells in which the animation is happening
						player.spells[1].getAnimation().setAreaOfEffect(player.getRoomInsidePositionX() + i, player.getRoomInsidePositionY() + j, true, player.getFloorPosition(), player.getRoomPosition());
					}
				}
			}
			player.spells[1].setCurrentCooldown(player.spells[1].getMaxCooldown());
			// Update the player's abilities' cooldown
			player.setCurrentManaPoints(player.getCurrentManaPoints() - player.spells[1].getManaCost());
			player.spells[1].getAnimation().setActive(true);
			player.spells[1].getAnimation().setTimeRemaining(player.spells[1].getAnimation().getAnimationTime());
			break;
			
		// Mystic Teleport
		case 2 :
			// Calculate damage done
			damageDealt = player.getPower() * 2;
			// To avoid writing long lines 
			int type = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()-dirX][player.getRoomInsidePositionY()-dirY].type;			
			Monster monster = map.getMonster(player.getFloorPosition(), player.getRoomPosition(), player.getRoomInsidePositionX(), player.getRoomInsidePositionY());
			// Simple algorithm to avoid landing on an obstacle or on a monster
			if(type != 2 || monster.isPresent())
			{
				int clock = 0;
				while(type != 2 || monster.isPresent()) 
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
			// Change the player's position based on the previous algorithm
			player.setRoomInsidePositionX(player.getRoomInsidePositionX() - dirX);
			player.setRoomInsidePositionY(player.getRoomInsidePositionY() - dirY);
			
			// Every monster around the landing area is damaged
			for(int i = -1; i <= 1; i++)
			{
				for(int j = -1; j <= 1; j++)
				{
					localMonster = map.floors[player.getFloorPosition()].rooms[player.getRoomPosition()].roomLayout[player.getRoomInsidePositionX()+i][player.getRoomInsidePositionY()+j].monster;
					if(localMonster.isPresent())
					{
						localMonster.setCurrentHealthPoints(localMonster.getCurrentHealthPoints() - damageDealt);
						// Define the cells in which the damage animation happens
					}
					player.spells[2].getAnimation().setAreaOfEffect(player.getRoomInsidePositionX() + i, player.getRoomInsidePositionY() + j, true, player.getFloorPosition(), player.getRoomPosition());
				}
			}
			player.spells[2].setCurrentCooldown(player.spells[2].getMaxCooldown());
			player.spells[2].getAnimation().setActive(true);
			player.spells[2].getAnimation().setTimeRemaining(player.spells[2].getAnimation().getAnimationTime());
			// Update the player's cooldown and mana points
			player.setCurrentManaPoints(player.getCurrentManaPoints() - spell.getManaCost());
			break;
			
		// Self-heal
		case 3 :
			damageDealt = player.getPower() * 3;
			player.setCurrentHealthPoints(player.getCurrentHealthPoints() + damageDealt);
			player.setCurrentManaPoints(player.getCurrentManaPoints() - spell.getManaCost());
			// Animation
			spell.setCurrentCooldown(spell.getMaxCooldown());
			player.spells[3].getAnimation().setActive(true);
			player.spells[3].getAnimation().setTimeRemaining(player.spells[3].getAnimation().getAnimationTime());
			player.spells[3].getAnimation().setAreaOfEffect(player.getRoomInsidePositionX(), player.getRoomInsidePositionY(), true, player.getFloorPosition(), player.getRoomPosition());
			break;
		// Kick Slash
		case 4 :
			damageDealt = (player.getStrength() + 5)*2;
			// Determine the area of damage
			for(int i = -1; i <= 1; i++) {
				if(dirX == 0)
				{
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+i]
							[player.getRoomInsidePositionY()+dirY].monster;
					player.spells[4].getAnimation().setAreaOfEffect(player.getRoomInsidePositionX() + i, player.getRoomInsidePositionY() - dirY, true, player.getFloorPosition(), player.getRoomPosition());
				}
				else
				{
					localMonster = map.floors[player.getFloorPosition()].
							rooms[player.getRoomPosition()].
							roomLayout[player.getRoomInsidePositionX()+dirX]
							[player.getRoomInsidePositionY()+i].monster;
					player.spells[4].getAnimation().setAreaOfEffect(player.getRoomInsidePositionX() - dirX, player.getRoomInsidePositionY() + i, true, player.getFloorPosition(), player.getRoomPosition());
				}	
				if(localMonster.isPresent())
				{
					localMonster.setCurrentHealthPoints(localMonster.getCurrentHealthPoints() - damageDealt);
				}
			}
			spell.setCurrentCooldown(spell.getMaxCooldown());
			player.spells[4].getAnimation().setActive(true);
			player.spells[4].getAnimation().setTimeRemaining(player.spells[4].getAnimation().getAnimationTime());
			break;
		default :
			System.out.println("Aucun des cas");
			break;
		}
		System.out.println("You used : " + name);
	}
}
