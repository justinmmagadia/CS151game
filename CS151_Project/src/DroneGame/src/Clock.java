import java.util.Timer;
import java.util.TimerTask;

public class Clock
{	
	public Clock() {
		seconds = 0;
		minutes = 0;
		totalTimeInSeconds = 0;
		collisionDetected = false;
		timer = new Timer();
		score = new Score();
		timertask = new TimerTask() {
			
			@Override
			public void run() {
				if(collisionDetected)
					score.incColCount();
				if(score.getColCount() >=2) {
					resetTimer();
					score.resetColCount();
				}
					
				if(totalTimeInSeconds%90 == 0 ) {
					resetTimer();
					score.incScore();
					score.resetColCount();
				}
				
				if(seconds==60) {
					seconds = 0;
					minutes++;
				}
				else {
					seconds++;
				}
			}
		};
		
		timer.scheduleAtFixedRate(timertask, 1000, 1000);
	}
	
	public void resetTimer() {
		seconds = 0;
		minutes = 0;
		totalTimeInSeconds = 0;
	}
	
	
	TimerTask timertask ;
	int seconds;
	int minutes;
	int totalTimeInSeconds;
	Timer timer;
	Score score;
	boolean collisionDetected;
	
}