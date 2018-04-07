package gameEngine;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.color.*;
import java.awt.Graphics;
import players.*;

abstract class Room {
	
	// Array associating each type of square with an integral
	public Cell [][]roomLayout = new Cell[16][15];
	
	// Random number used for the creation of rooms randomly
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
	protected Random randomNumber = new Random();
	private int doorLocation ;
	private int doorLocation1;
	
	public Room() 
	{
		Monster monster = new Monster(0, 0, 0, 0, 0, 0, true);
		Monster noMonster = new Monster(0, 0, 0, 0, 0, 0, false);
		
		/* Creation of the layout of a room
		 * 
		 * 0 = Wall
		 * 1 = Obstacle
		 * 2 = 'basic' floor
		 * 3 = Exit (door to previous room)
		 * 4 = Exit (door to next room)
		 * 5 = Shop
		 * 
		 */
		// Create every Cell 
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				roomLayout[i][j] = new Cell(2, null, noMonster);
				if(i == 5 && j == 8) {
					roomLayout[i][j] = new Cell(2, null, monster);
				}
			}
		}
		
		// Initialize the borders as walls
		for(int i = 0; i < 15; i++)
		{
			roomLayout[0][i].type = 0;
			roomLayout[15][i].type = 0;
		}
		for(int i = 0; i < 16; i++)
		{
			roomLayout[i][0].type = 0;
			roomLayout[i][14].type = 0;
		}
		
		// Initialize the inside as basic floor
		for(int i = 1; i < 14; i++)
		{
			for(int j = 1; j < 15; j++)
			{
				roomLayout[j][i].type = 2;
			}
		}
		
		// Placing the door 
		/*doorLocation = randomNumber.nextInt(4);
		if(doorLocation == 0)
			roomLayout[0][1+randomNumber.nextInt(12)].type = 3;
		else if (doorLocation == 1)
			roomLayout[1+randomNumber.nextInt(11)][0].type = 3;
		else if (doorLocation == 2)
			roomLayout[15][1+randomNumber.nextInt(12)].type = 3;
		else 
			roomLayout[1+randomNumber.nextInt(11)][14].type = 3;*/
	}
	
	

	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}
	public int getDoorLocation1() {
		return doorLocation;
	}
	public void setDoorLocation1(int doorLocation) {
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


	public void printLayout() {
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				System.out.print(roomLayout[i][j].type);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
}
