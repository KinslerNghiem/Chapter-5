/**
 * Methods to animate and draw the windows on the buildings in the cityscape.
 *
 * @Tien Nghiem
 * @2/2/25
 */
import java.awt.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Windows extends JComponent implements Runnable
{
    private int baseX;
    private int baseY;
    private int width;
    private Color color;
    private int height;
   
    Random rand = new Random();
   
    /**
     * Constructor for Windows class
     *
     * @param int bottom, int floor, Color shade, int tall, int wide
     */
    public Windows (int bottom, int floor, Color shade, int tall, int wide)
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
     * Runner to implement runnable and make the windows change to a random color.
     *
     */
    public void run()
        {
           int running  = 1;
        while(true){
           
            if((running / 460) % 2 == 0){
                color = new Color(240, 255, 255);
            }
            //Night time color
            else{
                int randomColor = rand.nextInt(6);
                if(randomColor == 0){
                    color = new Color(252,243,0);
                }
                if(randomColor == 1){
                    color = new Color(250,128,114);
                }
                if(randomColor == 2){
                    color = new Color(0,250,127);
                }
                if(randomColor == 3){
                    color = new Color(65, 105, 225);
                }
                if(randomColor == 4){
                    color = new Color(30,255,188);
                }
                if(randomColor == 5){
                    color = new Color(255,78,0);
                }
            }
            running++;  
            try{
                Thread.sleep(14);
            }catch (Exception e){}

            System.out.print(ui);
        }

        }
    /**
     * Draws the windows until they reach the end of the building, then go down and do it again on the next row
     *
     *@param Graphics2D page
     */
    public void draw (Graphics2D page)
    {
        int i;
        int j = 30;
        int top = baseY - height;  

        page.setColor (color);

        while (j + 100 < height) {
        i = 30;
        while (i + 20 < width) {
            page.fillRect(baseX + i, top + j, 20, 20);  
            i += 30;
        }
        j += 30;
    }

}
}