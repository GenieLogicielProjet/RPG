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
	}

	public int getRoomInsidePositionX() {
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
	
}
