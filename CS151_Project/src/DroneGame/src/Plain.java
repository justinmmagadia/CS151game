
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;



public class Plain implements MoveableShape 
{
	private int width;
	private int height;
	private int x=0;
	private int y=0;
	BufferedImage img;
	
	public Plain()
	{
		try
		{
			String desktop = System.getProperty ("user.home") + "/Desktop/"; 
			File file = new File (desktop + "background.jpeg"); 
			img = ImageIO.read(file);
			width =img.getWidth();
			height = img.getHeight();
		}
		catch (IOException ioe)
		{
			System.out.println("can't upload image");
		}		
	}
	
	public int height()
	{
		return height;	
	}
	
	public int width()
	{
		return width;	
	}
	
	@Override
	public void draw(Graphics2D g2) 
	{
		g2.drawImage(img, x,y,null);	
		g2.drawImage(img, x+width,y,null);		
	}
	
	@Override
	public void move() 
	{
		if (x<=-width+2)
		{
			x=0;
		}	
		x=x-5;	
	}

}