package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ManaBar extends JPanel{
	private JProgressBar mana;
	private int manaPoint;
	
	public ManaBar() {
		// TODO Auto-generated constructor stub
		mana  = new JProgressBar();
		mana.setMaximum(100);
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

		mana.setValue(manaPoint);
		this.add(mana, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void setManaPoint(int mana){
		manaPoint = mana;
	}
}
