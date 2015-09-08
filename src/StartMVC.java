
import javax.swing.*;

/**
 * The game is based on the same experience that you get in Guitar Hero.
 * Bricks are running from right to left with a letter in them. 
 * You need to push the right letter on the keyboard in the squares to score points.
 * 
 * @author Markus och David
 */

public class StartMVC {
  
    public static void main(String[] args) {
        
        StartView       view       = new StartView();
        StartController controller = new StartController(view);
        
        view.setVisible(true);
    }
}