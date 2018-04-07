package gameEngine;

public class EndRoom extends Room {
	private int doorLocation;
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
	
	public EndRoom(Room lastRoom){
	super();
	boolean b;
	int numberOfObstacles;
	int ruleNumber = 0;
	numberOfObstacles = randomNumber.nextInt(5) + 6;
	System.out.println("EndRoom");
	//Stairs
	roomLayout[12][12].type = 7;
	NextPosPlayer[0]=12;
	NextPosPlayer[1]=12;
	
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
	doorLocation = opposed(lastRoom.getDoorLocation());
	if(doorLocation == 0){
		PreviousPosPlayer[0] = 0 ;
		PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
		roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
		//System.out.println("haut");
	}
	else if (doorLocation == 1){
		PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
		PreviousPosPlayer[1] = 0 ;
		roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
		//System.out.println("gauche");
	}
	else if (doorLocation == 2){
		PreviousPosPlayer[0] = 15 ;
		PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
		roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
		//System.out.println("bas");
	}
	else{ 
		PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
		PreviousPosPlayer[1] = 14 ;
		roomLayout[1+randomNumber.nextInt(11)][14].type = 3;
		roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
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