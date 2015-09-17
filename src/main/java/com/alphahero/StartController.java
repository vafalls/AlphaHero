package com.alphahero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {

	StartController(StartView view) {
		// ... Add listeners to the view.
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
	}

	class HighscoreListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Highscore");
			new HighScoreView();
		}
	}

	class OptionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Option");
			new OptionView();
		}
	}
}