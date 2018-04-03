package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.Box;
import javax.swing.ImageIcon;

public class GameView extends JPanel{
	
	public GameView() {
		this.setBackground(Color.ORANGE);
		this.setPreferredSize(new Dimension(60,500));
		BorderLayout leLayout = new BorderLayout();
		this.setLayout(leLayout);
		/*Interface I1 = new Interface();
	    this.add( I1.creationMap("test1.txt",0));*/
		
	}
}
