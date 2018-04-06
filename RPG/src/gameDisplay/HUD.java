package gameDisplay;

import gameEngine.*;
import players.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class HUD extends JFrame{
	private JFrame gameWindow;
	private JPanel hudPanel = new JPanel();
	private JPanel gameView;
	private JPanel hpBar; 
	private JPanel manaBar;
	private JPanel xpBar;
	
	public HUD()
	{
		//hudPanel.setVisible(true);
		//gameWindow = window;
		//gameWindow.add(hudPanel);
		this.setTitle("RPG");
		this.setSize(1280,960);
		this.setBackground(Color.darkGray);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
			
	}
	public void setGameView(JPanel game){
		gameView = game;
	}
	public void setHpBar(JPanel hp){
		hpBar = hp;
	}
	public void setManaBar(JPanel mana){
		manaBar = mana;
	}
	public void setXpBar(JPanel xp){
		xpBar= xp;
	}
	public void createHUD(){
				Box left = Box.createVerticalBox();
				left.add(Box.createVerticalStrut(25));
				//*****************************************************
					gameView.setBackground(Color.ORANGE);
					gameView.setPreferredSize(new Dimension(800,700));
					BorderLayout leLayout = new BorderLayout();
					gameView.setLayout(leLayout);
				//*****************************************************	
				left.add(gameView);
			    left.add(Box.createVerticalStrut(25));
			    Box container1 = Box.createHorizontalBox();
			    	JPanel abilitiesView = new JPanel();
			    		abilitiesView.setBackground(Color.GREEN);
			    		abilitiesView.setPreferredSize(new Dimension(600,120));
			    	container1.add(abilitiesView);
			    	container1.add(Box.createHorizontalStrut(15));
			    	JPanel goldView = new JPanel();
			    		goldView.setBackground(Color.GRAY);
			    		goldView.setPreferredSize(new Dimension(100,120));
			    	container1.add(goldView);
			    left.add(container1);
			    left.add(Box.createVerticalStrut(25));
		    
		    
		    
		    Box right = Box.createVerticalBox();
			    right.add(Box.createVerticalStrut(25));
			    Box container = Box.createHorizontalBox();
			    		xpBar.setBackground(Color.GRAY);
			    		xpBar.setPreferredSize(new Dimension(10,15));
						BorderLayout leLayout3 = new BorderLayout();
						xpBar.setLayout(leLayout3);
					 container.add(xpBar);
					 container.add(Box.createHorizontalStrut(15));
					 JPanel characterePicture = new JPanel();
					 	characterePicture.setBackground(Color.BLACK);
					 	characterePicture.setPreferredSize(new Dimension(120,110));
					container.add(characterePicture);
					container.add(Box.createHorizontalStrut(25));
					JPanel statView = new JPanel();
						statView.setBackground(Color.GRAY);
						statView.setPreferredSize(new Dimension(170,110));
					 container.add(statView);
			    right.add(container);
			    right.add(Box.createVerticalStrut(40));
			    	hpBar.setBackground(Color.GREEN);
			    	hpBar.setPreferredSize(new Dimension(350,25));
					BorderLayout leLayout1 = new BorderLayout();
					hpBar.setLayout(leLayout1);
			    right.add(hpBar);
			    right.add(Box.createVerticalStrut(25));
			    	manaBar.setBackground(Color.BLUE);
			    	manaBar.setPreferredSize(new Dimension(350,25));
			    	BorderLayout leLayout2 = new BorderLayout();
			    	manaBar.setLayout(leLayout2);
			    right.add(manaBar);
			    right.add(Box.createVerticalStrut(60));
			    JPanel miniMap = new JPanel();
			    	miniMap.setBackground(Color.MAGENTA);
			    	miniMap.setPreferredSize(new Dimension(350,280));
			    right.add(miniMap);
			    right.add(Box.createVerticalStrut(50));
			    JPanel inventoryView = new JPanel();
			    	inventoryView.setBackground(Color.ORANGE);
			    	inventoryView.setPreferredSize(new Dimension(350,250));
			    right.add(inventoryView);
			    right.add(Box.createVerticalStrut(25));
		    
		    
		    
		    
		    Box hiddenContainer = Box.createHorizontalBox();
		    hiddenContainer.add(Box.createHorizontalStrut(25));
		    hiddenContainer.add(left);
		    hiddenContainer.add(Box.createHorizontalStrut(50));
		    hiddenContainer.add(right);
		    hiddenContainer.add(Box.createHorizontalStrut(25));
		    
		    hiddenContainer.setOpaque(false);
		    
		    // pour un fond d'écran je suis en manque d'idée
			/*BorderLayout leLayout = new BorderLayout();
			this.setLayout(leLayout);
			
			Image theBackground = new ImageIcon("Donjon2.jpg").getImage();
			Background newBackground = new Background(theBackground);
			newBackground.add(hiddenContainer);*/   
		this.setContentPane(hiddenContainer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void drawHUD(Graphics g)
	{
		g.setColor(Color.pink);
	}
}
