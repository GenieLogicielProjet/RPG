package players;

public class User extends Player{
	private int maxManaPoints;
	private int currentManaPoints;
	
	public User()
	{
		super();
		roomInsidePositionX = 1;
		roomInsidePositionY = 1;
		floorPosition = 0;
		roomPosition = 0;
	}
}
