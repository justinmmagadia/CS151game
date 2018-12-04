import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;

public class Drone extends JPanel implements MoveableShape, ActionListener, KeyListener {
	BufferedImage drone;
	int x = 50, y = 50, velx = 0, vely = 0;
	public Drone() {
		try {
			File file = new File ("/Users/Justin Magadia/Desktop/Drone.png"); 
			drone = ImageIO.read(file);
			addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g2) {
		// TODO Auto-generated method stub
		super.paintComponent(g2);
		
		g2.drawImage(drone, x, y, null);
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP)
		{
			up();
		}
		if(code == KeyEvent.VK_DOWN)
		{
			down();
		}
		if(code == KeyEvent.VK_LEFT)
		{
			left();
		}
		if(code == KeyEvent.VK_RIGHT)
		{
			right();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		x+=velx;
		y+=vely;
	}
	
	public void up()
	{
		vely = -5;
		velx = 0;
	}
	
	public void down()
	{
		vely= 5;
		velx=0;
	}
	
	public void left()
	{
		velx = -5;
		vely = 0;
	}
	
	public void right()
	{
		velx = 5;
		vely=0;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}




}