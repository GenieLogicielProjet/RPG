package players;

import dataClasses.*;
import gameEngine.*;

public class Monster extends Player{
	private int tries = 0;
	
	private boolean present;
	private Loot loot;
	private long timeSinceLastMove;
	
	public Monster(int swiftness, int armor, int agility, int strength, int power, int maxHealthPoints, boolean present)
	{
		super(swiftness, armor, agility, strength, power, maxHealthPoints);
		this.present = present;
		loot = new Loot(0, 15);
		timeSinceLastMove = 0;
	}
	
	public void update(User player, Map map, long elapsedTime) {
		loot.setExperienceReward(player.getLevel()/5);
		if(this.getCurrentHealthPoints() <= 0) {
			this.setPresent(false);
			// Update the player's stats
			player.setCurrentXpPoints(player.getCurrentXpPoints()+ loot.getExperienceReward());
			player.setGold(player.getGold() + loot.getGoldReward());
		}
		if(this.isPresent())
		{
			if(timeSinceLastMove >= swiftness*10000000)
			{
				move(player, map);
				timeSinceLastMove = 0;
			}
			else
				timeSinceLastMove += elapsedTime;
		}
	}
	
	public void move(User player, Map map) {
		int xMove = 0;
		int yMove = 0;
		Monster temp = new Monster(0, 0, 0, 0, 0, 0, false);
		Monster localMonster = map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX][this.roomInsidePositionY].monster;
		if(this.roomPosition == player.roomPosition && this.floorPosition == player.floorPosition)
		{
			if(Math.abs(this.roomInsidePositionX - player.roomInsidePositionX) >= Math.abs(this.roomInsidePositionY - player.roomInsidePositionY))
			{
				if(this.roomInsidePositionX - player.roomInsidePositionX > 0)
				{
					xMove = 1;
					yMove = 0;
				}
				else if(this.roomInsidePositionX - player.roomInsidePositionX < 0)
				{
					xMove = -1;
					yMove = 0;
				}
			}
			else
			{
				if(this.roomInsidePositionY - player.roomInsidePositionY > 0)
				{
					xMove = 0;
					yMove = 1;
				}
				else if(this.roomInsidePositionY - player.roomInsidePositionY < 0)
				{
					xMove = 0;
					yMove = -1;
				}
			}
			if(map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX+xMove][this.roomInsidePositionY+yMove].type == 2) {
				temp =  map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX+xMove][this.roomInsidePositionY+yMove].monster;
				map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX+xMove][this.roomInsidePositionY+yMove].monster = localMonster;
				localMonster = temp;
				tries = 0;
			}
			if(map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX+xMove][this.roomInsidePositionY+yMove].type == 1) {
				tries ++;
				if(tries == 4) {
					map.floors[this.floorPosition].rooms[this.roomPosition].roomLayout[this.roomInsidePositionX+xMove][this.roomInsidePositionY+yMove].type = 2;
				}
			}
		}
	}
	
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}
