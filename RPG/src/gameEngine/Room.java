package gameEngine;
import java.util.Random;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.color.*;
import java.awt.Graphics;

abstract class Room {
	
	// Array associating each type of square with an integral
	public int [][]roomLayout = new int[16][15];
	
	// Random number used for the creation of rooms randomly
	protected Random randomNumber = new Random();
	
	public Room() 
	{
		/* Creation of the layout of a room
		 * 
		 * 0 = Wall
		 * 1 = Obstacle
		 * 2 = 'basic' floor
		 * 3 = Exit (door to next room)
		 * 4 = Shop
		 * 
		 */
		
		// Initialize the borders as walls
		for(int i = 0; i < 15; i++)
		{
			roomLayout[0][i] = 0;
			roomLayout[15][i] = 0;
		}
		for(int i = 0; i < 16; i++)
		{
			roomLayout[i][0] = 0;
			roomLayout[i][14] = 0;
		}
		
		// Initialize the inside as basic floor
		for(int i = 1; i < 14; i++)
		{
			for(int j = 1; j < 15; j++)
			{
				roomLayout[j][i] = 2;
			}
		}
		
		// Placing the door 
		int doorLocation = randomNumber.nextInt(4);
		if(doorLocation == 0)
			roomLayout[0][1+randomNumber.nextInt(12)] = 3;
		else if (doorLocation == 1)
			roomLayout[1+randomNumber.nextInt(11)][0] = 3;
		else if (doorLocation == 2)
			roomLayout[15][1+randomNumber.nextInt(12)] = 3;
		else 
			roomLayout[1+randomNumber.nextInt(11)][14] = 3;
	}
	
	// Debugging : )rint the layout of a room
	public void printLayout() {
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				System.out.print(roomLayout[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
}
