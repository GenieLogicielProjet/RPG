package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;
import java.util.Random;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.KeyListener;  
import java.awt.event.KeyAdapter;  
import java.awt.event.KeyEvent;  

public class ShopInterface extends JFrame implements ActionListener, KeyListener {
	private JButtonImgInventory cell1, cell2, cell3, cell4, cell7, cell8, cell9, cell10, cell13, cell14, cell15, cell16;
	private JButton cell5;

	public ShopInterface(){
		
			 //Main container
		    JPanel content = new JPanel();
		    content.setPreferredSize(new Dimension(800, 800));
		    content.setBackground(Color.WHITE);
	
		    //Definition of layout manager
		    content.setLayout(new GridBagLayout());
	
		    //Definition of the object used to position the components
		    GridBagConstraints gbc = new GridBagConstraints();	
		
		  	this.setTitle("Shop");
		    this.setSize(500, 500);
		    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    
		    this.addKeyListener(this);
		    content.setFocusable(true);
		    content.setRequestFocusEnabled(true);
		    
		    //Creation of the different containers (JPanel and JLabel)
		    //Part Consumable Item
		    JPanel cell0 = new JPanel();
		    JLabel label0 = new JLabel("Welcome in the Shop !");
		    label0.setForeground(Color.WHITE);
		    cell0.add(label0);
		    cell0.setBackground(Color.GRAY);
		    cell0.setPreferredSize(new Dimension(90, 40)); 
		    
		  //Creating a JPanel that contains an image
		    File img1 = new File("images/Sprites/Others/health_potion.png");
		    cell1 = new JButtonImgInventory(img1);
		    cell1.setBackground(Color.lightGray);
		    cell1.setPreferredSize(new Dimension(90, 40)); 
		    

		    File img2 = new File("images/Sprites/Others/mana_potion.png");
		    cell2 = new JButtonImgInventory(img2);
		    cell2.setBackground(Color.lightGray);
	        cell2.setPreferredSize(new Dimension(90, 40));
		    
	        File img3 = new File("images/Sprites/Others/bomb.png");
		    cell3 = new JButtonImgInventory(img3);
		    cell3.setBackground(Color.lightGray);
		    cell3.setPreferredSize(new Dimension(90, 40));
		    
		    File img4 = new File("images/Sprites/Equipment/axe_right.png");
		    cell4 = new JButtonImgInventory(img4);
		    cell4.setBackground(Color.lightGray);
		    cell4.setPreferredSize(new Dimension(90, 40));
		    
		    //Creating JButton
		    cell5 = new JButton("Buy");
		    cell5.addActionListener(this);
		    cell5.setBackground(Color.cyan);
		    cell5.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell6 = new JPanel();
		    cell6.setBackground(Color.WHITE);
		    cell6.setPreferredSize(new Dimension(90, 40));
		    
		    File img7 = new File("images/Sprites/Equipment/necklace.png");
		    cell7 = new JButtonImgInventory(img7);
		    cell7.setBackground(Color.lightGray);
		    cell7.setPreferredSize(new Dimension(90, 40));
		    
		    File img8 = new File("images/Sprites/Equipment/chestplate.png");
		    cell8 = new JButtonImgInventory(img8);
		    cell8.setBackground(Color.lightGray);
		    cell8.setPreferredSize(new Dimension(90, 40));
		    
		    File img9 = new File("images/Sprites/Equipment/dagger_right.png");
		    cell9 = new JButtonImgInventory(img9);
		    cell9.setBackground(Color.lightGray);
		    cell9.setPreferredSize(new Dimension(90, 40));
		    
		    File img10 = new File("images/Sprites/Equipment/glove.png");
		    cell10 = new JButtonImgInventory(img10);
		    cell10.setBackground(Color.lightGray);
	        cell10.setPreferredSize(new Dimension(90, 40));
		    
	        JPanel cell11 = new JPanel();
		    cell11.setBackground(Color.WHITE);
		    cell11.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell12 = new JPanel();
		    cell12.setBackground(Color.WHITE);
		    cell12.setPreferredSize(new Dimension(90, 40));
		    
		    File img13 = new File("images/Sprites/Equipment/headgear.png");
		    cell13 = new JButtonImgInventory(img13);
		    cell13.setBackground(Color.lightGray);
		    cell13.setPreferredSize(new Dimension(90, 40));
		    
		    //JButton used for the part Equipment and part Inventory
		    File img14 = new File("images/Sprites/Equipment/sword_right.gif");
		    cell14 = new JButtonImgInventory(img14);
		    cell14.setBackground(Color.lightGray);
		    cell14.setPreferredSize(new Dimension(90, 40));
		    
		  //JButton used for the part Equipment and part Inventory
		    File img15 = new File("images/Sprites/Equipment/trousers.png");
		    cell15 = new JButtonImgInventory(img15);
		    cell15.setBackground(Color.lightGray);
		    cell15.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell16 = new JPanel();
		    cell16.setBackground(Color.WHITE);
		    cell16.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell17 = new JPanel();
		    cell17.setBackground(Color.WHITE);
		    cell17.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell18 = new JPanel();
		    cell18.setBackground(Color.WHITE);
		    cell18.setPreferredSize(new Dimension(90, 40));
		    

		    //We position the components in the frame
		    
		    gbc.gridx = 0;
		    gbc.gridy = 0;
		    gbc.gridwidth = 4;
		    gbc.gridheight = 1;
		    gbc.insets = new Insets(0, 0, 0, 0);
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell0, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.insets = new Insets(5, 0, 5, 0);
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell1, gbc);

		    gbc.gridx = 1;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell2, gbc);

		    gbc.gridx = 2;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell3, gbc);        

		    gbc.gridx = 3;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell4, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell5, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 2;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;	//End of the line
		    content.add(cell6, gbc);

		    gbc.gridx = 0;
		    gbc.gridy = 3;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell7, gbc);

		    gbc.gridx = 1;
		    gbc.gridy = 3;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell8, gbc);

		    gbc.gridx = 2;
		    gbc.gridy = 3;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell9, gbc);
		   
		    gbc.gridx = 3;
		    gbc.gridy = 3;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell10, gbc);

		    gbc.gridx = 4;
		    gbc.gridy = 3;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell11, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 4;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell12, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 5;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell13, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 5;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell14, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 5;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell15, gbc);
		    		    
		    gbc.gridx = 3;
		    gbc.gridy = 5;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell16, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 5;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell17, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 6;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell18, gbc);
		    
		    //Add the container
		    this.setContentPane(content);
		    this.setVisible(true);      
		  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == cell5)){
	    	System.out.println("Item acheté");
	    }
	    else {
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE) {
			System.out.println("Escape");
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

