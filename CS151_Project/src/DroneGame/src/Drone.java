import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Drone implements MoveableShape {
	BufferedImage drone;

	public Drone() {
		try {
			File file = new File ("/Users/admin/Desktop/Drone.png"); 
			drone = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawImage(drone, null, 15, 45);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return drone.getHeight();
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return drone.getWidth();
	}

}