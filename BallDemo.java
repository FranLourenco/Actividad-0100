import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList <BouncingBall> bolas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        bolas = new ArrayList<>();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBolas)
    {
        int ground = 400;   // position of the ground line
        Random aleatorio = new Random(50);
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int i = 0; i<nBolas; i++){
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            Color color = new Color(red, green, blue);

            BouncingBall ball = new BouncingBall(aleatorio.nextInt(250), aleatorio.nextInt(400), aleatorio.nextInt(50), color, ground, myCanvas);
            bolas.add(ball);
            bolas.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            Iterator<BouncingBall> it = bolas.iterator();
            myCanvas.wait(50);           // small delay

            for(int i = 0; i < bolas.size(); i++){
                bolas.get(i).move();

                if(bolas.get(i).getXPosition() >= 550) {   // stop once ball has travelled a certain distance on x axis
                    finished = true;
                }
            }
        }
    }
}
