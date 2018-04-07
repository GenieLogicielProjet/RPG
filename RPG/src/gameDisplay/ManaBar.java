package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import players.*;

public class ManaBar extends JPanel{
	private JProgressBar mana;
	private User player;
	
	public ManaBar(User player) {
		this.player = player;
		mana  = new JProgressBar();
		mana.setMaximum(player.getMaxManaPoints());
		mana.setMinimum(0);
		mana.setForeground(Color.blue);
		mana.setStringPainted(true);
		mana.setSize(150,50);
		//this.add(life);
		mana.setStringPainted(true);
	    this.add(mana, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void paintComponent(Graphics g){
		mana.setMaximum(player.getMaxManaPoints());
		mana.setValue(player.getCurrentManaPoints());
		this.add(mana, BorderLayout.CENTER);
	    this.setVisible(true);
	}
}