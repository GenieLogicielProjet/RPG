package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Box;

public class MiniMap extends JPanel{

	public MiniMap() {
		this.setBackground(Color.MAGENTA);
		this.setPreferredSize(new Dimension(200,200));
	}
}
