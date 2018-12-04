import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

public class Clock
{	
	public Clock() {
		
		seconds = 0;
		minutes = 0;
		totalTimeInSeconds = 0;
		collisionDetected = false;
		timer = new Timer();
		score = new Score();
		timelabel = new JLabel(minutes + ":" + seconds);
		scorelabel = new JLabel("Score is"+score.score);
		timertask = new TimerTask() {
			
			@Override
			public void run() {
				totalTimeInSeconds++;
				System.out.println("seconds"+totalTimeInSeconds);
				timelabel.repaint();
				minutes = totalTimeInSeconds/60;
				seconds = (int) totalTimeInSeconds%60;
				if(collisionDetected)
					score.incColCount();
				
				if(score.getColCount() >=2) {
					resetTimer();
					System.out.println("collisionDetected" + score.collisionCount);
					score.resetColCount();
					timelabel.repaint();
				}
					
				if(totalTimeInSeconds == 90  ) {
					resetTimer();
					score.incScore();
					score.resetColCount();
					scorelabel.repaint();
				}
					
				timelabel.setText(minutes + ":" + seconds);
				scorelabel.setText("Score is"+score.score);
			}
		};
		
		timer.scheduleAtFixedRate(timertask, 100, 1000);
	}
	
	public void resetTimer() {
		seconds = 0;
		minutes = 0;
		totalTimeInSeconds = 0;
	}
	
	JLabel timelabel;
	JLabel scorelabel; 
	TimerTask timertask ;
	int seconds;
	int minutes;
	int totalTimeInSeconds;
	Timer timer;
	Score score;
	boolean collisionDetected;
	
}