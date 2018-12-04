import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DroneGameMain {

	public static void main(String[] args) {
		MoveableShape plain;
		MovingPlain icon;
		JLabel backgroundlabel;
		JLabel droneLabel;
		GameFrame gf = new GameFrame();

		// create drone and main layered pane
		gf.drone = new Drone();
		gf.lpane = new JLayeredPane();
		gf.panelBG = new JPanel();
		gf.clock = new Clock();
		gf.scoreboard = new JPanel();

		// create background
		plain = new Plain();
		icon = new MovingPlain(plain);
		backgroundlabel = new JLabel(icon);

		gf.planesPanel = new PlanesLayerPanel();
		gf.planesPanel.setLayout(new BorderLayout());
		gf.planesPanel.setBounds(0, 0, 537, 340);
		gf.planesPanel.setOpaque(false);

		droneLabel = new JLabel(new ShapeIcon(gf.drone));
		gf.planesPanel.add(droneLabel);
		gf.panelBG.setBounds(0, 0, 537, 340);
		gf.panelBG.add(backgroundlabel);
		gf.panelBG.setOpaque(false);

		gf.scoreboard.setLayout(new FlowLayout());
		gf.scoreboard.add(gf.clock.timelabel);
		gf.scoreboard.add(gf.clock.scorelabel);
		gf.planesPanel.add(gf.scoreboard, BorderLayout.NORTH);
		gf.scoreboard.setOpaque(false);

		gf.lpane.setBounds(0, 0, 600, 400);
		gf.lpane.add(gf.panelBG, 0, 0);
		gf.lpane.add(gf.planesPanel, 0, 0);

		JPanel buttonPanel = new JPanel();
		JButton up = new JButton("up");
		JButton down = new JButton("down");
		JButton left = new JButton("left");
		JButton right = new JButton("right");

		up.addActionListener(event -> {
			gf.drone.up();
			// droneLabel.setLocation(drone.x, drone.y);
		});
		down.addActionListener(event -> {
			gf.drone.down();
			// droneLabel.setLocation(drone.x, drone.y);
		});
		left.addActionListener(event -> {
			gf.drone.left();
			// droneLabel.setLocation(drone.x, drone.y);
		});
		right.addActionListener(event -> {
			gf.drone.right();
			// droneLabel.setLocation(drone.x, drone.y);
		});
		buttonPanel.add(up);
		buttonPanel.add(down);
		buttonPanel.add(left);
		buttonPanel.add(right);
		gf.planesPanel.add(buttonPanel, BorderLayout.SOUTH);

		gf.setPreferredSize(new Dimension(537, 370));
		gf.setLayout(new BorderLayout());
		gf.add(gf.lpane);
		gf.setLocationRelativeTo(null);
		gf.pack();
		gf.setVisible(true);

		final int DELAY = 100;
		// Milliseconds between timer ticks
		// Milliseconds between timer ticks
		Timer t1 = new javax.swing.Timer(DELAY, event -> {
			plain.move();
			backgroundlabel.repaint();

		});

		t1.start();

		Timer t2 = new javax.swing.Timer(1000, event -> {
			for (Plane p : gf.planesPanel.planes) {
				if (gf.drone.x < p.width() + p.x && gf.drone.x + 60 > p.x && gf.drone.y < p.y + p.height()
						&& gf.drone.y + 60 > p.y) {
					gf.clock.score.incColCount();
					break;
				}
			}
		});

		t2.start();
	}
}
