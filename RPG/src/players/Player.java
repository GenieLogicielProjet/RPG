package players;

import dataClasses.*;

public abstract class Player extends Characteristics{
	protected int roomInsidePositionX;
	protected int roomInsidePositionY;
	protected int floorPosition;
	protected int roomPosition;
	protected int orientation = 0;

	private int maxHealthPoints;
	private int currentHealthPoints;
	
	public Player(int swiftness, int armor, int agility, int strength, int power, int maxHealthPoints){
		super(swiftness, armor, agility, strength, power);
		this.maxHealthPoints = maxHealthPoints;
		this.currentHealthPoints = maxHealthPoints;
	}
	
	// Getters and Setters
	public int getRoomInsidePositionX() 
	{
		return roomInsidePositionX;
	}

	public void setRoomInsidePositionX(int roomPositionX) {
		this.roomInsidePositionX = roomPositionX;
	}

	public int getRoomInsidePositionY() {
		return roomInsidePositionY;
	}

	public void setRoomInsidePositionY(int roomPositionY) {
		this.roomInsidePositionY = roomPositionY;
	}

	public int getFloorPosition() {
		return floorPosition;
	}

	public void setFloorPosition(int floorPosition) {
		this.floorPosition = floorPosition;
	}

	public int getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(int mapPosition) {
		this.roomPosition = mapPosition;
	}

	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}

	public void setMaxHealthPoints(int maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public int getCurrentHealthPoints() {
		return currentHealthPoints;
	}

	public void setCurrentHealthPoints(int currentHealthPoints) {
		this.currentHealthPoints = currentHealthPoints;
	}
	
	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
}
