
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

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
 }

 public void move()
 {
    x= x-5;
    //Resets the animation
    if(x<0)
    {
  	  x=temp;
    }
 }
 

 public void draw(Graphics2D g2)
 {
    Rectangle2D.Double body
          = new Rectangle2D.Double(x, (y + width-20) / 3, 
                width -1, width / 3);
    Rectangle2D.Double wing
    = new Rectangle2D.Double( x+ width / 2, y, width/ 6, width/4);
    Rectangle2D.Double wing2
    = new Rectangle2D.Double( x+ width / 2, y+60 , width/ 6, width/4);
    Ellipse2D.Double window1
          = new Ellipse2D.Double(x + width / 6.5, y + width /3, 
                width / 6, width / 6);
    Ellipse2D.Double window2
          = new Ellipse2D.Double(x + width/2.5, y + width / 3,
                width / 6, width / 6);
    Ellipse2D.Double window3 
    		= new Ellipse2D.Double(x + width/1.5, y + width / 3,
                  width / 6, width / 6); 
  //  Ellipse2D.Double window4
    //= new Ellipse2D.Double(x + width/6, y + width /3, 
      //    width / 6, width / 6);

    // The thruster point attached to plane
    Point2D.Double r1
          = new Point2D.Double(x,y+width-100);
    // The thruster point below the point attached to plane
    Point2D.Double r2
          = new Point2D.Double(x, y+width-10);
    // The thruster point above the point attached to plane
    Point2D.Double r3
          = new Point2D.Double(x-width/3, (y+width-70));
    // The bottom of the rear windshield
  //  Point2D.Double r4
   //       = new Point2D.Double(x +width+30, (y+width-55));
   // Point2D.Double r5
    //= new Point2D.Double(x+width, y+width-40);
//The thruster point above the point attached to plane
//Point2D.Double r6
//    = new Point2D.Double(x+width, (y+width-75));
    Line2D.Double attachedBelow
          = new Line2D.Double(r1, r2);
    Line2D.Double attachedAbove
          = new Line2D.Double(r2, r3);
    Line2D.Double attached
          = new Line2D.Double(r1, r3);
  //  Line2D.Double headABelow
   // = new Line2D.Double(r4, r5);
   // Line2D.Double headAbove
   // = new Line2D.Double(r5, r6);
   // Line2D.Double head
   // = new Line2D.Double(r4, r6);
    
    g2.draw(body);
    g2.draw(wing);
    g2.draw(wing2);
    g2.draw(window1);
    g2.draw(window2);
    g2.draw(window3);
    //g2.draw(window4);
    g2.draw(attachedBelow);
    g2.draw(attachedAbove);
    g2.draw(attached);
 //   g2.draw(headABelow);
//     g2.draw(headAbove);
//    g2.draw(head);
 }
 
 private int x;
 private int y;
 private int width;
 private int temp;
  public void animate()
  {
	  
  }

@Override
public int height() {
	return width;
}

@Override
public int width() {
	// TODO Auto-generated method stub
	return width;
}
}
