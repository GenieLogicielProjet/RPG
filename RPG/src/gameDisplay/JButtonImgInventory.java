package gameDisplay;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class JButtonImgInventory extends JButton {
	
    private BufferedImage buffImg;
    
    public JButtonImgInventory(File img) {
		Initialize(img);
	}
		
    public void Initialize(File img) {
    		//initialize BufferedImage
		 try {
		         buffImg = ImageIO.read(img);
		     } catch (IOException e) {
		           System.out.println("File not loaded!");
		           System.exit(0);
		      }
	}
    
    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(buffImg, 25, 25, null);
	}
}
