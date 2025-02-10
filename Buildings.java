/**
 * Methods to draw and animate the buildings in the cityscape.
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Buildings extends JComponent // implements Runnable
{
    private int baseX;
    private int baseY;
    private int width;
    private Color color;
    private int height;
   
    Random rand = new Random();
    private int random = rand.nextInt(70) + 20;
    private int randomTwo = rand.nextInt(70)+ 20;
    int randomChoice = rand.nextInt(3);

    /**
     * Constructor for the class.
     *
     *@param int bottom, int floor, Color shade, int tall, int wide.
     */
    public Buildings (int bottom, int floor, Color shade, int tall, int wide)
    {
        baseX = bottom;
        baseY = floor;
        color = shade;
        height = tall;
        width = wide;
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
        Graphics2D g2 = (Graphics2D) g;

        draw(g2);
    }
   /**
     * Draws the buildings and has randomized lightning rods, sometime they appear, sometimes they don't
     *
     *@param Graphics2D page
     */
    public void draw (Graphics2D page)
    {
        int top = baseY - height;  

        page.setColor (color);
        //The actual rectangle, shape of the building
        page.drawRect(baseX, top, width, height);
        page.fillRect(baseX, top, width, height);
         
        //Door
        page.setColor(new Color(139, 69, 19));
        page.fillRect(baseX + ((width - 20) / 2), baseY-40, 30, 40);
       
    //Randomized lightning rods
        if(randomChoice == 1){
        page.setColor(new Color(132,140,128));
        page.fillRect(baseX + (width/4), top- random, 10, random);
        page.fillRect(baseX + (3*width/4), top - randomTwo, 10, randomTwo);
    }
}
}