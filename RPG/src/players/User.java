package players;

import dataClasses.*;

public class User extends Player{
	private int maxManaPoints;
	private int currentManaPoints;
	private int level;
	public Spell []spells = new Spell[5];
	
	// For conversion purposes
	protected int microConv = 1000000;
	
	public User(int swiftness, int armor, int agility, int strength, int power){
		super(swiftness, armor, agility, strength, power, 100);
		roomInsidePositionX = 1;
		roomInsidePositionY = 1;
		floorPosition = 0;
		roomPosition = 0;
		spells[0] = new Spell(500*microConv, false, 0, true, 200000000);
		spells[1] = new Spell(1200*microConv, false, 24, true, 500000000);
		spells[2] = new Spell(7000*microConv, false, 8, false, 300000000);
		spells[3] = new Spell(18000*microConv, false, 15, false, 300000000);
		spells[4] = new Spell(4000*microConv, false, 0, false, 500000000);
		
		maxManaPoints = 100;
		currentManaPoints = maxManaPoints;
	}

	public int getMaxManaPoints() {
		return maxManaPoints;
	}

	public void setMaxManaPoints(int maxManaPoints) {
		this.maxManaPoints = maxManaPoints;
	}

	public int getCurrentManaPoints() {
		return currentManaPoints;
	}

	public void setCurrentManaPoints(int currentManaPoints) {
		this.currentManaPoints = currentManaPoints;
	}

	public Spell[] getSpells() {
		return spells;
	}

	public void setSpells(Spell[] spells) {
		this.spells = spells;
	}
	public int getLevel() {
		return level;
	}
	public void levelUp() {
		this.level ++;
		System.out.println("New level unlocked : You are now level " + level);
		// Mystic teleport : teleport that deals damage on impact
		if(level == 5)
		{
			spells[2].setUnlocked(true);
			System.out.println("Mystic teleport unlocked");
		}
		// Smart allocation : Sacrfice mana to heal yourself
		if(level == 10)
		{
			spells[3].setUnlocked(true);
		}
		// Kick slash : Damage ennemies in front of you 
		if(level == 15)
		{
			spells[4].setUnlocked(true);
			System.out.println("Kick slash unlocked");
		}
	}
	
}
