package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener{
	private JButton newGame;
	private JButton leave;
	public MainWindow() {
		// TODO Auto-generated constructor stub
		this.setTitle("RPG");
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
			JPanel menu = new JPanel();
			JLabel title = new JLabel();
			title.setText("RPG");
			Box boutonMenu = Box.createVerticalBox();
		    newGame = new JButton("Nouvelle Partie");
		    newGame.addActionListener(this);
		    leave = new JButton("Quitter");
		    leave.addActionListener(this);
			JPanel newGameButon = new JPanel();
			newGameButon.setOpaque(false);
			JPanel leaveButon = new JPanel();
			leaveButon.setOpaque(false);
			JPanel titleLabel = new JPanel();
			titleLabel.setOpaque(false);
			newGameButon.add(newGame);
			leaveButon.add(leave);
				Font titleFont = new Font(Font.MONOSPACED,Font.BOLD,100);
				title.setForeground(new Color(255,255,255));
				title.setFont(titleFont);
				titleLabel.add(title);
				boutonMenu.add(titleLabel);
			boutonMenu.add(Box.createVerticalStrut(300));
			boutonMenu.add(newGameButon);
			boutonMenu.add(Box.createVerticalStrut(30));
			boutonMenu.add(leaveButon);
				
		menu.add(boutonMenu);
		menu.setOpaque(false);
		BorderLayout leLayout = new BorderLayout();
		this.setLayout(leLayout);
		
		Image theBackground = new ImageIcon("image/Donjon.png").getImage();
		Background newBackground = new Background(theBackground);
		newBackground.add(menu);
		this.setContentPane(newBackground);
	    this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		 
		if(source == newGame){
			Fenetre maFenetre = new Fenetre();
			this.setVisible(false);
			
		} else if(source == leave){
		}

		
	}

}
