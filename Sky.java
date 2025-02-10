/**
 * Methods to animate and draw the sky of the city.
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Sky extends JComponent  implements Runnable
{

    private int x, y, w, h, f, g;
    private Color myColor;
    Random generator = new Random();

    /**
     * Constructor for objects of class Sky
     */
    public Sky (int x, int y, int w, int h, Color color)
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
     * Runner to change the color of the sky
     */
    public void run()
        {
           int runningP = 0;
        while(true){
            if(runningP / 460 % 2 == 0){
                myColor = new Color(176, 224, 230);
            }else{
                myColor = Color.black;
            }
            runningP++;
               
            try{
                Thread.sleep(14);
            }catch (Exception e){}

            System.out.print(h);
        }

        }
    
       
    public void draw (Graphics2D page)
    {
        page.setColor(myColor);
        page.fillRect(x,y,w,h);
    }
    
}