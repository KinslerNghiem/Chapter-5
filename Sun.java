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

public class Sun extends JComponent  implements Runnable
{
    // instance variables - replace the example below with your own
    private int x, y, w, h, f, g;
    private Color myColor;
    Random generator = new Random();
    
    /**
     * Constructor for objects of class sun
     */
    public Sun (int x, int y, int w, int h, Color color)
    {
        //#1
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
       
        myColor = color;
        
    }

    @Override
    public void paintComponent(Graphics g)
    {
       //#2
       Graphics2D g2 = (Graphics2D) g;
       
       draw(g2);       
    }
    /**
     * Runner which changes sun color and shape
     */
    public void run()
        {
           int running = 1;
        while(true){

    
            int newX = x + 4;
            x = newX;
            //Morning
            if((running / 460) % 2 == 0){
                myColor = new Color(255,215, 0);
                f = 0;
                g= 0;
            }
            //Night
            else{
                myColor = new Color(255,255,255);
                x=50;
                f = w;
                g = h;
            }
            running++;
               
            try{
                Thread.sleep(14);
            }catch (Exception e){}

            System.out.print(h);
        }

        }
    /**
     *Draws the sun and the moon
     */
    public void draw(Graphics2D page){
        
        page.setColor(myColor);
        page.fillOval(x, y, w, h);
        page.setColor(Color.black);
        page.fillOval(x-20, y, f, g);
    }

}