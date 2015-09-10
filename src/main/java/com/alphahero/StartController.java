package com.alphahero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {
    //========================================================== constructor
    /** Constructor */
    StartController(StartView view) {
        //OptionView ov = new OptionView();
        //... Add listeners to the view.
        view.addNewGameListener(new NewGameListener());
        view.addHighscoreListener(new HighscoreListener());
        view.addOptionListener(new OptionListener());   
        
    }

    class NewGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          System.out.println("New Game");
          CalcMVC newgame = new CalcMVC();
          newgame.startaSpelet();
        }
    }//end inner class MultiplyListener
     
    class HighscoreListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Highscore");
          HighScoreView hsv = new HighScoreView();
        }
    }// end inner class ClearListener
    
    class OptionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
          System.out.println("Option");
          OptionView ov = new OptionView(); //Går till optionview
      }
    }
}