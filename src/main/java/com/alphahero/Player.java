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
    String utskrift; // Två temporärsträngar görs
    utskrift = "Name: "+ this.name + "\n    Score: " +this.score+ "\n\n"; 
    return utskrift; // Lägger in allt i en array som sedan returneras
  }
	
	public int compareTo(Player player2)
  {
    Integer a,b;
    a=(Integer)score;
    b=(Integer)player2.score;
	  Integer res = a.compareTo(b); // Jämför böckerna som ligger i bokregistret
    return -res; // Behövs för att sorteringen ska fungera
  }
	private static final long serialVersionUID = 1L;
}
