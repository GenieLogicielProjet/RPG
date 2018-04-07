package gameEngine;

import dataClasses.*;

public class Shop extends Room{
	private Item []itemsSold = new Item[8];
	private int doorLocation;
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
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
			PreviousPosPlayer[0] = 0 ;
			PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
			//System.out.println("haut");
		}
		else if (doorLocation == 1){
			PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
			PreviousPosPlayer[1] = 0 ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
			//System.out.println("gauche");
		}
		else if (doorLocation == 2){
			PreviousPosPlayer[0] = 15 ;
			PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
			//System.out.println("bas");
		}
		else if (doorLocation == 3){ 
			PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
			PreviousPosPlayer[1] = 14 ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
			//System.out.println("droite");
		}
	}
	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}
	public int getPreviousPosPlayer(int indice) {
		return PreviousPosPlayer[indice];
	}
	public int getNextPosPlayer(int indice) {
		return NextPosPlayer[indice];
	}
	public int getDoubleNextPosPlayer(int indice) {
		return DoubleNextPosPlayer[indice];
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