package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class Fenetre extends JFrame{
	public Fenetre(){
		this.setTitle("RPG");
		this.setSize(1000,650);
		this.setBackground(Color.darkGray);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
			Box left = Box.createVerticalBox();
				left.add(Box.createVerticalStrut(25));
				GameView gameView = new GameView();
				left.add(gameView);
			    left.add(Box.createVerticalStrut(25));
			    AbilitiesView abilitiesView = new AbilitiesView();
			    left.add(abilitiesView);
			    left.add(Box.createVerticalStrut(25));
		    
		    
		    
		    Box right = Box.createVerticalBox();
			    right.add(Box.createVerticalStrut(25));
			    Box container = Box.createHorizontalBox();
				    container.add(Box.createHorizontalStrut(25));
					CharacterePicture characterePicture = new CharacterePicture();
					container.add(characterePicture);
					container.add(Box.createHorizontalStrut(25));
			    right.add(container);
			    right.add(Box.createVerticalStrut(40));
			    HpBar hpBar = new HpBar();
			    right.add(hpBar);
			    right.add(Box.createVerticalStrut(25));
			    ManaBar manaBar = new ManaBar();
			    right.add(manaBar );
			    right.add(Box.createVerticalStrut(25));
			    XpBar xpBar = new XpBar();
			    right.add(xpBar );
			    right.add(Box.createVerticalStrut(80));
				MiniMap miniMap = new MiniMap();
			    right.add(miniMap);
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
}
