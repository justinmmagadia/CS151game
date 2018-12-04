
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class GameFrame extends JFrame implements KeyListener {

	Drone drone = new Drone();
	Clock clock;
	JLayeredPane lpane;
	JPanel panelBG;
	JPanel scoreboard;
	PlanesLayerPanel planesPanel;
	MoveableShape plain;
	MovingPlain icon;
	JLabel backgroundlabel;
	JLabel droneLabel;

	public GameFrame() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if (key.getKeyCode() == KeyEvent.VK_UP)
			drone.up();
		if (key.getKeyCode() == KeyEvent.VK_DOWN)
			drone.down();
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
			drone.left();
		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
			drone.right();
	}

	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub

	}
}
