package utility;

public class TimeCounter extends Thread{
	private int iterations = 0;
	private long frequency;
	private boolean keepRunning;
	
	public TimeCounter(int frequency) {
		this.frequency = frequency;
		keepRunning = true;
	}
	public void run() {
		while(keepRunning) {
			try {
				Thread.sleep(frequency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iterations += 1;
			System.out.println("counting iterations :" + iterations);
		}
	}
	public int getIterations() {
		return iterations;
	}
	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
		iterations = 0;
		if(keepRunning == false)
			System.out.println("stop running");
	}
}
