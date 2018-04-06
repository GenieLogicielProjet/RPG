package gameEngine;

public class EndRoom extends Room {
	private int doorLocation;
	
	public EndRoom(Room lastRoom){
	super();
	boolean b;
	int numberOfObstacles;
	int ruleNumber = 0;
	numberOfObstacles = randomNumber.nextInt(5) + 6;
	System.out.println("EndRoom");
	//Stairs
	roomLayout[12][12].type = 7;
	
	// Initialize the obstacles randomly
	for(int j = 1; j <= numberOfObstacles; j++)
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
	doorLocation = opposed(lastRoom.getDoorLocation());
	if(doorLocation == 0){
		roomLayout[0][1+randomNumber.nextInt(12)].type = 3;
		//System.out.println("haut");
	}
	else if (doorLocation == 1){
		roomLayout[1+randomNumber.nextInt(11)][0].type = 3;
		//System.out.println("gauche");
	}
	else if (doorLocation == 2){
		roomLayout[15][1+randomNumber.nextInt(12)].type = 3;
		//System.out.println("bas");
	}
	else{ 
		roomLayout[1+randomNumber.nextInt(11)][14].type = 3;
		//System.out.println("droite");
	}
}
private int opposed(int number){
		
		if(number == 0){
			//System.out.println("haut");
			return 2;
		}
		if(number == 1){
			//System.out.println("gauche");
			return 3;
		}
		if(number == 2){
			//System.out.println("bas");
			return 0;
		}
		if(number == 3){
			//System.out.println("droite");
			return 1;
		}
		else{
			//System.out.println("Erreur porte");
			return 0;
		}
	}
	public int getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(int doorLocation) {
		this.doorLocation = doorLocation;
	}

}