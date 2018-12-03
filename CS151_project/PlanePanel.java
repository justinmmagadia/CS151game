import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JPanel;

public class PlanePanel extends JPanel
{
	Plane[] planes = new Plane[2];
	
	public PlanePanel()
	{
		 final int DELAY = 100;
	      // Milliseconds between timer ticks
	      Timer t = new Timer(DELAY, event ->
	      {
	         
	      });
	      t.start();
	}
}
