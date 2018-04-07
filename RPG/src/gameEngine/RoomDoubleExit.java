package gameEngine;

public class RoomDoubleExit extends Room{
	private int doorLocation;
	private int doorLocation1;
	private int[] PreviousPosPlayer = new int[2];
	private int[] NextPosPlayer = new int[2];
	private int[] DoubleNextPosPlayer = new int[2];
	
	public RoomDoubleExit(Room lastRoom)
	{
		super();
		
		System.out.println("RoomDoubleExit");
		doorLocation = opposed(lastRoom.getDoorLocation());
		System.out.println("PORT previous");
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
		else if (doorLocation == 3){ 
			PreviousPosPlayer[0] = 1+randomNumber.nextInt(11) ;
			PreviousPosPlayer[1] = 14 ;
			roomLayout[PreviousPosPlayer[0]][PreviousPosPlayer[1]].type = 3;
			//System.out.println("droite");
		}
		
		int tampon = doorLocation;
		System.out.println("PORT origin");
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
				else if (doorLocation == 3){
					NextPosPlayer[0]=1+randomNumber.nextInt(11);
					NextPosPlayer[1]=14;
					roomLayout[NextPosPlayer[0]][NextPosPlayer[1]].type = 4;
					//System.out.println("---droite");
				}
			}
			else{
				i=-1;
			}
		}
		
		int tampon1 = doorLocation;
		for(int j=0;j<1;j++){
			doorLocation1 = randomNumber.nextInt(4);
			if(doorLocation1 != tampon1){
				System.out.println("PORT AfterShop");
				if(doorLocation1 != tampon){
					if(doorLocation1 == 0){
						DoubleNextPosPlayer[0]=0;
						DoubleNextPosPlayer[1]=1+randomNumber.nextInt(12);
						roomLayout[DoubleNextPosPlayer[0]][DoubleNextPosPlayer[1]].type = 5;
						//System.out.println("---haut");
					}
					else if (doorLocation1 == 1){
						DoubleNextPosPlayer[0]=1+randomNumber.nextInt(11);
						DoubleNextPosPlayer[1]=0;
						roomLayout[DoubleNextPosPlayer[0]][DoubleNextPosPlayer[1]].type = 5;
						//System.out.println("---gauche");
					}
					else if (doorLocation1 == 2){
						DoubleNextPosPlayer[0]=15;
						DoubleNextPosPlayer[1]=1+randomNumber.nextInt(12);
						roomLayout[DoubleNextPosPlayer[0]][DoubleNextPosPlayer[1]].type = 5;
						//System.out.println("---bas");
					}
					else {
						DoubleNextPosPlayer[0]=1+randomNumber.nextInt(11);
						DoubleNextPosPlayer[1]=14;
						roomLayout[DoubleNextPosPlayer[0]][DoubleNextPosPlayer[1]].type = 5;
						//System.out.println("---droite");
					}
				}
				else{
					j=j-1;
				}
			}
			else{
				j=j-1;
			}
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

	public int getDoorLocation1() {
		return doorLocation1;
	}


	public void setDoorLocation1(int doorLocation1) {
		this.doorLocation1 = doorLocation1;
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
	
}
