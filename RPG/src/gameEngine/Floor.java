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
		int numberOfRooms = randomNumber.nextInt(4) + 5;
		int shopLocation = randomNumber.nextInt(numberOfRooms);
		rooms = new Room[numberOfRooms];
		
		// Create the Layout of a floor randomly
		// Each floor has a shop, a room with two exits (one for the shop and one for the next Room)
		for(int i = 0; i < numberOfRooms; i++)
		{
			if(i == shopLocation - 1)
				rooms[i] = new RoomDoubleExit();
			else if(i == shopLocation)
				rooms[i] = new Shop();
			else
				rooms[i] = new BasicRoom();
		}
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
