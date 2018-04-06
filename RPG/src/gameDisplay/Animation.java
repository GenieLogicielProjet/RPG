package gameDisplay;

public class Animation {
	private long animationTime;
	private long timeRemaining;
	private boolean [][]areaOfEffect = new boolean[5][5];
	private boolean active;

	public Animation(long animationTime) {
		this.animationTime = animationTime;
		timeRemaining = animationTime;
		active = false;
	}

	public long getAnimationTime() {
		return animationTime;
	}

	public void setAnimationTime(long animationTime) {
		this.animationTime = animationTime;
	}

	public long getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(long timeRemaining) {
		this.timeRemaining = timeRemaining;
		if(timeRemaining <= 0)
		{
			active = false;
		}
	}	
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public void setAreaOfEffect(int x, int y, boolean value) {
		areaOfEffect[x][y] = value;
	}
	public boolean isAreaOfEffect(int x, int y) {
		return areaOfEffect[x][y];
	}
}
