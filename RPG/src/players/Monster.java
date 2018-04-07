package players;

import dataClasses.*;
import gameEngine.*;

public class Monster extends Player{	
	private boolean present;
	private Loot loot;
	
	public Monster(int swiftness, int armor, int agility, int strength, int power, int maxHealthPoints, boolean present)
	{
		super(swiftness, armor, agility, strength, power, maxHealthPoints);
		this.present = present;
		loot = new Loot(0, 15);
	}
	
	public void updateMonster(User player, Map map) {
		if(this.getCurrentHealthPoints() <= 0) {
			this.setPresent(false);
		}
		loot.setExperienceReward(player.getLevel()/5);
		move(player, map);
	}
	
	public void move(User player, Map map) {
		Monster temp = new Monster(0, 0, 0, 0, 0, 0, false);
		
	}
	
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}
