import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
 public class Drone extends JLabel implements MoveableShape,KeyListener {
	 BufferedImage drone;
		int x;
		int y;
	 	public Drone() {
	 		x = 30;
	 		y = 230;
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
		g2.drawImage(drone.getScaledInstance(60, 60, 0), x, y,null);
	}
 	@Override
	public void move() {
		// TODO Auto-generated method stub
 	}
 	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 60;
	}
 	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 60;
	}
 	
 	public void up()
 	{
 		y=y-5;
 	}
 	
 	public void down()
 	{
 		y=y+5;
 	}
 	
 	public void left()
 	{
 		x=x-5;
 	}
 	
 	public void right()
 	{
 		x=x+5;
 	}

	@Override
	public void keyPressed(KeyEvent key) {
		// TODO Auto-generated method stub
		if (key.getKeyCode() == KeyEvent.VK_UP)
			up();
		if (key.getKeyCode() == KeyEvent.VK_DOWN)
			down();
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
			left();
		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
			right();
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