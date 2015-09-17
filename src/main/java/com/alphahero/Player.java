package com.alphahero;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Comparable<Player>, Serializable {

	private String name;
	private int score;

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.score;
	}

	public String toString() {
		String utskrift;
		utskrift = "Name: " + this.name + "\n    Score: " + this.score + "\n\n";
		return utskrift;
	}

	public int compareTo(Player player2) {
		Integer a, b;
		a = (Integer) score;
		b = (Integer) player2.score;
		Integer res = a.compareTo(b);
		return -res;
	}
}
