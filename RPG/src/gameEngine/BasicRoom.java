package gameEngine;

import java.util.Random;

public class BasicRoom extends Room{
	
	public BasicRoom()
	{
		super();
		boolean b;
		int numberOfObstacles;
		
		numberOfObstacles = randomNumber.nextInt(9) + 20;
		
		// Initialize the obstacles randomly
		for(int j = 1; j <= 4; j++)
		{
			b = randomNumber.nextBoolean();
			if(b) {
				roomLayout[j][randomNumber.nextInt(14)+1] = 1;
			}
			else {
				roomLayout[randomNumber.nextInt(13)+1][j] = 1;
			}	
		}
		numberOfObstacles -= 4;
	}
}
