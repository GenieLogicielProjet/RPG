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
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovementTest {
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
	      content = I1.creationMap("test1.txt",0);
		  
		  Interface frame = new Interface();
		  content.setFocusable(true);
		  fenetre.setContentPane(content);
	      fenetre.setVisible(true);
		Interface inter = new Interface();
	}
}
