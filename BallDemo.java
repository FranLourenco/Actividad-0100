import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

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
        Random aleatorio = new Random(nBolas);
     
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        for(int i = 0; i<nBolas; i++){
            int numeroAleatorio = aleatorio.nextInt();

            BouncingBall ball = new BouncingBall(numeroAleatorio, numeroAleatorio, numeroAleatorio, Color.BLUE, ground, myCanvas);
            bolas.add(ball);
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
