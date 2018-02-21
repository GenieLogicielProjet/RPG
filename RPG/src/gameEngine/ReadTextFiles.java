package gameEngine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import dataClasses.*;

public class ReadTextFiles {
	private int columns=0;
	private int lines=(-1);
	private int [][] tab;
	private int tampon;
	
	public ReadTextFiles(String file) { 
		try {
			
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int value=0;
		int i=0;
		int j=0;
		while ((line = br.readLine()) != null){
			columns = line.length();
			lines = lines+1;
			System.out.println(line);
		}
		br.close();
		BufferedReader sr = new BufferedReader(new FileReader(file));
		 System.out.println(columns);
		 System.out.println(lines);
		 tab  = new int[lines+1][columns+1];
		 while((line = sr.readLine()) != null){
					while((value=sr.read()) != -1){ 
					 //	value=sr.read();
						 //System.out.println(value);
						 tab[i][j]= value; 
						 System.out.println("i="+i+"j="+j);
						 System.out.println(value);
						 /*switch(value){
						 case 48:
							 System.out.print("0");
							 break;
						 case 49: 
							 System.out.print("1");
							 break;
						 case 13:
							 System.out.println("");
							 break;
						 }*/
					j=j+1;
					if(j==columns) {
						break;
					}
				 }
			if(i==lines) {
				break;
			}
			i=i+1;
			j=0;
		 }
		 System.out.println("");
		 sr.close();
		}catch(FileNotFoundException e){
			   System.out.println("File not found");
		}catch(IOException e) {
			   System.out.println("Line not found");
		}
	}
	public void position(Hero P1){
		tampon = tab[P1.getPosX()][P1.getPosY()];
		tab[P1.getPosX()][P1.getPosY()] = 15;
	}
	public void haut(Hero P1){
		tab[P1.getPosX()][P1.getPosY()]=tampon;
		tampon=tab[P1.getPosX()-1][P1.getPosY()];
		tab[P1.getPosX()-1][P1.getPosY()]=15;
		P1.setPosX(P1.getPosX()-1);
	}
	public void gauche(Hero P1){
		tab[P1.getPosX()][P1.getPosY()]=tampon;
		tampon=tab[P1.getPosX()][P1.getPosY()-1];
		tab[P1.getPosX()][P1.getPosY()-1]=15;
		P1.setPosY(P1.getPosY()-1);
	}
	public void droite(Hero P1){
		tab[P1.getPosX()][P1.getPosY()]=tampon;
		tampon=tab[P1.getPosX()][P1.getPosY()+1];
		tab[P1.getPosX()][P1.getPosY()+1]=15;
		P1.setPosY(P1.getPosY()+1);
	}
	public void bas(Hero P1){
		tab[P1.getPosX()][P1.getPosY()]=tampon;
		tampon=tab[P1.getPosX()+1][P1.getPosY()];
		tab[P1.getPosX()+1][P1.getPosY()]=15;
		P1.setPosX(P1.getPosX()+1);
	}
	public void print() {
		System.out.println(tab[0][0]);
		for(int i=0;i<lines;i=i+1) {
			for(int j=0;j<columns;j=j+1) {
				System.out.print(""+ tab[i][j]);
			}
			System.out.println("");
		}
	}

	@Override
	public String toString() {
		return "ReadTextFiles [columns=" + columns + ", lines=" + lines + ", tab=" + Arrays.toString(tab) + "]";
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getLines() {
		return lines;
	}

	public void setLines(int lines) {
		this.lines = lines;
	}

	public int[][] getTab() {
		return tab;
	}

	public void setTab(int[][] tab) {
		this.tab = tab;
	}
	
	
}
