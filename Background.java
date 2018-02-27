package view;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;

public class Background extends JPanel{
	private Image image;
	public Background(Image image) {
		this.image = image;
	}
	public void paintComponent(Graphics g){                
	   g.drawImage(image,0,0,null);
	  }    
}
