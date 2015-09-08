import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.io.*;

public class HighScoreView extends JFrame
{

  public HighScoreView()
  {
    // ------------------------------------
    // Define document styles
    // ------------------------------------
    // Build the UI
    JFrame frame = new JFrame("Highscore");
    final MyTextPane2 textPane = new MyTextPane2();
    frame.add(textPane);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setSize( 420, 425 );
    frame.setResizable(false);
    frame.setVisible(true);
  }
    
  private static class MyTextPane2 extends JTextPane {
    public MyTextPane2() {
        super();
        userinterface ui = new userinterface();
        ui.removeScore();
        
        
        
        SimpleAttributeSet aSet = new SimpleAttributeSet();  
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);  
        StyleConstants.setUnderline(aSet, true);
        StyleConstants.setFontFamily(aSet, "sansserif"); 
        StyleConstants.setFontSize(aSet, 40);  
        
        SimpleAttributeSet bSet = new SimpleAttributeSet();  
        StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);  
        StyleConstants.setFontFamily(bSet, "sansserif");  
        StyleConstants.setFontSize(bSet, 16);
        
        
        
        setFont(new Font("sansserif", Font.BOLD, 16));
        setText("HIGHSCORE\n\n"+ui.listBooks());
        
        
        
        StyledDocument doc = this.getStyledDocument();  
        doc.setParagraphAttributes(0, 10, aSet, false);  
        doc.setParagraphAttributes(11, doc.getLength(), bSet, false);
        
        
        
        //FönsterInfo
        setOpaque(false);
        setEditable(false);
        setBackground(new Color(0,0,0,0));
        
    }
    @Override
    protected void paintComponent(Graphics g) {
      // set background green - but can draw image here too
      
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, getWidth(), getHeight());

      // uncomment the following to draw an image
      try {
        Image image = ImageIO.read(getClass().getResource("menu-background.jpg"));
        g.drawImage(image, 0, 0, this);
      } catch (IOException io)
      {
      }
      super.paintComponent(g);
    }
  }
}