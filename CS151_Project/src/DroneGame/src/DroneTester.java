
import javax.swing.JFrame;

public class DroneTester {

	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		Drone d = new Drone();
		f.add(d);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000, 1000);
	}
}
