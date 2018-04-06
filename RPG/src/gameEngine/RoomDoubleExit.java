package gameEngine;

public class RoomDoubleExit extends Room{
	private int doorLocation;
	private int doorLocation1;
	public RoomDoubleExit(Room lastRoom)
	{
		super();
		
		System.out.println("RoomDoubleExit");
		doorLocation = opposed(lastRoom.getDoorLocation());
		//System.out.println("PORT Origin");
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
		
		int tampon = doorLocation;
		for(int i=0;i<1;i++){
			doorLocation = randomNumber.nextInt(4);
			if(doorLocation != tampon){
				//System.out.println("PORT Shop");
				if(doorLocation == 0){
					roomLayout[0][1+randomNumber.nextInt(12)].type = 4;
					//System.out.println("---haut");
				}
				else if (doorLocation == 1){
					roomLayout[1+randomNumber.nextInt(11)][0].type = 4;
					//System.out.println("---gauche");
				}
				else if (doorLocation == 2){
					roomLayout[15][1+randomNumber.nextInt(12)].type = 4;
					//System.out.println("---bas");
				}
				else {
					roomLayout[1+randomNumber.nextInt(11)][14].type = 4;
					//System.out.println("---droite");
				}
			}
			else{
				i=i-1;
			}
		}
		
		int tampon1 = doorLocation;
		for(int j=0;j<1;j++){
			doorLocation1 = randomNumber.nextInt(4);
			if(doorLocation1 != tampon1){
				//System.out.println("PORT AfterShop");
				if(doorLocation1 != tampon){
					if(doorLocation1 == 0){
						roomLayout[0][1+randomNumber.nextInt(12)].type = 5;
						//System.out.println("---haut");
					}
					else if (doorLocation1 == 1){
						roomLayout[1+randomNumber.nextInt(11)][0].type = 5;
						//System.out.println("---gauche");
					}
					else if (doorLocation1 == 2){
						roomLayout[15][1+randomNumber.nextInt(12)].type = 5;
						//System.out.println("---bas");
					}
					else {
						roomLayout[1+randomNumber.nextInt(11)][14].type = 5;
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
