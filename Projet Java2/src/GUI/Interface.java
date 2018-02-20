package GUI;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Interface implements KeyListener{
	public JPanel creationMap(String maptxt){
		JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(2000, 1000));
	    content.setBackground(Color.WHITE);
	    content.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
	    ReadTextFiles carte1 = new ReadTextFiles(maptxt);
	      Personnage P1 = new Personnage(12,12);
	      Personnage P2 = new Personnage(15,12);
	      carte1.position(P1);
	      carte1.position(P2);
	      carte1.haut(P1);
	      carte1.haut(P2);
	      int [][] tab= carte1.getTab();
	      gbc.gridheight = 1;
	      gbc.gridwidth = 1;
	      int l=0;
	      for(int i=0;i<carte1.getLines();i++) {
	    	  for(int j=0;j<carte1.getColumns()+1;j++) {
	    		  int val=tab[i][j];
	    		  System.out.println(val);
	    		  gbc.gridx = j;
			      gbc.gridy = i;
	    		  JPanel cell = new JPanel();
	    		  switch(val){
	    		  	case 48 :
	    		  		cell.setBackground(Color.GRAY);
	    		  		break;
	    		  	case 49 :
	    		  		cell.setBackground(Color.decode("131028003"));
	    		  		break;
	    		  	case 15 :
	    		  		cell.setBackground(Color.BLACK);
	    		  		break;
	    		  }
	    		  
			      cell.setPreferredSize(new Dimension(10, 10));
			      content.add(cell, gbc);
	    	  }
	    	   //gbc.gridwidth = GridBagConstraints.REMAINDER;
	    	  l=l+carte1.getColumns()+1;
	      }
		return content;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fenetre = new JFrame();
		  fenetre.setTitle("RPG");
		  fenetre.setSize(700,400);
		  fenetre.setLocationRelativeTo(null);
		  fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		      
		      //Le conteneur principal
		      JPanel content = new JPanel();
		      Interface I1 = new Interface();
		      content = I1.creationMap("test1.txt");
		     
		      
		  //JPanel lePanel = new JPanel();
		  //lePanel.setSize(1000,1000);
		  //lePanel.setLayout(new FlowLayout());
		  //fenetre.getContentPane().add(lePanel);
		  
		  Interface frame = new Interface();
		  content.addKeyListener(frame);
		  content.setFocusable(true);
		  fenetre.setContentPane(content);
	      fenetre.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
