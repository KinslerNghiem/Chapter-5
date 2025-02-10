/**
 * Methods to draw the road, grass, and construction site in the cityscape.
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Floor extends JComponent
{
    private int x, y, w, h;
    private Color myColor;

    Random rand = new Random();
    /**
     * Overloaded Constructor of Floor that does not take width or height
     *
     * @param int x, int y, Color color
     */
    public Floor(int x, int y, Color color)
    {
       this.x = x;
       this.y =y;
       myColor = color;
    }
   
    /**
     * Constructor for objects of class Floor
     *
     * @param int x, int y, int w, int h, Color color
     */
    public Floor (int x, int y, int w, int h, Color color)
    {
        //#1
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
       
        myColor = color;
    }
   

    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     * @param g a reference to the Graphics object used for all drawing operations
     */
    @Override
    public void paintComponent(Graphics g)
    {
       //#2
       Graphics2D g2 = (Graphics2D) g;
       
       draw(g2);
       
    }
   
    /**
     * Draws the main backgrounds (grass, road, construction site)
     *
     * @param Graphics2D page
     */    
    public void draw (Graphics2D page)
    {
        page.setColor(myColor);
        page.fillRect(x,y,w,h);
       
    }
    /**
     * Draws the cones (basically a triangle), draws 16 of them equally spaced out from each other, this shows the road is CLOSED.
     *
     * @param Graphics2D page
     */
    public void drawCone(Graphics2D page) {
        page.setColor(myColor);
        for (int i = 0; i < 16; i++) {
            int offsetX = i * 50;
            page.setColor(myColor);
           
            Polygon cone = new Polygon();
                cone.addPoint(x + offsetX, y + h);
                cone.addPoint(x + offsetX + w / 2, y);
                cone.addPoint(x + offsetX + w, y + h);
            page.fillPolygon(cone);
       
    }
}
   
    /**
     * Draws the pothole on the road (the reason there are no cars, because the road is closed).
     *
     * @param Graphics2D page
     */
    public void drawpotHole(Graphics2D page) {
        page.setColor(myColor);

        //Creates a polygon with irregular sides using the polygon class to make it easier.
        //Found on Oracle's Java API.
        Polygon pothole = new Polygon();
        pothole.addPoint(x, y + 30);  
        pothole.addPoint(x + 9, y + 4);
        pothole.addPoint(x + 32, y);
        pothole.addPoint(x + 60, y + 8);
        pothole.addPoint(x + 88, y);
        pothole.addPoint(x + 115, y + 12);
        pothole.addPoint(x + 112, y + 40);
        pothole.addPoint(x + 126, y + 60);
        pothole.addPoint(x + 99, y + 78);
        pothole.addPoint(x + 72, y + 87);
        pothole.addPoint(x + 43, y + 83);
        pothole.addPoint(x + 3, y + 70);
        page.fillPolygon(pothole);
   
    }
   
   
}