import javax.swing.JFrame;
import java.awt.*;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 *
 * @author Tien Nghiem
 * @version 18 July 2014
 */
public class CityscapeViewer
{
    
    static final int ANIMATION_TIME_IN_SECONDS = 1000;
   
    /**
     * main method for the program which creates and configures the frame for the program
     *
     * @param args  not used
     */
    public static void main(String[] args) throws InterruptedException
    {
        // create and configure the frame (window) for the program
        JFrame frame = new JFrame();
        Cityscape city = new Cityscape();
       
        frame.setSize(2000, 2000);
        frame.setTitle("Cityscape");
        frame.setBackground(Color.red);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        // a frame contains a single component; create the Cityscape component and add it to the frame
        //Cityscape component = new Cityscape();
     
        frame.add(city);
        //frame.add(row);
       
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
       
        // animate the cityscape
        for( int seconds = 0; seconds < ANIMATION_TIME_IN_SECONDS; seconds++ )
        {
            city.nextFrame();
            Thread.sleep( 100 );
        }
       
    }

}