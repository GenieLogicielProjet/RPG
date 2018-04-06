package players;

import dataClasses.*;

public abstract class Player extends Characteristics{
	protected int roomInsidePositionX;
	protected int roomInsidePositionY;
	protected int floorPosition;
	protected int roomPosition;
	
	protected int maxHealthPoints;
	protected int currentHealthPoints;
	
	Player(){
		super();
		//currentHealthPoints = 100;
	}

	public int getRoomInsidePositionX() {
		return roomInsidePositionX;
	}

	public void setRoomInsidePositionX(int roomInsidePositionX) {
		this.roomInsidePositionX = roomInsidePositionX;
	}

	public int getRoomInsidePositionY() {
		return roomInsidePositionY;
	}

	public void setRoomInsidePositionY(int roomInsidePositionY) {
		this.roomInsidePositionY = roomInsidePositionY;
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

	public void setRoomPosition(int roomPosition) {
		this.roomPosition = roomPosition;
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

	
	
}
