package dataClasses;

public abstract class Characteristics {
	protected int healthPoints;
	private int manaPoints;
	private int swiftness;
	private int armor;
	private int agility;
	private int strength;
	private int power;
	
	public Characteristics(){
		//healthPoints = 100;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getManaPoints() {
		return manaPoints;
	}
	public void setManaPoints(int manaPoints) {
		this.manaPoints = manaPoints;
	}
	public int getSwiftness() {
		return swiftness;
	}
	public void setSwiftness(int swiftness) {
		this.swiftness = swiftness;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
