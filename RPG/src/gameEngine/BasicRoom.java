package gameEngine;

import java.util.Random;

public class BasicRoom extends Room{
	
	public BasicRoom()
	{
		super();
		boolean b;
		int numberOfObstacles;
		int ruleNumber = 0;
		numberOfObstacles = randomNumber.nextInt(9) + 4;
		
		// Initialize the obstacles randomly
		for(int j = 1; j <= numberOfObstacles; j++)
		{
			b = randomNumber.nextBoolean();
			if(b) {
				ruleNumber = randomNumber.nextInt(14)+1;
				if(ruleNumber<15 && ruleNumber>0){
					roomLayout[j][ruleNumber].type = 1;
				}
				else{
					j=j-1;
				}
			}
			else {
				ruleNumber = randomNumber.nextInt(13)+1;
				if(ruleNumber<14 && ruleNumber>0){
					roomLayout[ruleNumber][j].type = 1;
				}
				else{
					j=j-1;
				}
			}	
		}
		numberOfObstacles -= 4;
	}
}
