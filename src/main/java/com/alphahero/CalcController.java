package com.alphahero;

// stucture/calc-mvc/CalcController.java - Controller
//    Handles user interaction with listeners.
//    Calls View and Model as needed.
// Fred Swartz -- December 2004

import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CalcController implements ActionListener {
	private Timer timer;

	// ... The Controller needs to interact with both the Model and View.
	private CalcModel m_model;
	private CalcView m_view;
	private Userinterface userint;

	static TimerThread t1;

	public CalcController(CalcModel model, CalcView view) {
		// initiating models
		this.m_model = model;
		this.m_model.sendCalcController(this);
		this.m_view = view;
		this.m_view.sendCalcController(this);
		this.userint = new Userinterface();

		// Initiate the other processing thread
		t1 = new TimerThread(model, 50);
	}

	public void startAnimation() {
		// Create, and start, the timer-object responsible for the animation
		// Signal every 10 milliseconds (actionPerformed is called)
		timer = new Timer(10, this);

		// Starta processing threads
		timer.start();
		t1.start();
	}

	public void pauseOrResumeGame() {
		if (this.timer.isRunning()) {
			this.timer.stop();
			CalcController.t1.pausa();
		} else {
			this.timer.start();
			CalcController.t1.pausa();
		}
	}

	/**
	 * -1 = cross 0 = yes 1 = no 2 = cancel
	 */
	public void gameIsOver() {
		int val;
		val = JOptionPane.showConfirmDialog(null,
				"Game Over!\nVill du spara din Highscore? ");
		switch (val) {
		case -1:
			System.exit(0);
			break;
		case 0:
			userint.addScore(m_model.getPoangRakning());
			userint.removeScore();
			userint.closeFile();
			new HighScoreView();
			break;
		case 1:
			System.exit(0);
			break;
		case 2:
			break;
		}
	}

	public void actionPerformed(ActionEvent e) {
		this.m_model.move();
		this.m_view.repaint();
		m_model.checkShapeDead();

		// count points
		m_view.setPointsField(m_model.getPoangRakning());
	}
}