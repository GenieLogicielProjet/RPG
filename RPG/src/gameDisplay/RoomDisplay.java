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
	private BufferedImage []sprites = new BufferedImage[11];
	
	public RoomDisplay(Map map, User player)
	{
		this.setSize(768, 720);
		this.setBackground(Color.PINK);
		this.setVisible(true); 
		try {
		// Filling the array with the right paths
		 /*sprites[0] = "images/Sprites/E1_Mur.png";
		 sprites[1] = "images/Sprites/E1_voiture.png";
		 sprites[2] = "images/Sprites/E1_Sol.png";
		 sprites[3] = "images/Sprites/E1_Porte.png";
		 sprites[4] = "images/Sprites/Monstre1.png";
		 sprites[5] = "images/Sprites/Perso2_32px.png";*/
			
		sprites[0] = ImageIO.read(new File("images/Sprites/E1_Mur.png"));
		sprites[1] = ImageIO.read(new File("images/Sprites/E1_voiture.png"));
		sprites[2] = ImageIO.read(new File("images/Sprites/E1_Sol.png"));
		sprites[3] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[4] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[5] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[6] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[7] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[8] = ImageIO.read(new File("images/Sprites/E1_Porte.png"));
		sprites[9] = ImageIO.read(new File("images/Sprites/Monstre1.png"));
		sprites[10] = ImageIO.read(new File("images/Sprites/Perso2_32px.png"));
		
		
		 // Set the values of the running variables map and player the same as those of the main
		 this.map = map;
		 this.player = player;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		//try {
			for(positionX = 0; positionX < 16; positionX++)
			{
				for(positionY = 0; positionY < 15; positionY++)
				{
					boolean tryDraw;
					// Get the content of the specified cell
					int cellContent = map.getContent(player.getFloorPosition(), player.getRoomPosition(), positionX, positionY);
					if(cellContent >= 0 && cellContent <= 9)
					{
						spriteRequired = cellContent;
					}
					else
					{
						System.out.println(cellContent);
						System.out.println("Erreur de chargement de la map : case inconnue");
						spriteRequired = 2;
					}
					if(player.getRoomInsidePositionX() == positionX && player.getRoomInsidePositionY() == positionY)
					{
						spriteRequired = 10;
					}
					// Display the right sprite at the right place
					//BufferedImage image = ImageIO.read(new File(sprites[spriteRequired]));
					tryDraw = g.drawImage(sprites[spriteRequired], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
				}
			}
		//}
		//catch(IOException e) {
		//	e.printStackTrace();
		//}
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
