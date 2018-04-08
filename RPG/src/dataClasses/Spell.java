	package dataClasses;

import gameDisplay.Animation;
import players.*;

public class Spell {
	private long maxCooldown;
	private long currentCooldown;
	private boolean available;
	private boolean damageOverTime;
	private int manaCost;
	private boolean unlocked;
	private Animation animation;

	public Spell(long maxCooldown, boolean damageOverTime, int manaCost, boolean unlocked, long animTime){
		this.maxCooldown = maxCooldown;
		this.currentCooldown = maxCooldown;
		this.available = true;
		this.damageOverTime = damageOverTime;
		this.manaCost = manaCost;
		this.unlocked = unlocked;
		animation = new Animation(animTime);
	}
	
	
	// Getters and Setters	
	public Animation getAnimation() {
		return animation;
	}

	public int getManaCost() {
		return manaCost;
	}

	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	public long getMaxCooldown() {
		return maxCooldown;
	}

	public void setMaxCooldown(long maxCooldown) {
		this.maxCooldown = maxCooldown;
	}

	public long getCurrentCooldown() {
		return currentCooldown;
	}

	public void setCurrentCooldown(long currentCooldown) {
		this.currentCooldown = currentCooldown;
		if(currentCooldown <= 0)
		{
			this.setAvailable(true);
		}
		else
			this.setAvailable(false);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
		if(available) {
			currentCooldown = maxCooldown;
		}
	}

	public boolean isDamageOverTime() {
		return damageOverTime;
	}
	public void setDamageOverTime(boolean damageOverTime) {
		this.damageOverTime = damageOverTime;
	}
	
	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
}
