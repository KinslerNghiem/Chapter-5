/**
 * Main class for the city
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class that creates instances of the classes that comprise the cityscape and delegates drawing the
 *  cityscape to these object.
 *
 * @author Tien Nghiem
 * @2/2/25
 */
public class Cityscape extends JComponent
{
   
    private final int HEIGHT_MIN = 450;
    private final int VARIANCE = 45;
   
    Random rand = new Random();
    private Car car, b, c, d, e, f;
   
    private Floor ground, groundRoad, roadStripe, constructSite, cone, cone2, hole, hole2;
    private Sky background;
    private Sun sun;
    public Buildings building1, building2, building3, building4;
    private Crane crane;
    private Windows window, window2, window3;
   
    public Cityscape(){//#1 Constructs objects
       
        int h1, h2, h3, hole1;
       
        h1 = HEIGHT_MIN + rand.nextInt(VARIANCE);
        h2 = HEIGHT_MIN + rand.nextInt(VARIANCE);
        h3 = HEIGHT_MIN + rand.nextInt(VARIANCE);
        hole1 = rand.nextInt(200) + 1000;
       
        building1 = new Buildings (200, 600, new Color(160, 160, 160), h1, 247);
        window= new Windows(200, 600, new Color(240, 255, 255), h1, 247);
        building2 = new Buildings (600, 625, new Color(160, 160, 160), h2, 273);
        window2 = new Windows(600, 625, new Color(240, 255, 255), h2, 273);
        building3 = new Buildings (1100, 650, new Color(160, 160, 160), h3, 200);
        window3 = new Windows(1100, 650, new Color(240, 255, 255), h3, 200);

        ground = new Floor (0, 600, 2500, 500, new Color(107,142,35));
        groundRoad = new Floor(0,745, 2500, 200, Color.black);
        roadStripe = new Floor(0,829, 2500, 10, Color.yellow);
        cone=  new Floor(hole1 - 1000,760, 28, 31, Color.orange);
        constructSite = new Floor(1490,600, 700, 190, new Color(240,230,140));
        hole = new Floor(hole1, 747, new Color(139, 69, 19));
        hole2 = new Floor(hole1 - 200, 747, new Color(139, 69, 19));
        cone2 = new Floor(hole1 + 150, 760, 28,31, Color.orange);
       
        crane = new Crane(1800,600, Color.yellow, 450, 4, 170);
        car = new Car(1800, 920, Color.red, 60, 80);
        b= new Car(1800 , 920, new Color(173, 255, 47), 60, 80);
        c= new Car(1800, 920, new Color(100, 149, 237), 70, 80);
        d = new Car(1800, 920, new Color(128, 2, 128), 60, 87);
        e = new Car(1800, 920, new Color(240, 255, 240), 60, 80);
        f = new Car(1800, 920, new Color(72,209,204), 60, 80);
       

        background = new Sky(0, 0, 3000, 3000, new Color(179, 225, 231));
        sun = new Sun(80, 55, 80, 80, new Color(255,215,0));
       
        

                
        Thread t1 = new Thread(sun);
        t1.start();
        Thread t2 = new Thread(background);
        t2.start();
        Thread t3= new Thread(window);
        t3.start();
        Thread t4= new Thread(window2);
        t4.start();
        Thread t5= new Thread(window3);
        t5.start();
        Thread t6 = new Thread(crane);
        t6.start();
        Thread t7 = new Thread(car);
        t7.start();
        Thread t8 = new Thread(b);
        t8.start();
        Thread t9 = new Thread(c);
        t9.start();
        Thread t10 = new Thread(d);
        t10.start();
        Thread t11 = new Thread(e);
        t11.start();
        Thread t12 = new Thread(f);
        t12.start();
       
       
       
        setSize (800, 1000);
    }
   
    /**
     * This method is invoked by the Java Run-Time whenever the component needs to be redrawn.
     * It does not need to be invoked explicitly.
     *
     * @param g a reference to the Graphics object used for all drawing operations
     *
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
       
        // invoke the draw method on each object in your Cityscape
        Graphics2D page = (Graphics2D) g;
       
        background.draw(g2);
        sun.draw(g2);
        ground.draw(g2);
       
        constructSite.draw(g2);
        groundRoad.draw(g2);
        hole.drawpotHole(g2);
        hole2.drawpotHole(g2);
        roadStripe.draw(g2);
        cone.drawCone(g2);
        cone2.drawCone(g2);
       
        sun.draw(g2);
       
        building1.draw(g2);
        building2.draw(g2);
        building3.draw(g2);
        window.draw(g2);
        window2.draw(g2);
        window3.draw(g2);
       
        crane.draw(g2);
        car.draw(g2);
        b.draw(g2);
        c.draw(g2);
        d.draw(g2);
        e.draw(g2);
        f.draw(g2);
       

    }
   
    /**
     * Animate the cityscape by updating the objects such that they appear to be animated when
     *      they are next drawn.
     *
     */
    public void nextFrame()
    {
        // update the objects in the cityscape so they are animated
        // ...
       
       
       
        // request that the Java Runtime repaints this component by invoking its paintComponent method
        //  do not explicitly invoke the paintComponent method
        repaint();
    }

}
