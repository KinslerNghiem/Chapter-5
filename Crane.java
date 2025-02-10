/**
 * Methods to animate and draw the crane in the cityscape.
 *
 * @Tien Nghiem
 * @2/2/25
 */

import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
public class Crane extends JComponent implements Runnable
{
    private int baseX, baseXmove;
    private int baseY;
    private int width, cableLength, robotEnd;
    private Color color, boxColor = new Color(139,69,19);    
    private int height;
    private int boxheight = 48 - width;
    private int colorChangerHeight = 80;
   
    Random rand = new Random();
    int i = rand.nextInt(10) + 190;

    /**
     * Constructor for the Crane class.
     *
     * @param int center, int floor, Color shade, int tall, int wide, int cable
     */
    public Crane (int center, int floor, Color shade, int tall, int wide, int cable)
    {
        baseX = center;
        baseXmove = center;
        baseY = floor;
        color = shade;
        height = tall;
        width = wide;
        cableLength = cable;
        robotEnd = 7 + 2 * width - 4 + 40;

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
     * Runner for the crane, moves the arm left and right, and up and down.
     *
     */
    public void run() {
        int originalX = baseXmove;
        int mvmntLim = originalX - 150;
        int mvmntSpeed = 1;
        int pause = 1500;
        int originalCableLength = cableLength;
        int extendedCable = originalCableLength + 190;
        int shortenedCable = originalCableLength - 150;

        while (true) {
            // Move left and moves the arm down as well.
        while (baseXmove > mvmntLim) {
            baseXmove -= mvmntSpeed;
            stop(14);
        }
        for (int i = cableLength; i < extendedCable; i++) {
            cableLength = i;
            stop(13);
        }
        boxColor = getRandomColor();
        for (int i = cableLength; i > shortenedCable; i--) {
            cableLength = i;
            stop(13);
        }
        stop(pause);
        
       
        // Move right and moves the arm down as well.
        while (baseXmove < originalX) {
            baseXmove += mvmntSpeed;
            stop(14);
        }
        for (int i = cableLength; i < extendedCable; i++) {
            cableLength = i;
            stop(13);
        }
        boxColor = getRandomColor();
        for (int i = cableLength; i > shortenedCable; i--) {
            cableLength = i;
            stop(15);
            }
        stop(pause);
        }
    }

    /**
     * Helper method to stop the animation when the crane is moved
     *
     *@param int milliseconds
     */
    private void stop(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {}
    }
   
    /**
     * Gets a random color for the box,called each time it hits the ground.
     */
    private Color getRandomColor() {
    int c = rand.nextInt(5);
    switch (c) {
        case 0: 
            return new Color(65, 105, 225);
        case 1: 
            return new Color(25, 25, 112);  
        case 2: 
            return new Color(178, 34, 34);  
        case 3: 
            return new Color(184, 134, 11);  
        case 4: 
            return new Color(255, 140, 0);  
        default: 
            return Color.gray;
    }
}

    /**
     * Draws the crane
     *
     *@param Graphics2D page
     */
    public void draw(Graphics2D page)
    {
        int space = 30;
        int top = baseY - height;  

        page.setColor (color);
   
        //The main beams
        page.fillRect(baseX, top, width, height);
        page.fillRect(baseX + 15, top, width, height);
       

        page.setColor(new Color(255, 165, 0));

        // Draw diagonal support beams
        for (int y = top; y < baseY; y += space) {
            page.drawLine(baseX + width, y, baseX + 15, y + space);
        }
        for (int y = top; y < baseY; y += space) {
            page.drawLine(baseX + 15, y, baseX + width, y + space);
        }
       
        page.setColor (color);
       
        //The two beams that are horizontal
        page.fillRect(baseX - i -70, top + 40, i + 170, width);
        page.fillRect(baseX - i- 70, top + 55, i + 170, width);
       
        //The support cables to hold the beams
        page.setColor(new Color(255, 165, 0));
        page.drawLine(baseX, top, baseX - i + 30, top + 40);
        page.drawLine(baseX + 15 + width, top, baseX + 50 , top + 40);
       
        //The control room
        page.setColor(new Color(240,230,140));
        page.fillRect(baseX - 18, top + 58, 50, 30);
       
        //Cable to hold the arm
        page.setColor(new Color(70, 130, 180));
        page.fillRect(baseXmove - 80, top + 55 + width, width- 2, cableLength);
        page.fillRect(baseXmove - 88, top + 55 + width, width - 2, cableLength);
       
        //Box to hold the cable
        page.setColor(new Color(205, 133, 63));
        page.fillRect(baseXmove - 100, top + 40, 40, 20);
       
        //Robot arm to hold the box
        page.setColor(Color.white);
        page.fillRect(baseXmove - 110, top + 55 + width + cableLength, robotEnd, width);
        page.fillRect(baseXmove- robotEnd - 59, top + 55 + width + cableLength, width, 20);
        page.fillRect(baseXmove- robotEnd- 11, top + 55 + width + cableLength, width, 20);
       
        //The box that is held by the crane.
        page.setColor(boxColor);
        page.fillRect(baseXmove - 110 + width, top + 55 + 2*width + cableLength, 48 - width, 30);
       
       
    }
}