package gameDisplay;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;
import gameEngine.*;
import players.*;
import java.util.Random;

public class GameDisplay extends JPanel{
	JPanel gamePane = new JPanel();
	
	private Map map;
	private User player;
	
	// Size of every single sprite
	private int spriteSize = 48;
	// Place in the grid of a room
	private int positionX, positionY;
	
	// Sprite that has to be drawn, identified by an integer
	private int spriteRequired;
	private int sprite;
	private int countObstacles = 0;
	
	// Arrays containing the path to every Sprite
	private BufferedImage []f1Sprite = new BufferedImage[7];
	private BufferedImage []f2Sprite = new BufferedImage[7];
	private BufferedImage []f3Sprite = new BufferedImage[7];
	private BufferedImage []characterSprite = new BufferedImage[2];
	private BufferedImage []otherSprite = new BufferedImage[5];
	// private BufferedImage []animSprite = new BufferedImage[5];
	
	public GameDisplay(Map map, User player) // Security []monsters)
	{
		this.setSize(768, 720);
		this.setBackground(Color.PINK);
		this.setVisible(true); 

		// Filling the array with the right paths
		
		try {
			// First floor
			f1Sprite[0] = ImageIO.read(new File("images/Sprites/F1/F1_wall.png"));
			f1Sprite[1] = ImageIO.read(new File("images/Sprites/F1/F1_bicycle.png"));
			f1Sprite[2] = ImageIO.read(new File("images/Sprites/F1/F1_cars.png"));
			f1Sprite[3] = ImageIO.read(new File("images/Sprites/F1/F1_rock.png"));
			f1Sprite[4] = ImageIO.read(new File("images/Sprites/F1/F1_floor.png"));
			f1Sprite[5] = ImageIO.read(new File("images/Sprites/F1/F1_monster.gif"));
			f1Sprite[6] = ImageIO.read(new File("images/Sprites/F1/F1_boss.png"));
			
			// Second floor
			f2Sprite[0] = ImageIO.read(new File("images/Sprites/F2/F2_wall.png"));
			f2Sprite[1] = ImageIO.read(new File("images/Sprites/F2/F2_bookshelf.gif"));
			f2Sprite[2] = ImageIO.read(new File("images/Sprites/F2/F2_desk.gif"));
			f2Sprite[3] = ImageIO.read(new File("images/Sprites/F2/F2_pencil.png"));
			f2Sprite[4] = ImageIO.read(new File("images/Sprites/F2/F2_floor.png"));
			f2Sprite[5] = ImageIO.read(new File("images/Sprites/F2/F2_monster.png"));
			f2Sprite[6] = ImageIO.read(new File("images/Sprites/F2/F2_boss.png"));
			
			// Third floor
			f3Sprite[0] = ImageIO.read(new File("images/Sprites/F3/F3_wall.png"));
			f3Sprite[1] = ImageIO.read(new File("images/Sprites/F3/F3_computer.png"));
			f3Sprite[2] = ImageIO.read(new File("images/Sprites/F3/F3_arduino.png"));
			f3Sprite[3] = ImageIO.read(new File("images/Sprites/F3/F3_television.png"));
			f3Sprite[4] = ImageIO.read(new File("images/Sprites/F3/F3_floor.png"));
			f3Sprite[5] = ImageIO.read(new File("images/Sprites/F3/F3_monster.png"));
			f3Sprite[6] = ImageIO.read(new File("images/Sprites/F3/F3_boss.png"));
			
			// Character Sprite
			characterSprite[0] = ImageIO.read(new File("images/Sprites/Character/characterFront.png"));
			characterSprite[1] = ImageIO.read(new File("images/Sprites/Character/characterBack.png"));
			
			// Other Sprites
			otherSprite[0] = ImageIO.read(new File("images/Sprites/Others/final_boss.jpg"));
			otherSprite[1] = ImageIO.read(new File("images/Sprites/Others/front_door.png"));
			otherSprite[2] = ImageIO.read(new File("images/Sprites/Others/shop.jpg"));
			otherSprite[3] = ImageIO.read(new File("images/Sprites/Others/closed_treasure.gif"));
			otherSprite[4] = ImageIO.read(new File("images/Sprites/Others/opened_treasure.gif"));
			
			// Animations
	/*		animSprite[0] = ImageIO.read(new File("images/Sprites/animations/basicAttack.png"));
			animSprite[1] = ImageIO.read(new File("images/Sprites/animations/ultimateSpell.png"));
			animSprite[2] = ImageIO.read(new File("images/Sprites/animations/mysticTeleport.png"));
			animSprite[3] = ImageIO.read(new File("images/Sprites/animations/smartAllocation.png"));
			animSprite[4] = ImageIO.read(new File("images/Sprites/animations/kickSlash.png")); */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// Set the values of the running variables map and player the same as those of the main
		this.map = map;
		this.player = player;
	//	Thread displayRoom = new Thread(this, "Update the display of the map");
	//	displayRoom.start();
	}
	
	public void paintComponent(Graphics g)
	{
		for(positionX = 0; positionX < 16; positionX++)
		{
			for(positionY = 0; positionY < 15; positionY++)
			{
				sprite = 0;
				boolean tryDraw = true;
				// Get the type of the required cell
				int cellType = map.getType(player.getFloorPosition(), player.getRoomPosition(), positionX, positionY);
				Monster cellMonster = map.getMonster(player.getFloorPosition(), player.getRoomPosition(), positionX, positionY);
				
				// Determine the sprite corresponding to the cell type
				switch(cellType) {
				case 0:
					spriteRequired = cellType;
					break;
				case 1:
					/*switch(countObstacles%3) {
					case 1:
						spriteRequired = 1;
						break;
					case 2:
						spriteRequired = 2;
						break;
					case 3:
						spriteRequired = 3;
						break;
					}
					countObstacles++;
					if(countObstacles == 80000)
						countObstacles = 0;*/
					spriteRequired = 2;
					break;
				case 2:
					spriteRequired = 4;
					break;
				case 9:
					sprite = 8;
					break;
				default :
					sprite = 7;
					break;
				}
				
				// Draws images from the corresponding arrays, depending of the current floor
				switch(player.getFloorPosition()) {
				case 0 :
					tryDraw = g.drawImage(f1Sprite[4], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					tryDraw = g.drawImage(f1Sprite[spriteRequired], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					if(sprite == 8) {
						tryDraw = g.drawImage(otherSprite[2], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					if(sprite == 7) {
						tryDraw = g.drawImage(otherSprite[1], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					break;
				case 1 :
					tryDraw = g.drawImage(f2Sprite[4], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					tryDraw = g.drawImage(f1Sprite[spriteRequired], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					if(sprite == 8) {
						tryDraw = g.drawImage(otherSprite[2], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					if(sprite == 7) {
						tryDraw = g.drawImage(otherSprite[1], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					break;
				case 2 :
					tryDraw = g.drawImage(f3Sprite[4], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					tryDraw = g.drawImage(f1Sprite[spriteRequired], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					if(sprite == 8) {
						tryDraw = g.drawImage(otherSprite[2], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					if(sprite == 7) {
						tryDraw = g.drawImage(otherSprite[1], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
					break;
				default :
					System.out.println("Erreur : etage inconnu");
					break;
				}
				
				// Draw the character
				if(player.getRoomInsidePositionX() == positionX && player.getRoomInsidePositionY() == positionY) {
					switch(player.getOrientation()) {
					case 0:
						tryDraw = g.drawImage(characterSprite[0], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					case 1:
						tryDraw = g.drawImage(characterSprite[1], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					default :
						tryDraw = g.drawImage(characterSprite[0], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					}
				}
				
				// Draw the spell animation (if it still needs to be animated)
				/*for(int i = 0; i <= 4; i++)
				{
					if(player.spells[i].getAnimation().isActive() && player.spells[i].getAnimation().isAreaOfEffect(positionX, positionX))
					{
						tryDraw = g.drawImage(animSprite[i], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
					}
				}*/
				
				// Draw the monsters if they are present
				if(cellMonster.isPresent()) {
					switch(player.getFloorPosition()) {
					case 0:
						tryDraw = g.drawImage(f1Sprite[5], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					case 1:
						tryDraw = g.drawImage(f2Sprite[5], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					default :
						tryDraw = g.drawImage(f3Sprite[5], positionX*spriteSize, positionY*spriteSize, spriteSize, spriteSize, null);
						break;
					}
				}
			}
		}
	}
}
