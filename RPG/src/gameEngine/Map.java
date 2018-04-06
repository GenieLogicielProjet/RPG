package gameEngine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import dataClasses.*;
import java.awt.*;

public class Map{
	public Floor[] floors = new Floor[3];
	
	// Creation of the map
	public Map() {
		for(int i = 0; i < 3; i++) {
			System.out.println("FLOOR = "+i);
			floors[i] = new Floor();
		}
	}
	
	// Returns the content of a cell
	public int getContent(int floor, int room, int x, int y)
	{
		return floors[floor].rooms[room].roomLayout[x][y].type;
	}
	
	// Debugging : print each floor separated by a line
	public void printMap(Map map)
	{
		for(Floor f: floors)
		{
			f.printFloor();
			System.out.println("---------------------------------------------");
			System.out.println(" ");
			System.out.println(" ");
		}
	}
}
