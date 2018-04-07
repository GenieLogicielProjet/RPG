package gameEngine;

import java.util.Random;

public class BasicRoom extends Room{
	private int doorLocation;
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
	public BasicRoom()
	{
		super();
		boolean b;
		int numberOfObstacles;
		int ruleNumber = 0;
		numberOfObstacles = randomNumber.nextInt(5) + 6;
		System.out.println("BasicRoom");
		//Escalier
		roomLayout[2][2].type = 8;
		PreviousPosPlayer[0] = 2;
		PreviousPosPlayer[1] = 2;
		
		// Initialize the obstacles randomly
		for(int j = 2; j <= numberOfObstacles; j++)
		{
			b = randomNumber.nextBoolean();
			if(b) {
				ruleNumber = randomNumber.nextInt(14)+1;
				if(ruleNumber<14){
					if(ruleNumber>1){
						roomLayout[j][ruleNumber].type = 1;
					}
				}
				else{
					j=j-1;
				}
			}
			else {
				ruleNumber = randomNumber.nextInt(13)+1;
				if(ruleNumber<13){
					if(ruleNumber>1){
						roomLayout[ruleNumber][j].type = 1;
					}
				}
				else{
					j=j-1;
				}
			}	
		}
		numberOfObstacles -= 4;
		doorLocation = randomNumber.nextInt(4);
		if(doorLocation == 0){
			NextPosPlayer[0]=0;
			NextPosPlayer[1]=1+randomNumber.nextInt(12);
			roomLayout[NextPosPlayer[0]][NextPosPlayer[1]].type = 4;
			//System.out.println("---haut");
		}
		else if (doorLocation == 1){
			NextPosPlayer[0]=1+randomNumber.nextInt(11);
			NextPosPlayer[1]=0;
			roomLayout[NextPosPlayer[0]][NextPosPlayer[1]].type = 4;
			//System.out.println("---gauche");
		}
		else if (doorLocation == 2){
			NextPosPlayer[0]=15;
			NextPosPlayer[1]=1+randomNumber.nextInt(12);
			roomLayout[NextPosPlayer[0]][NextPosPlayer[1]].type = 4;
			//System.out.println("---bas");
		}
		else {
			NextPosPlayer[0]=1+randomNumber.nextInt(11);
			NextPosPlayer[1]=14;
			roomLayout[NextPosPlayer[0]][NextPosPlayer[1]].type = 4;
			//System.out.println("---droite");
		}
	}
	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}
	public int getPreviousPosPlayer(int indice) {
		return PreviousPosPlayer[indice];
	}
	public int getNextPosPlayer(int indice) {
		return NextPosPlayer[indice];
	}
	public int getDoubleNextPosPlayer(int indice) {
		return DoubleNextPosPlayer[indice];
	}
	
}
