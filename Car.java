/**
 * Methods to draw and animate the cars in the cityscape.
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
public class Car extends JComponent  implements Runnable
{
    private int baseX;
    private int baseY;
    private int width;
    private Color color;
    private int height;
   
    Random rand = new Random();
    int speed= rand.nextInt(20) + 9;

    /**
     * Basic constructor for the Car Class
     *
     * @param int center, int floor, Color shade, int tall, int wide
     */
    public Car (int center, int floor, Color shade, int tall, int wide)
    {
        baseX = center;
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
    //@Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        draw(g2);
    }
    /**
     * Runner for the cars so that when the cars run off the screen, they go back to zero. Moves them at a random speed.
     */
    public void run(){
       
    int startX = baseX;

    while (true) {
        baseX -= speed;
        if (Math.abs(baseX - startX) >= 2000) {
            baseX = 2000;
        }

        try {
            Thread.sleep(14);
        } catch (Exception e) {}

        System.out.print(ui);
    }
    }
   
    /**
     * Drawing class to draw rectangles and circles at the bottom corners.
     *
     * @param Graphics2D page
     */
    public void draw(Graphics2D page)
    {
       
    int top = baseY - height;
    int rectBottom = top + height;

    page.setColor(color);
    page.fillRect(baseX, top, width, height);

    int leftCircleX = baseX - 8;
    int rightCircleX = baseX - 2 + width;
   
    // Draw Wheels
    page.setColor(new Color(225, 0, 225));
    page.fillOval(leftCircleX - 9, rectBottom - 10, 20, 20);
    page.fillOval(rightCircleX - 6, rectBottom - 10,20, 20);
   
   
    }
}