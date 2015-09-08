import java.io.*;
import java.util.*;

public class HighScore implements Serializable
{

  private ArrayList<Player> highScore = new ArrayList<Player>();
  

  public void saveFile(String filename) throws IOException
  {
    // Skapar en ny fil / skriver �ver den befintliga med samma namn
    ObjectOutputStream out = null;

    try
    {
      out = new ObjectOutputStream(new FileOutputStream(filename));
      out.writeObject(highScore);
    } 
    finally
    {
      try
      {
        if (out != null)
          out.close();
      } 
      catch (Exception e)
      { }
    }
  }

  @SuppressWarnings("unchecked")
  public void loadFile(String filename) throws IOException,ClassNotFoundException
  {
    // L�ser fr�n filen med r�tt filnamn
    ObjectInputStream in = null;

    try
    {
      in = new ObjectInputStream(new FileInputStream(filename));
      // readObject returns a reference of type Object, hence the down-cast
      highScore = (ArrayList<Player>) in.readObject();
    } 
    catch (FileNotFoundException fe) // Finns inte filen med det namnet                                 // en ny med det namnet
    {
      System.out.println("File doesn't exist!");
      saveFile(filename);
    } 
    catch (EOFException fe) // Finns inte filen med det namnet                                 // en ny med det namnet
    {
      System.out.println("Empty List");
    }
    catch (InvalidClassException ie)
    {
      
    }
    finally
    {
      try
      {
        if (in != null)
          in.close();
      } catch (Exception e)
      {
      }
    }
  }

  public void addHighScore(Player player) // L�gger till en ny highscore
  {
    highScore.add(player);
  }

  public void removeHighScore(int sistaPaListan)
  {
    Collections.sort(highScore);
    for (int k = sistaPaListan; k <= highScore.size(); k++) // G�r igenom alla efter sista som ska visas i listan
    {
      highScore.remove(highScore.size()-1); // raderar alla highScore efter den sista p� listan
    }
  }

  public String toString() // L�gger in alla b�cker i en str�ng
  {
    String temp = new String();
    int k=1;
    Collections.sort(highScore);
    for(Player a:highScore) // En "for-each loop"
    {
      temp += k+". "+a.toString();
      k++;
    }
    return temp;
  }
}
