import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class MovingPlain implements Icon
{
	int width;
	int height;
	private MoveableShape shape;
	public MovingPlain(MoveableShape shape)
	{
		this.shape = shape;
		this.width = shape.width();
		this.height =shape.height();
	}
	@Override
	public int getIconHeight() 
	{
		
		return height;
	}

	@Override
	public int getIconWidth() 
	{
		return width;
	}

	@Override
	public void paintIcon(Component arg0, Graphics g, int arg2, int arg3) 
	{
		Graphics2D g2 = (Graphics2D) g;
	    shape.draw(g2);	
	}

}
