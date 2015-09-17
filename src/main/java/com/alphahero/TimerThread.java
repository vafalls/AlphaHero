package com.alphahero;

import java.util.Random;


public class TimerThread extends Thread {
	// model
	private static CalcModel m_model;

	// random variables
	private double waiting_time;
	private Random slump;

	// Constants
	private int antal_shapes;
	private int antal_shapes_kvar;
	private static boolean pausat;

	public TimerThread(CalcModel model, int ant_shapes) {
		this.antal_shapes = ant_shapes;
		this.antal_shapes_kvar = ant_shapes;
		this.slump = new Random();
		TimerThread.m_model = model;
		TimerThread.pausat = false;
	}

	public void run() {
		for (int b = 0; b < antal_shapes; b++) {
			waiting_time = slump.nextDouble() + 0.5;
			TimerThread.waiting(waiting_time);
			antal_shapes_kvar--;
		}
	}

	public static void waiting(double n) {
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while ((t1 - t0) < (n * 1000));

		m_model.addShapeToArraylist(pausat);
	}

	public int getNoOfShapes() {
		return this.antal_shapes;
	}

	public int getNoOfShapesLeft() {
		return antal_shapes_kvar;
	}

	public void pausa() {
		if (!TimerThread.pausat) {
			TimerThread.pausat = true;
		} else {
			TimerThread.pausat = false;
		}
	}
}