package com.alphahero;

import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Userinterface {

	HighScore hs = new HighScore();
	InputStream is = System.in;
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader myIn = new BufferedReader(isr);
	Scanner scan = new Scanner(System.in);
	private static String filename = "highscorelist.txt";

	public Userinterface() {
		try {
			hs.loadFile(filename);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found with the name " + filename);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addScore(int scoren) {
		int check = 0;
		while (check == 0) {
			String name = JOptionPane.showInputDialog(null, "Namn: ",
					"New Highscore", JOptionPane.PLAIN_MESSAGE);
			if (name != null) {
				Player player = new Player(name, scoren);
				hs.addHighScore(player);
				check = 1;
				closeFile();
			} else {
				JOptionPane.showMessageDialog(null, "Wrong input data!");
			}
		}
	}

	public void removeScore() {
		hs.removeHighScore(4);
	}

	public String listBooks() {
		return hs.toString();
	}

	public void closeFile() {
		try {
			hs.saveFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
