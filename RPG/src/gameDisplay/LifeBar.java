package gameDisplay;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class LifeBar extends JPanel{

	private JProgressBar life;
	private int hpPoint;
	
	public LifeBar() {
		// TODO Auto-generated constructor stub
		life  = new JProgressBar();
		life.setMaximum(100);
		life.setMinimum(0);
		life.setForeground(Color.green);
		life.setStringPainted(true);
		
		life.setSize(150,50);
		//this.add(life);
		life.setStringPainted(true);
	    this.add(life, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void paintComponent(Graphics g){

		life.setValue(hpPoint);
		this.add(life, BorderLayout.CENTER);
	    this.setVisible(true);
	}
	public void setHpPoint(int hp){
		hpPoint = hp;
	}
}
