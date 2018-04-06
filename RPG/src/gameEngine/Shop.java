package gameEngine;

import dataClasses.*;

public class Shop extends Room{
	private Item []itemsSold = new Item[8];
	private int doorLocation;
	public Shop(Room lastRoom) 
	{
		super();
		
		int shopLocationX = 2 + randomNumber.nextInt(9);
		int shopLocationY = 2 + randomNumber.nextInt(11);
		System.out.println("SHOP");
		for(int i = 0; i < 3; i++)
		{
			roomLayout[shopLocationX + i][shopLocationY].type = 9;
			roomLayout[shopLocationX + i][shopLocationY].type = 9;
		}
		
		doorLocation = opposed(lastRoom.getDoorLocation());
		if(doorLocation == 0){
			roomLayout[0][1+randomNumber.nextInt(12)].type = 3;
			//System.out.println("haut");
		}
		else if (doorLocation == 1){
			roomLayout[1+randomNumber.nextInt(11)][0].type = 3;
			//System.out.println("gauche");
		}
		else if (doorLocation == 2){
			roomLayout[15][1+randomNumber.nextInt(12)].type = 3;
			//System.out.println("bas");
		}
		else{ 
			roomLayout[1+randomNumber.nextInt(11)][14].type = 3;
			//System.out.println("droite");
		}
	}
	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}
	private int opposed(int number){
		
		if(number == 0){
			//System.out.println("haut");
			return 2;
		}
		if(number == 1){
			//System.out.println("gauche");
			return 3;
		}
		if(number == 2){
			//System.out.println("bas");
			return 0;
		}
		if(number == 3){
			//System.out.println("droite");
			return 1;
		}
		else{
			System.out.println("Erreur porte");
			return 0;
		}
	}
	
}