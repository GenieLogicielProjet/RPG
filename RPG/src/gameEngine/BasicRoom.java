package gameEngine;

import java.util.Random;

public class BasicRoom extends Room{
	private int doorLocation;
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
		if(doorLocation == 0)
			roomLayout[0][1+randomNumber.nextInt(12)].type = 4;
		else if (doorLocation == 1)
			roomLayout[1+randomNumber.nextInt(11)][0].type = 4;
		else if (doorLocation == 2)
			roomLayout[15][1+randomNumber.nextInt(12)].type = 4;
		else 
			roomLayout[1+randomNumber.nextInt(11)][14].type = 4;
	}
	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}	
}