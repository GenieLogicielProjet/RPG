package gameDisplay;

public class Animation {
	private long animationTime;
	private long timeRemaining;
	private boolean [][]areaOfEffect = new boolean[16][15];
	private int roomNumber;
	private int floorNumber;
	private boolean active;

	public Animation(long animationTime) {
		this.animationTime = animationTime;
		timeRemaining = animationTime;
		active = false;
		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 15; j++)
				areaOfEffect[i][j] = false;
		}
	}
	
	public long getAnimationTime() {
		return animationTime;
	}

	public long getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(long timeRemaining) {
		this.timeRemaining = timeRemaining;
		if(timeRemaining <= 0)
		{
			setActive(false);
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
		if(active == false)
		{
			for(int i = 0; i < 16; i++)
			{
				for(int j = 0; j < 15; j++)
				{
					areaOfEffect[i][j] = false;
				}
			}
		}
	}
	public void setAreaOfEffect(int x, int y, boolean value, int floorNumber, int roomNumber) {
		areaOfEffect[x][y] = value;
		this.roomNumber = roomNumber;
		this.floorNumber = floorNumber;
	}
	public boolean isAreaOfEffect(int floorNumber, int roomNumber, int x, int y) {
		if(floorNumber == this.floorNumber && roomNumber == this.roomNumber)
		{
			return areaOfEffect[x][y];
		}
		else
			return false;
	}
}
