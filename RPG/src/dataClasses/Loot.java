package dataClasses;

public class Loot {
	private int experienceReward;
	private int goldReward;
	
	public Loot(int experienceReward, int goldReward) {
		this.experienceReward = experienceReward;
		this.goldReward = goldReward;
	}
	
	public int getExperienceReward() {
		return experienceReward;
	}
	public void setExperienceReward(int experienceReward) {
		this.experienceReward = experienceReward;
	}
	public int getGoldReward() {
		return goldReward;
	}
	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}
}
