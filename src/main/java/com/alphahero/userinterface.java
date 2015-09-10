package com.alphahero;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;


public class userinterface
{
  HighScore hs = new HighScore();
  InputStream is = System.in; // Beh�vs f�r att l�sa av det man skriver med tangentbordet
  InputStreamReader isr = new InputStreamReader(is); // -||-
  BufferedReader myIn = new BufferedReader(isr); // -||-
  Scanner scan = new Scanner(System.in); // -||-
  private static String filename="highscorelist.txt"; // s� att man anv�nder samma namn p� filen f�r b�ckerna
  public userinterface()
  {
    try
    {
      hs.loadFile(filename); // l�ser av fr�n filen
    }
    catch(FileNotFoundException fe)
    {
      System.out.println("File not found with the name " +filename); // Om filen inte finns visas denna text
    } catch (ClassNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
  }
  
  public void addScore(int scoren) // l�gger till en bok i biblioteket
  {
    int check=0;
    while(check==0)
    {
      String name = JOptionPane.showInputDialog(null, "Namn: ", "New Highscore",
          JOptionPane.PLAIN_MESSAGE);
      if(name != null)
      {
        Player player = new Player(name, scoren); // Skapar en ny highscore
        hs.addHighScore(player); // tar bort boken fr�n biblioteket
        check=1;
        closeFile();
      }
      else
        JOptionPane.showMessageDialog(null, "Wrong input data!");
    }
  }
  public void removeScore()
  {
    hs.removeHighScore(4); // tar bort boken fr�n biblioteket
  }

  public String listBooks()
  {
    String temp;  
    temp = hs.toString();
    return temp;
  }
  public void closeFile()
  {
    try
    {
      hs.saveFile(filename); // skriver �ver filen / sparar den nya
      System.out.println("kghjggjhgjhgh");
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
