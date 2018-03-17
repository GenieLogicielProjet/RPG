package gameEngine;

import dataClasses.*;

public class Shop extends Room{
	private Item []itemsSold = new Item[8];
	public Shop() 
	{
		super();
		
		int shopLocationX = 2 + randomNumber.nextInt(9);
		int shopLocationY = 2 + randomNumber.nextInt(11);
		
		for(int i = 0; i < 3; i++)
		{
			roomLayout[shopLocationX + i][shopLocationY] = 4;
			roomLayout[shopLocationX + i][shopLocationY] = 4;
		}
	}
}