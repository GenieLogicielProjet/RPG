package gameEngine;

import players.*;
import dataClasses.Item;

public class Cell {
	public int type;
	public Monster monster;
	public Item item;
	
	public Cell(int type, Item item, Monster monster) {
		this.type = type;
		this.monster = monster;
		this.item = item;
	}
}
