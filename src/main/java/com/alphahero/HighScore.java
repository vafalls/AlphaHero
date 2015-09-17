package com.alphahero;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class HighScore implements Serializable {

	private ArrayList<Player> highScore = new ArrayList<Player>();

	public void saveFile(String filename) throws IOException {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(highScore);
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void loadFile(String filename) throws IOException,

	ClassNotFoundException {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new FileInputStream(filename));
			highScore = (ArrayList<Player>) in.readObject();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			saveFile(filename);
		} catch (EOFException fe) {
			System.out.println("Empty List");
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addHighScore(Player player) {
		highScore.add(player);
	}

	public void removeHighScore(int sistaPaListan) {
		Collections.sort(highScore);
		for (int k = sistaPaListan; k <= highScore.size(); k++) {
			highScore.remove(highScore.size() - 1);
		}
	}

	public String toString() {
		String temp = new String();
		int k = 1;
		Collections.sort(highScore);
		for (Player a : highScore) {
			temp += k + ". " + a.toString();
			k++;
		}
		return temp;
	}
}
