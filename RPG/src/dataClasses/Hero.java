package dataClasses;

import java.util.HashMap;

public class Hero extends Characteristics{
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
}