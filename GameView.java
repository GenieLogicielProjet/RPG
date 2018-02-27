package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Box;

public class GameView extends JPanel{
	
	public GameView() {
		this.setBackground(Color.ORANGE);
		this.setPreferredSize(new Dimension(600,350));
	}
}
