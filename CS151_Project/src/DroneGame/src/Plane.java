
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
   A plane that can be moved around.
*/
public class Plane implements MoveableShape
{ /**
    Constructs a plane item.
    @param x the left of the bounding rectangle
    @param y the top of the bounding rectangle
    @param width the width of the bounding rectangle
 */
 public Plane(int x, int y, int width)
 {
    this.x = x;
    temp = x;
    this.y = y;
    this.width = width;
    height = width*(4/3);
 }

 public void move()
 {
	 Random rand = new Random();
      x= x-4;
    //Resets the animation
    if(x<0)
    {
  	  x=600;
  	  y = rand.nextInt(400);
  	  
    }
 }
 

 public void draw(Graphics2D g2)
 {
    Rectangle2D.Double body = new Rectangle2D.Double(x, y ,  width, width / 3);
    Rectangle2D.Double wing = new Rectangle2D.Double( x+width / 2, y-width/2, width/ 4, width/2);
    Rectangle2D.Double wing2 = new Rectangle2D.Double( x+ width / 2, y+width/3 , width/ 4, width/2);
    g2.setColor(Color.BLACK);
    g2.draw(body);
    g2.draw(wing);
   g2.draw(wing2);
   g2.setColor(Color.WHITE);
   g2.fill(body);
   g2.fill(wing);
   g2.fill(wing2);
 }
 
  int x;
  int y;
 private int width;
 private int height;
 private int temp;
 


@Override
public int height() {
	return width;
}

@Override
public int width() {
	return width;
}

}
