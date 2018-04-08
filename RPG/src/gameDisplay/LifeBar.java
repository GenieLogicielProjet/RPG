package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import players.*;

public class LifeBar extends JPanel{
	private JProgressBar life;
	private User player;
	
	public LifeBar(User player) {
		this.player = player;
		life  = new JProgressBar();
		life.setMaximum(player.getMaxHealthPoints());
		life.setMinimum(0);
		life.setForeground(Color.green);
		life.setStringPainted(true);	
		life.setSize(150,50);
		life.setStringPainted(true);
	    this.add(life, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void paintComponent(Graphics g){
		life.setMaximum(player.getMaxHealthPoints());
		life.setValue(player.getCurrentHealthPoints());
		this.add(life, BorderLayout.CENTER);
	    this.setVisible(true);
	}
}