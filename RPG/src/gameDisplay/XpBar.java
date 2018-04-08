package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import players.*;

public class XpBar extends JPanel{
	private JProgressBar xp;
	private User player;
	
	public XpBar(User player) {
		// TODO Auto-generated constructor stub
		xp = new JProgressBar(JProgressBar.VERTICAL);
		this.player = player;
		xp.setMaximum(player.getMaxXpPoints());
		xp.setMinimum(0);
		xp.setForeground(Color.MAGENTA);
		xp.setStringPainted(true);
		xp.setSize(10, 10);
	    this.add(xp, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void paintComponent(Graphics g){
		xp.setMaximum(player.getMaxXpPoints());
		xp.setValue(player.getCurrentXpPoints());
		this.add(xp, BorderLayout.CENTER);
	    this.setVisible(true);
	}
}