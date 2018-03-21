package gameDisplay;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import gameEngine.*;
import players.*;

public class RoomDisplay extends JPanel{
	JPanel gamePane = new JPanel();
	
	private Map map;
	private User player;
	
	// Size of every single sprite
	private int spriteSize = 48;
	// Place in the grid of a room
	private int positionX, positionY;
	
	// Sprite that has to be drawn, identified by an integer
	private int spriteRequired;
	
	// Array containing the path to every Sprite
	private String []sprites = new String[6];
	
	public RoomDisplay(Map map, User player)
	{
		this.setSize(768, 720);
		this.setBackground(Color.PINK);
		this.setVisible(true); 

		// Filling the array with the right paths
		 sprites[0] = "images/Sprites/e1_wall.png";
		 sprites[1] = "images/Sprites/e1_obstacle.png";
		 sprites[2] = "images/Sprites/e1_floor.png";
		 sprites[3] = "images/Sprites/e1_door.png";
		 sprites[4] = "images/Sprites/e2_monster.png";
		 sprites[5] = "images/Sprites/character.png";
		 
		 // Set the values of the running variables map and player the same as those of the main
		 this.map = map;
		 this.player = player;
	}
	
	public void paintComponent(Graphics g)
	{
		try {
			for(positionX = 0; positionX < 16; positionX++)
			{
				for(positionY = 0; positionY < 15; positionY++)
				{
					boolean tryDraw;
					// Get the content of the specified cell
					int cellContent = map.getContent(player.getFloorPosition(), player.getRoomPosition(), positionX, positionY);
					if(cellContent >= 0 && cellContent <= 4)
					{
						spriteRequired = cellContent;
					}
					else
					{
						System.out.println("Erreur de chargement de la map : case inconnue");
						spriteRequired = 2;
					}
					if(player.getRoomInsidePositionX() == positionX && player.getRoomInsidePositionY() == positionY)
					{
						spriteRequired = 5;
					}
					// Display the right sprite at the right place
					BufferedImage image = ImageIO.read(new File(sprites[spriteRequired]));
					tryDraw = g.drawImage(image, positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Getters / Setters
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
