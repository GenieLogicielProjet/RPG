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

public class Map{
	public Floor[] floors = new Floor[3];
	
	public Map() {
		for(int i = 0; i < 3; i++) {
			floors[i] = new Floor();
		}
	}
	
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
