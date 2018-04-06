package gameEngine;

import dataClasses.*;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Floor{
	int number;
	private Random randomNumber = new Random();
	public Room []rooms;
	
	public Floor() {
		int numberOfRooms = randomNumber.nextInt(4) + 6;
		int shopLocation=0; 
		rooms = new Room[numberOfRooms+3];
		
		for(int j=0;j<1;j++){
			shopLocation = randomNumber.nextInt(numberOfRooms);
			if(shopLocation<2){
				j=j-1;
			}
			if(shopLocation >(numberOfRooms-2)){
				j=j-1;
			}
		}
		
		// Create the Layout of a floor randomly
		// Each floor has a shop, a room with two exits (one for the shop and one for the next Room)
		for(int i = 0; i < numberOfRooms; i++)
		{
			if(i==0){
				rooms[i] = new BasicRoom();
			}
			else if(i == shopLocation -1)
				rooms[i] = new RoomDoubleExit(rooms[i-1]);
			else if(i == shopLocation)
				rooms[i] = new Shop(rooms[i-1]);
			else if(i == shopLocation+1)
				rooms[i] = new AfterSHopRoom(rooms[i-2]);
			else{
				if(i!=0 && i!=shopLocation -1 && i!=shopLocation && i!=shopLocation+1){
					rooms[i] = new MiddleRoom(rooms[i-1]);
				}
			}
		}
		rooms[numberOfRooms-1] = new EndRoom(rooms[numberOfRooms-2]);
	}
	
	public void printFloor()
	{
		for(Room r: rooms)
		{
			r.printLayout();
			System.out.println(" ");
			System.out.println(" ");
		}
	}
}
