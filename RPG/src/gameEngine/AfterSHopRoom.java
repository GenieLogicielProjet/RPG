package gameEngine;

public class AfterSHopRoom extends Room{
	private int doorLocation;
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
	public AfterSHopRoom(Room lastRoom){
		super();
		boolean b;
		int numberOfObstacles;
		int ruleNumber = 0;
		numberOfObstacles = randomNumber.nextInt(5) + 6;
		System.out.println("AfterSHopRoom");
		// Initialize the obstacles randomly
		for(int j = 1; j <= numberOfObstacles; j++)
		{
			b = randomNumber.nextBoolean();
			if(b) {
				ruleNumber = randomNumber.nextInt(12)+1;
				if(ruleNumber<12){
					if(ruleNumber>1){
						roomLayout[j][ruleNumber].type = 1;
					}
				}
				else{
					j=j-1;
				}
			}
			else {
				ruleNumber = randomNumber.nextInt(11)+1;
				if(ruleNumber<11){
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
		
		// Placing the door  
		
		
		
				
		doorLocation = opposed(lastRoom.getDoorLocation());
		if(doorLocation == 0){
			PreviousPosPlayer[0] = 0 ;
			PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 6;
			//System.out.println("haut");
		}
		else if (doorLocation == 1){
			PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
			PreviousPosPlayer[1] = 0 ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 6;
			//System.out.println("gauche");
		}
		else if (doorLocation == 2){
			PreviousPosPlayer[0] = 15 ;
			PreviousPosPlayer[1] = 1+randomNumber.nextInt(12) ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 6;
			//System.out.println("bas");
		}
		else if (doorLocation == 3){ 
			PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
			PreviousPosPlayer[1] = 14 ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 6;
			//System.out.println("droite");
		}
				
		
				int tampon = doorLocation;
				for(int i=0;i<1;i++){
					doorLocation = randomNumber.nextInt(4);
					if(doorLocation != tampon){
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
					else{
						i=i-1;
					}
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
