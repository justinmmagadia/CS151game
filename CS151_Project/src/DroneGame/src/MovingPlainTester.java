import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingPlainTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLayeredPane lpane = new JLayeredPane();
		JPanel panelBG = new JPanel();
		JPanel panelPlane = new JPanel();

		final MoveableShape plain = new Plain();
		MovingPlain icon = new MovingPlain(plain);
		final JLabel backgroundlabel = new JLabel(icon);

		MoveableShape airplane = new Plane(50, 50, 50);
		ShapeIcon airplaneIcon = new ShapeIcon(airplane);
		final JLabel airplanelabel = new JLabel(airplaneIcon);
		airplanelabel.setBounds(0, 0, 600, 400);
		
		MoveableShape drone = new Drone();
		ShapeIcon droneIcon = new ShapeIcon(drone);
		final JLabel dronelabel = new JLabel(droneIcon);
		dronelabel.setLocation(35, 45);
		
		frame.setPreferredSize(new Dimension(600, 400));
		frame.setLayout(new BorderLayout());
		frame.add(lpane, BorderLayout.CENTER);
		lpane.setBounds(0, 0, 600, 400);
		panelPlane.setBounds(0, 0, 600, 400);
		panelPlane.setLocation(0, 0);
		panelBG.setBounds(0, 0, 600, 400);

		panelBG.add(backgroundlabel);
		panelBG.setOpaque(true);

		panelPlane.add(airplanelabel);
		panelPlane.add(dronelabel);
		panelPlane.setOpaque(false);

		lpane.add(panelBG, new Integer(0), 0);
		lpane.add(panelPlane, new Integer(1), 0);

		frame.pack();
		frame.setVisible(true);

		final int DELAY = 100;
		// Milliseconds between timer ticks
		// Milliseconds between timer ticks
		Timer t = new javax.swing.Timer(DELAY, event -> {
			plain.move();
			// airplane.move();
			backgroundlabel.repaint();
			if (airplanelabel.getX() < 0)
				airplanelabel.move(450, 5);
			airplanelabel.move(airplanelabel.getX() - 5, airplanelabel.getY());
			airplanelabel.repaint();
		});

		t.start();
	}

}
