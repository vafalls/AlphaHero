package com.alphahero;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

enum letter {
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
};

public class CalcModel {
	private int panel_width = 1300;
	private int panel_height = 440;
	private int pad_x_value = 48;
	private int antal_shapes = 1;
	private int poangrakning = 0;

	ArrayList<Rect> shapes = new ArrayList<Rect>();
	private CheckRect pads[] = new CheckRect[2];

	Random slump = new Random();
	private CalcController controller;

	public CalcModel() {
		pads[0] = new CheckRect(pad_x_value, 68, Color.black, 104, 104);
		pads[1] = new CheckRect(pad_x_value, 268, Color.black, 104, 104);
	}

	public void paint(Graphics g) {
		pads[0].paint(g);
		pads[1].paint(g);

		if (shapes.isEmpty() == false) {
			for (int a = 0; a < shapes.size(); a++) {
				shapes.get(a).paint(g);
			}
		}
	}

	public void move() {
		for (int a = 0; a < shapes.size(); a++) {
			shapes.get(a).move();
		}
	}

	public void addShapeToArraylist(boolean pausat) {
		int startposY;
		Rect temp;

		startposY = slump.nextInt(2);
		if (startposY == 0) {
			startposY = 68;
		} else {
			startposY = 268;
		}
		if (!pausat) {
			temp = new Rect(1366, startposY, Color.white, 100, 100,
					this.getRandomLetter());
			temp.setVelocity(-4, 0);

			this.shapes.add(temp);
		}
	}

	/**
	 * Delete shape when the shape has reached the end
	 */
	public void checkShapeDead() {
		for (int a = 0; a < shapes.size(); a++) {
			try {
				if (this.shapes.get(a).getX() < -204) {
					if (shapes.get(a).getAlive() == false) {
						if (poangrakning >= 5) {
							poangrakning -= 5;
						}
					} else {
						poangrakning += 10;
					}
					shapes.remove(a);

					// GAME OVER!
					if (shapes.isEmpty()) {
						System.out.println("spelet avslutat");
						this.controller.gameIsOver();
					}
				} else if (this.shapes.get(a).getX() + 52 < this.pad_x_value) {
					shapes.get(a).setCurrentImage(false);
				}
			} catch (IndexOutOfBoundsException a1) {
			}
		}
	}

	public void checkHit(char tecken) {
		for (int a = 0; a < this.shapes.size(); a++) {
			// checking positions of pads and shapes
			if (shapes.get(a).getX() <= this.pad_x_value + 80
					&& shapes.get(a).getX() + 52 >= this.pad_x_value) {
				if (tecken == shapes.get(a).getLetter()) {
					shapes.get(a).setCurrentImage(true);
					shapes.get(a).setAlive();
				} else {
					shapes.get(a).setCurrentImage(false);
				}
			}
		}
	}

	public int getPanelWidth() {
		return this.panel_width;
	}

	public int getPanelHeight() {
		return this.panel_height;
	}

	public int getAntalShapes() {
		return this.antal_shapes;
	}

	public int getArraylistSize() {
		return this.shapes.size();
	}

	public int getShapePosition() {
		return shapes.get(0).getX();
	}

	public int getPoangRakning() {
		return this.poangrakning;
	}

	public void sendCalcController(CalcController asd) {
		this.controller = asd;
	}

	public String getRandomLetter() {
		// A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
		int random_number;
		random_number = slump.nextInt(25);
		switch (random_number) {
		case 0:
			return "a";
		case 1:
			return "b";
		case 2:
			return "c";
		case 3:
			return "d";
		case 4:
			return "e";
		case 5:
			return "f";
		case 6:
			return "g";
		case 7:
			return "h";
		case 8:
			return "i";
		case 9:
			return "j";
		case 10:
			return "k";
		case 11:
			return "l";
		case 12:
			return "m";
		case 13:
			return "n";
		case 14:
			return "o";
		case 15:
			return "p";
		case 16:
			return "q";
		case 17:
			return "r";
		case 18:
			return "s";
		case 19:
			return "t";
		case 20:
			return "u";
		case 21:
			return "v";
		case 22:
			return "w";
		case 23:
			return "x";
		case 24:
			return "y";
		case 25:
			return "z";
		default:
			return "_";
		}
	}
}