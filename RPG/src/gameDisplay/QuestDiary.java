package gameDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class QuestDiary extends JFrame{
	
	public QuestDiary() {
		this.setTitle("QuestDiary");
		this.setSize(600, 600);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    createPanel();
	    this.setVisible(true);
	}
	
	public void createPanel() {    
		
	    //Main container
	    JPanel content = new JPanel();
	    
	    //Definition of layout manager
	    content.setLayout(new GridBagLayout());
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints gb = new GridBagConstraints();
	    
	    //Creation of JPanel
	    JPanel cell0 = new JPanel();
	    JLabel lab0 = new JLabel();
	    lab0.setText(" Main Missions");
	    cell0.add(lab0);
	    cell0.setBorder(new LineBorder(Color.BLACK));
	    cell0.setBackground(Color.lightGray);
	    cell0.setPreferredSize(new Dimension(450, 30));
	    
	    JPanel cell1 = new JPanel();
	    JLabel lab1 = new JLabel();
	    lab1.setText("<html> Mission 1: <br> This is an example </html>");
	    cell1.add(lab1);
	    cell1.setBorder(new LineBorder(Color.BLACK));
	    cell1.setBackground(Color.lightGray);
	    cell1.setPreferredSize(new Dimension(450, 70));
	    
	    JPanel cell2 = new JPanel();
	    JLabel lab2 = new JLabel();
	    lab2.setText("<html> Mission 2: <br> This is an example </html>");
	    cell2.add(lab2);
	    cell2.setBorder(new LineBorder(Color.BLACK));
	    cell2.setBackground(Color.lightGray);
	    cell2.setPreferredSize(new Dimension(450, 70));
	    
	    JPanel cell3 = new JPanel();
	    JLabel lab3 = new JLabel();
	    lab3.setText("<html> Secondary Missions </html>");
	    cell3.add(lab3);
	    cell3.setBorder(new LineBorder(Color.BLACK));
	    cell3.setPreferredSize(new Dimension(450, 30));
	    
	    JPanel cell4 = new JPanel();
	    JLabel lab4 = new JLabel();
	    lab4.setText("<html> Mission 3: <br> This is an example </html>");
	    cell4.add(lab4);
	    cell4.setBorder(new LineBorder(Color.BLACK));
	    cell4.setPreferredSize(new Dimension(450, 70));
	    
	    JPanel cell5 = new JPanel();
	    JLabel lab5 = new JLabel();
	    lab5.setText("<html> Mission 4: <br> This is an example </html>");
	    cell5.add(lab5);
	    cell5.setBorder(new LineBorder(Color.BLACK));
	    cell5.setPreferredSize(new Dimension(450, 70));

	    JPanel cell6 = new JPanel();
	    JLabel lab6 = new JLabel();
	    lab6.setText("<html> Mission 5: <br> This is an example </html>");
	    cell6.add(lab6);
	    cell6.setBorder(new LineBorder(Color.BLACK));
	    cell6.setPreferredSize(new Dimension(450, 70));
	    
	    JPanel cell7 = new JPanel();
	    JLabel lab7 = new JLabel();
	    lab7.setText("<html> Mission 6: <br> This is an example </html>");
	    cell7.add(lab7);
	    cell7.setBorder(new LineBorder(Color.BLACK));
	    cell7.setPreferredSize(new Dimension(450, 70));
	    
	    //We position the components in the frame
	    gb.gridx = 0;
	    gb.gridy = 0;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell0, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 1;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell1, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 2;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell2, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 3;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    gb.insets = new Insets(15, 0, 0, 0);
	    content.add(cell3, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 4;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    gb.insets = new Insets(0, 0, 0, 0);
	    content.add(cell4, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 5;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell5, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 6;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell6, gb);
	    
	    gb.gridx = 0;
	    gb.gridy = 7;
	    gb.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(cell7, gb);
	    
	    this.setContentPane(content);
	    
	}
}
