package dataClasses;

public abstract class Characteristics {
	protected int swiftness;
	protected int armor;
	protected int agility;
	protected int strength;
	protected int power;

	public Characteristics(int swiftness, int armor, int agility, int strength, int power) {
		super();
		this.swiftness = swiftness;
		this.armor = armor;
		this.agility = agility;
		this.strength = strength;
		this.power = power;
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
