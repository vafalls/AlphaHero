package com.alphahero;
import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable{

	private String name;
	private int score;

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {return this.name; }
	public int getScore() {return this.score; }
	
	public String toString()
  {
    String utskrift; // Tv� tempor�rstr�ngar g�rs
    utskrift = "Name: "+ this.name + "\n    Score: " +this.score+ "\n\n"; 
    return utskrift; // L�gger in allt i en array som sedan returneras
  }
	
	public int compareTo(Player player2)
  {
    Integer a,b;
    a=(Integer)score;
    b=(Integer)player2.score;
	  Integer res = a.compareTo(b); // J�mf�r b�ckerna som ligger i bokregistret
    return -res; // Beh�vs f�r att sorteringen ska fungera
  }
	private static final long serialVersionUID = 1L;
}
