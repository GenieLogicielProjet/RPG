package gameDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.EventListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InventoryInterface extends JFrame implements ActionListener {
	private JButtonImgInventory cell1, cell2, cell3, cell10, cell11, cell12, cell13, cell16, cell17, cell18;
	private JButtonImgInventory cell19, cell22, cell23, cell24, cell25, cell28, cell29, cell30, cell31, cell34, cell35, cell36, cell37;
	private JButton cell5, cell6, cell14, cell15, cell20;


	public InventoryInterface(){
		
			//Main container
		    JPanel content = new JPanel();
		    content.setPreferredSize(new Dimension(800, 800));
		    content.setBackground(Color.WHITE);
	
		    //Definition of layout manager
		    content.setLayout(new GridBagLayout());
	
		    //Definition of the object used to position the components
		    GridBagConstraints gbc = new GridBagConstraints();
		
		  	this.setTitle("Inventory");
		    this.setSize(600, 750);
		    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		    
		    this.setLocationRelativeTo(null);

		    //Creation of the different containers (JPanel and JLabel)
		    //Part Consumable Item
		    JPanel cell0 = new JPanel();
		    JLabel label0 = new JLabel("Consumable Items");
		    label0.setForeground(Color.WHITE);
		    cell0.add(label0);
		    cell0.setBackground(Color.GRAY);
		    cell0.setPreferredSize(new Dimension(90, 40)); 
		    
		  //Creating a JPanel that contains an image
		    File img1 = new File("images/Sprites/Others/health_potion.png");
		    cell1 = new JButtonImgInventory(img1);
		    //JLabel label1 = new JLabel("Test ");
		    // label1.setVerticalAlignment(SwingConstants.BOTTOM);
		    //label1.setForeground(Color.WHITE);
		    //cell1.add(label1);
		    cell1.setBackground(Color.GRAY);
		    cell1.setPreferredSize(new Dimension(90, 40)); 
		    

		    File img2 = new File("images/Sprites/Others/mana_potion.png");
		    cell2 = new JButtonImgInventory(img2);
		    cell2.setBackground(Color.GRAY);
	        cell2.setPreferredSize(new Dimension(90, 40));
		    
	        File img3 = new File("images/Sprites/Others/bomb.png");
		    cell3 = new JButtonImgInventory(img3);
		    cell3.setBackground(Color.GRAY);
		    cell3.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell4 = new JPanel();
		    cell4.setBackground(Color.WHITE);
		    cell4.setPreferredSize(new Dimension(90, 40));
		    
		    //Creating JButton
		    cell5 = new JButton("Use");
		    cell5.addActionListener(this);
		    cell5.setBackground(Color.cyan);
		    cell5.setPreferredSize(new Dimension(90, 40));
		    
		    cell6 = new JButton("Remove");
		    cell6.addActionListener(this);
		    cell6.setBackground(Color.cyan);
		    cell6.setPreferredSize(new Dimension(90, 40));
		    
		    //Part Equipment
		    JPanel cell7 = new JPanel();
		    JLabel label7 = new JLabel("Equipment");
		    label7.setForeground(Color.WHITE);
		    cell7.add(label7);
		    cell7.setBackground(Color.BLUE);
		    cell7.setPreferredSize(new Dimension(90, 40));
		    
		    //Part Inventory
		    JPanel cell8 = new JPanel();
		    JLabel label8 = new JLabel("Inventory");
		    label8.setForeground(Color.WHITE);
		    cell8.add(label8);
		    cell8.setBackground(Color.orange);
		    cell8.setPreferredSize(new Dimension(90, 40));
		    
		    //Part Specification
		    JPanel cell9 = new JPanel();
		    JLabel label9 = new JLabel("Specifications");
		    label9.setForeground(Color.WHITE);
		    cell9.add(label9);
		    cell9.setBackground(Color.DARK_GRAY);
		    cell9.setPreferredSize(new Dimension(90, 40));
		    
		    File img10 = new File("images/Sprites/Equipment/axe_right.png");
		    cell10 = new JButtonImgInventory(img10);
		    cell10.setBackground(Color.BLUE);
	        cell10.setPreferredSize(new Dimension(90, 40));
		    
	        File img11 = new File("images/Sprites/Equipment/sword_right.gif");
		    cell11 = new JButtonImgInventory(img11);
		    cell11.setBackground(Color.BLUE);
		    cell11.setPreferredSize(new Dimension(90, 40));
		    
		    File img12 = new File("images/Sprites/Equipment/axe_right.png");
		    cell12 = new JButtonImgInventory(img12);
		    cell12.setBackground(Color.ORANGE);
		    cell12.setPreferredSize(new Dimension(90, 40));
		    
		    File img13 = new File("images/Sprites/Equipment/sword_right.gif");
		    cell13 = new JButtonImgInventory(img13);
		    cell13.setBackground(Color.ORANGE);
		    cell13.setPreferredSize(new Dimension(90, 40));
		    
		    //JButton used for the part Equipment and part Inventory
		    cell14 = new JButton("Equip");
		    cell14.addActionListener(this);
		    cell14.setBackground(Color.cyan);
		    cell14.setPreferredSize(new Dimension(90, 40));
		    
		  //JButton used for the part Equipment and part Inventory
		    cell15 = new JButton("Desequip");
		    cell15.addActionListener(this);
		    cell15.setBackground(Color.cyan);
		    cell15.setPreferredSize(new Dimension(90, 40));
		    
		    File img16 = new File("images/Sprites/Equipment/dagger_right.png");
		    cell16 = new JButtonImgInventory(img16);
		    cell16.setBackground(Color.BLUE);
		    cell16.setPreferredSize(new Dimension(90, 40));
		    
		    File img17 = new File("images/Sprites/Equipment/trousers.png");
		    cell17 = new JButtonImgInventory(img17);
		    cell17.setBackground(Color.BLUE);
		    cell17.setPreferredSize(new Dimension(90, 40));
		    
		    File img18 = new File("images/Sprites/Equipment/dagger_right.png");
		    cell18 = new JButtonImgInventory(img18);
		    cell18.setBackground(Color.ORANGE);
		    cell18.setPreferredSize(new Dimension(90, 40));
		    
		    File img19 = new File("images/Sprites/Equipment/trousers.png");
		    cell19 = new JButtonImgInventory(img19);
		    cell19.setBackground(Color.ORANGE);
		    cell19.setPreferredSize(new Dimension(90, 40));
		    
		    cell20 = new JButton("Remove");
		    cell20.addActionListener(this);
		    cell20.setBackground(Color.cyan);
		    cell20.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell21 = new JPanel();
		    cell21.setBackground(Color.WHITE);
		    cell21.setPreferredSize(new Dimension(90, 40));
		    
		    File img22 = new File("images/Sprites/Equipment/chestplate.png");
		    cell22 = new JButtonImgInventory(img22);
		    cell22.setBackground(Color.BLUE);
		    cell22.setPreferredSize(new Dimension(90, 40));
		    
		    File img23 = new File("images/Sprites/Equipment/glove.png");
		    cell23 = new JButtonImgInventory(img23);
		    cell23.setBackground(Color.BLUE);
		    cell23.setPreferredSize(new Dimension(90, 40));
		    
		    File img24 = new File("images/Sprites/Equipment/chestplate.png");
		    cell24 = new JButtonImgInventory(img24);
		    cell24.setBackground(Color.ORANGE);
		    cell24.setPreferredSize(new Dimension(90, 40));
		    
		    File img25 = new File("images/Sprites/Equipment/glove.png");
		    cell25 = new JButtonImgInventory(img25);
		    cell25.setBackground(Color.ORANGE);
		    cell25.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell26 = new JPanel();
		    cell26.setBackground(Color.WHITE);
		    cell26.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell27 = new JPanel();
		    cell27.setBackground(Color.WHITE);
		    cell27.setPreferredSize(new Dimension(90, 40));
		    
		    File img28 = new File("images/Sprites/Equipment/headgear.png");
		    cell28 = new JButtonImgInventory(img28);
		    cell28.setBackground(Color.BLUE);
		    cell28.setPreferredSize(new Dimension(90, 40));
		    
		    File img29 = new File("images/Sprites/Equipment/necklace.png");
		    cell29 = new JButtonImgInventory(img29);
		    cell29.setBackground(Color.BLUE);
		    cell29.setPreferredSize(new Dimension(90, 40));
		    
		    File img30 = new File("images/Sprites/Equipment/headgear.png");
		    cell30 = new JButtonImgInventory(img30);
		    cell30.setBackground(Color.ORANGE);
		    cell30.setPreferredSize(new Dimension(90, 40));
		    
		    File img31 = new File("images/Sprites/Equipment/necklace.png");
		    cell31 = new JButtonImgInventory(img31);
		    cell31.setBackground(Color.ORANGE);
		    cell31.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell32 = new JPanel();
		    cell32.setBackground(Color.WHITE);
		    cell32.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell33 = new JPanel();
		    cell33.setBackground(Color.WHITE);
		    cell33.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell34 = new JPanel();
		    cell34.setBackground(Color.WHITE);
		    cell3.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell35 = new JPanel();
		    cell35.setBackground(Color.WHITE);
		    cell35.setPreferredSize(new Dimension(90, 40));
		    
		    File img36 = new File("images/Sprites/Others/key.gif");
		    cell36 = new JButtonImgInventory(img36);
		    cell36.setBackground(Color.ORANGE);
		    cell36.setPreferredSize(new Dimension(90, 40));
		    
		    File img37 = new File("images/Sprites/Others/money.png");
		    cell37 = new JButtonImgInventory(img37);
		    cell37.setBackground(Color.ORANGE);
		    cell37.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell38 = new JPanel();
		    cell38.setBackground(Color.WHITE);
		    cell38.setPreferredSize(new Dimension(90, 40));
		    
		    JPanel cell39 = new JPanel();
		    cell39.setBackground(Color.WHITE);
		    cell39.setPreferredSize(new Dimension(90, 40));

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
		    gbc.gridheight = 1;
		    content.add(cell4, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 1;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    content.add(cell5, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 2;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;	//End of the line
		    content.add(cell6, gbc);

		    gbc.gridx = 0;
		    gbc.gridy = 3;
		    gbc.gridwidth = 2;
		    gbc.gridheight = 1;
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    content.add(cell7, gbc);

		    gbc.gridx = 2;
		    gbc.gridy = 3;
		    gbc.gridwidth = 2;
		    gbc.gridheight = 1;
		    gbc.fill = GridBagConstraints.HORIZONTAL;
		    content.add(cell8, gbc);

		    gbc.gridx = 4;
		    gbc.gridy = 3;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell9, gbc);
		   
		    gbc.gridx = 0;
		    gbc.gridy = 4;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell10, gbc);

		    gbc.gridx = 1;
		    gbc.gridy = 4;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell11, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 4;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell12, gbc);
		    
		    gbc.gridx = 3;
		    gbc.gridy = 4;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell13, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 4;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell14, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 5;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell15, gbc);
		    		    
		    gbc.gridx = 0;
		    gbc.gridy = 6;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell16, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 6;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell17, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 6;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell18, gbc);
		    
		    gbc.gridx = 3;
		    gbc.gridy = 6;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    content.add(cell19, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 6;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell20, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 7;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell21, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 8;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell22, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 8;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell23, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 8;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell24, gbc);
		    
		    gbc.gridx = 3;
		    gbc.gridy = 8;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell25, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 8;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell26, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 9;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell27, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 10;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell28, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 10;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell29, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 10;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell30, gbc);
		    
		    gbc.gridx = 3;
		    gbc.gridy = 10;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell31, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 10;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell32, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 11;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell33, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 12;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell34, gbc);
		    
		    gbc.gridx = 1;
		    gbc.gridy = 12;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell35, gbc);
		    
		    gbc.gridx = 2;
		    gbc.gridy = 12;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell36, gbc);
		    
		    gbc.gridx = 3;
		    gbc.gridy = 12;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 2;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    content.add(cell37, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 12;
		    gbc.gridwidth = 1;
		    gbc.gridheight = 1;
		    content.add(cell38, gbc);
		    
		    gbc.gridx = 4;
		    gbc.gridy = 13;
		    gbc.gridwidth = GridBagConstraints.REMAINDER;
		    content.add(cell39, gbc);
		    
		    //Add the container
		    this.setContentPane(content);
		    this.setVisible(true);      
		  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
	    if ((e.getSource() == cell20)){
	    	System.out.println("okay");
	    	
	    }
	    else {
	    	
	    }
	}
}
