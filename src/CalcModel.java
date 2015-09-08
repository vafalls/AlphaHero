// structure/calc-mvc/CalcModel.java
// Fred Swartz - December 2004
// Model
//     This model is completely independent of the user interface.
//     It could as easily be used by a command line or web interface.

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

enum letter{A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z};


public class CalcModel
{
  /** Constants */
	private int panel_width = 1300;
	private int panel_height = 440;
	private int pad_x_value = 48;
	private int antal_shapes = 1;
	private int poangrakning = 0;
	
	/** Squares */
	ArrayList<Rect> shapes = new ArrayList<Rect>();
	private checkRect pads[] = new checkRect[2];
	
	//... Other
	private letter bokstav_;
	Random slump = new Random();
	private CalcController controller;

    /** Constructor */
    CalcModel()
    {
    	pads[0]= new checkRect(pad_x_value,68,Color.black,104,104);
    	pads[1]= new checkRect(pad_x_value,268,Color.black,104,104);
    }
    
    /** Paint */
    public void paint(Graphics g)
    {
    	//... Checkrect pads
    	pads[0].paint(g);
    	pads[1].paint(g);
    	
    	//... Rect shapes
    	if(shapes.isEmpty()==false)
    	{
	    	for(int a=0; a<shapes.size(); a++)
	    	{
	    		shapes.get(a).paint(g);
	    	}
    	}
    }

    /** Move */
    public void move()
    {
    	for(int a=0; a<shapes.size(); a++)
    	{
    		shapes.get(a).move();
    	}
    }
    
    /** Add a new shape to the ArrayList  */
    public void addShapeToArraylist(boolean pausat)
    {
    	//... initierar temporara variabler
    	int startposY;
    	Rect temp;
    	
    	//slumpar fram vilken rad
    	startposY = slump.nextInt(2);
    	if(startposY==0){startposY=68;}
    	else{startposY=268;}
    	if(!pausat)
    	{
	    	//skapar den nya recten
	    	temp = new Rect(1366, startposY, Color.white,100,100, this.getRandomLetter());
	    	temp.setVelocity(-4, 0);
	    	
	    	this.shapes.add(temp);
    	}
    }
    /** Delete shape when the shape has reached the end*/
    public void checkShapeDead()
    {
    	for(int a=0; a<shapes.size(); a++)
    	{
	    	try
	    	{
		    	if(this.shapes.get(a).getX()<-204)
		    	{
		    		if(shapes.get(a).getAlive()==false)
		    		{
		    			if(poangrakning>=5)
		    			{
		    				poangrakning -= 5;
		    			}
		    		}
		    		else
		    		{
		    			poangrakning +=10;
		    		}
		    		shapes.remove(a);
		    		
		    		//Spelet slut
		    		if(shapes.isEmpty())
		    		{
		    			System.out.println("spelet avslutat");
		    			this.controller.speletAvslutat();
		    		}
		    	}
		    	else if(this.shapes.get(a).getX()+52<this.pad_x_value)
		    	{
		    		shapes.get(a).setCurrentImage(false);
		    	}
	    	}
	    	catch(IndexOutOfBoundsException a1){}
    	}
    }
    /** Check Hit */
    public void checkHit(char tecken)
    {
    	for(int a=0; a<this.shapes.size(); a++)
    	{
    		//kollar positionerna på shapes och pads
    		if(shapes.get(a).getX()<=this.pad_x_value+80 && shapes.get(a).getX()+52>=this.pad_x_value)
    		{
    			if(tecken==shapes.get(a).getLetter())
    			{
    				shapes.get(a).setCurrentImage(true);
    				shapes.get(a).setAlive();
    			}
    			else
    			{
    				shapes.get(a).setCurrentImage(false);
    			}
    		}
    	}
    }

    /** Get Values */

    public int getPanelWidth(){
        return this.panel_width;
    }
    public int getPanelHeight(){
        return this.panel_height;
    }
    public int getAntalShapes(){
    	return this.antal_shapes;
    }
    public int getArraylistSize(){
    	return this.shapes.size();
    }
    public int getShapePosition(){
    	return shapes.get(0).getX();
    }
    public int getPoangRakning(){
    	return this.poangrakning;
    }
    public void sendCalcController(CalcController asd){
    	this.controller = asd;
    }
    public String getRandomLetter()
    {
    	//A B C D E F G H I J K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
    	//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
    	int random_number;
    	random_number = slump.nextInt(25);
    	switch(random_number)
    	{
    	case 0:return "a";
    	case 1:return "b";
    	case 2:return "c";
    	case 3:return "d";
    	case 4:return "e";
    	case 5:return "f";
    	case 6:return "g";
    	case 7:return "h";
    	case 8:return "i";
    	case 9:return "j";
    	case 10:return "k";
    	case 11:return "l";
    	case 12:return "m";
    	case 13:return "n";
    	case 14:return "o";
    	case 15:return "p";
    	case 16:return "q";
    	case 17:return "r";
    	case 18:return "s";
    	case 19:return "t";
    	case 20:return "u";
    	case 21:return "v";
    	case 22:return "w";
    	case 23:return "x";
    	case 24:return "y";
    	case 25:return "z";
    	default: return "_";
    	}
    }
}