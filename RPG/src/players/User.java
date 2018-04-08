package players;

import dataClasses.*;
import java.util.Random;

public class User extends Player{
	private int maxManaPoints;
	private int currentManaPoints;
	private int currentXpPoints;
	private int maxXpPoints;
	private int level;
	private int gold;
	
	public Spell []spells = new Spell[5];
	
	// For conversion purposes
	protected int microConv = 1000000;
	private Random random = new Random();
	
	public User(int swiftness, int armor, int agility, int strength, int power){
		super(swiftness, armor, agility, strength, power, 100);
		roomInsidePositionX = 1;
		roomInsidePositionY = 1;
		floorPosition = 0;
		roomPosition = 0;
		level = 1;
		maxXpPoints = 100;
		currentXpPoints = 0;
		gold = 0;
		maxManaPoints = 100;
		currentManaPoints = maxManaPoints;
		
		spells[0] = new Spell(500000000L, false, 0, true, 200000000L);
		spells[1] = new Spell(8000000000L, false, 23, true, 500000000L);
		spells[2] = new Spell(7000000000L, false, 8, false, 300000000L);
		spells[3] = new Spell(18000000000L, false, 15, false, 300000000L);
		spells[4] = new Spell(4000000000L, false, 0, false, 500000000L);
	}
	
	public void update(long elapsedTime) 
	{
		if(level < 16) { //(currentXpPoints >= maxXpPoints) {
			levelUp(0);
		}
		for(int i = 0; i < 5 ; i++) {
			if((spells[i].isAvailable()) == false) 
			{
				spells[i].setCurrentCooldown(spells[i].getCurrentCooldown() - elapsedTime);
				spells[i].getAnimation().setTimeRemaining(spells[i].getAnimation().getTimeRemaining() - elapsedTime);
			}
		}
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
			System.out.println("Smart Allocation unlocked");
		}
		// Kick slash : Damage ennemies in front of you 
		if(level == 15)
		{
			spells[4].setUnlocked(true);
			System.out.println("Kick slash unlocked");
		}
	}
	
	// Getters & Setters

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getCurrentXpPoints() {
		return currentXpPoints;
	}

	public int getMaxXpPoints() {
		return maxXpPoints;
	}

	public void setCurrentXpPoints(int currentXpPoints) {
		this.currentXpPoints = currentXpPoints;
	}
	
	public void setMaxXpPoints(int currentXpPoints) {
		this.currentXpPoints = currentXpPoints;
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

	public Spell getSpell(int spellID) {
		return spells[spellID];
	}

	public int getLevel() {
		return level;
	}
	public void levelUp(int overlap) {
		level ++;
		currentXpPoints = overlap + 1;
		maxXpPoints = maxXpPoints + (level-1)*100;
		System.out.println("New level unlocked : You are now level " + level);
		
		// Increase the player's stats 
		agility += random.nextInt(2);
		strength += random.nextInt(4);
		power += random.nextInt(4);
		swiftness += random.nextInt(1);
		armor += random.nextInt(4);
		int tempRand;
		tempRand = random.nextInt(10);
		maxManaPoints += tempRand;
		currentManaPoints += tempRand;
		tempRand = random.nextInt(10);
		this.setMaxHealthPoints(this.getMaxHealthPoints() + tempRand);
		this.setCurrentHealthPoints(this.getCurrentHealthPoints() + tempRand);
	}
	
}
