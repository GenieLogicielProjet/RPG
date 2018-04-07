package dataClasses;

import java.util.HashMap;

public class Hero{
	private Item head;
	private Item face;
	private Item neck;
	private Item upperBody;
	private Item leftHand;
	private Item rightHand;
	private Item legs;
	private Item feet;
	private int gold, level, experience;
	HashMap<String, Item> inventory = new HashMap<String, Item>();
	private int posX, posY;
	
	public Hero(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
}