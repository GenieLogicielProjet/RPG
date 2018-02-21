package gameEngine;
import dataClasses.*;

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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Interface implements KeyListener{
    ReadTextFiles carte1 = new ReadTextFiles("test1.txt");
    Hero P1 = new Hero(12,12);
    
    JButton left = new JButton("Left");
    JButton right = new JButton("Right");
    JButton up = new JButton("Up");
    JButton down = new JButton("Down");
    
	public JPanel creationMap(String maptxt,int x){
		JPanel content = new JPanel();
		//JPanel boutons = new JPanel();
		
		//boutons.setLayout(new BorderLayout());
		//boutons.add(content, BorderLayout.CENTER);
		
	    content.setPreferredSize(new Dimension(2000, 1000));
	    
	    content.setBackground(Color.WHITE);
	    content.setLayout(new GridBagLayout());
	    content.addKeyListener(this);
	    
	    /*boutons.add(left, BorderLayout.EAST);
	    boutons.add(right, BorderLayout.WEST);
	    boutons.add(up, BorderLayout.NORTH);
	    boutons.add(down, BorderLayout.SOUTH);
	    boutons.setVisible(true);
	    
	    left.addActionListener(this);
	    right.addActionListener(this);
	    up.addActionListener(this);
	    down.addActionListener(this);*/
	    
	    GridBagConstraints gbc = new GridBagConstraints();
		  carte1.position(P1);
		  if(x==1) {
			  carte1.haut(P1);
		  }
		if(x==2) {
			carte1.gauche(P1);		  
				  }
		if(x==3) {
			carte1.droite(P1); 
		}
		if(x==4) {
			carte1.bas(P1); 
		}
		  
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
	/*public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == left)
		{
			carte1.gauche(P1);
		}
		if(evt.getSource() == right)
		{
			carte1.droite(P1);
		}
		if(evt.getSource() == up)
		{
			carte1.haut(P1);
		}
		if(evt.getSource() == down)
		{
			carte1.bas(P1);
		}
	}*/
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int action = e.getKeyCode();
		switch(action)
		{
		case KeyEvent.VK_Z:
			JFrame fenetre = new JFrame();
			  fenetre.setTitle("RPG");
			  fenetre.setSize(700,400);
			  fenetre.setLocationRelativeTo(null);
			  fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
			      
		      //Le conteneur principal
		      JPanel content = new JPanel();
		      Interface I1 = new Interface();
		      content = I1.creationMap("test1.txt",1);
			  
			  Interface frame = new Interface();
			  content.setFocusable(true);
			  fenetre.setContentPane(content);
		      fenetre.setVisible(true);
			Interface inter = new Interface();
			System.out.println("haut");
			break;
		case KeyEvent.VK_Q:
			/*JFrame fenetre1 = new JFrame();
			  fenetre1.setTitle("RPG");
			  fenetre1.setSize(700,400);
			  fenetre1.setLocationRelativeTo(null);
			  fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
			      
		      //Le conteneur principal
		      JPanel content1 = new JPanel();
		      Interface I11 = new Interface();
		      content = I11.creationMap("test1.txt",2);
			  
			  Interface frame1 = new Interface();
			  content1.setFocusable(true);
			  fenetre1.setContentPane(content);
		      fenetre1.setVisible(true);
			Interface inter1 = new Interface();*/
			System.out.println("gauche");
			break;
		case KeyEvent.VK_S :
			/*JFrame fenetre2 = new JFrame();
			  fenetre2.setTitle("RPG");
			  fenetre2.setSize(700,400);
			  fenetre2.setLocationRelativeTo(null);
			  fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
			      
		      //Le conteneur principal
		      JPanel content2 = new JPanel();
		      Interface I12 = new Interface();
		      content2 = I12.creationMap("test1.txt",4);
			  
			  Interface frame2 = new Interface();
			  content2.setFocusable(true);
			  fenetre2.setContentPane(content);
		      fenetre2.setVisible(true);
			Interface inter2 = new Interface();*/
			System.out.println("bas");
			break;
		case KeyEvent.VK_D :
			/*JFrame fenetre3 = new JFrame();
			  fenetre3.setTitle("RPG");
			  fenetre3.setSize(700,400);
			  fenetre3.setLocationRelativeTo(null);
			  fenetre3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
			      
		      //Le conteneur principal
		      JPanel content3 = new JPanel();
		      Interface I13 = new Interface();
		      content = I13.creationMap("test1.txt",3);
			  
			 Interface frame3 = new Interface();
			  content3.setFocusable(true);
			  fenetre3.setContentPane(content);
		      fenetre3.setVisible(true);
			Interface inter3 = new Interface();*/
			System.out.println("droite");
			break;
			default:
				System.out.println(e.getKeyCode());
		}
	}
}
