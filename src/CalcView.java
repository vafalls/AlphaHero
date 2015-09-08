// structure/calc-mvc/CalcView.java - View component
//    Presentation only.  No user actions.
// Fred Swartz -- December 2004

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.IllegalFormatException;

class CalcView extends JPanel implements KeyListener
{   
    //... Components
	JPanel content;
	private JLabel pointsLabel;
	private JFormattedTextField pointsField;
	private NumberFormat pointsFormat;
	
	//... MVC
	private CalcController controller;
    private CalcModel m_model;
    
    //... Bilden
    private Image image;

    //================================================================ constructor
    CalcView(CalcModel model)
    {
    	//... Initiation
        this.m_model = model;
        
        //... TextField
        pointsField = new JFormattedTextField(pointsFormat);
        pointsField.setColumns(4);

        
        //... Keylistener
        this.content = new JPanel();
        this.content.setFocusable(true);
        this.content.addKeyListener(this);
        this.content.add(pointsField);
        
        //... Bakgrundsbilden
        try{image = ImageIO.read(getClass().getResource("Untitled-4.jpg"));}
        catch(IOException ex){}

        //... Avslut
        this.add(content);
    }
    //================================================================= paint
    public void paintComponent(Graphics g)//ritar komponenterna
	{
		super.paintComponents(g);
		g.drawImage(image, 0, 0, null);
		m_model.paint(g);
		
	}
    //================================================================= setValues
    public void setPointsField(int nypoang)
    {
    	this.pointsField.setValue(nypoang);
    }
    //================================================================= getValues
    public JPanel getJPanel(){
    	return this.content;
    }
    //================================================================= Key Events
    @Override
	public void keyPressed(KeyEvent e)
    {
    	switch(e.getKeyChar())
    	{
    	case 'a': System.out.println("a");m_model.checkHit('a');break;
    	case 'b': System.out.println("b");m_model.checkHit('b');break;
    	case 'c': System.out.println("c");m_model.checkHit('c');break;
    	case 'd': System.out.println("d");m_model.checkHit('d');break;
    	case 'e': System.out.println("e");m_model.checkHit('e');break;
    	case 'f': System.out.println("f");m_model.checkHit('f');break;
    	case 'g': System.out.println("g");m_model.checkHit('g');break;
    	case 'h': System.out.println("h");m_model.checkHit('h');break;
    	case 'i': System.out.println("i");m_model.checkHit('i');break;
    	case 'j': System.out.println("j");m_model.checkHit('j');break;
    	case 'k': System.out.println("k");m_model.checkHit('k');break;
    	case 'l': System.out.println("l");m_model.checkHit('l');break;
    	case 'm': System.out.println("m");m_model.checkHit('m');break;
    	case 'n': System.out.println("n");m_model.checkHit('n');break;
    	case 'o': System.out.println("o");m_model.checkHit('o');break;
    	case 'p': System.out.println("p");m_model.checkHit('p');break;
    	case 'q': System.out.println("q");m_model.checkHit('q');break;
    	case 'r': System.out.println("r");m_model.checkHit('r');break;
    	case 's': System.out.println("s");m_model.checkHit('s');break;
    	case 't': System.out.println("t");m_model.checkHit('t');break;
    	case 'u': System.out.println("u");m_model.checkHit('u');break;
    	case 'v': System.out.println("v");m_model.checkHit('v');break;
    	case 'w': System.out.println("w");m_model.checkHit('w');break;
    	case 'x': System.out.println("x");m_model.checkHit('x');break;
    	case 'y': System.out.println("y");m_model.checkHit('y');break;
    	case 'z': System.out.println("z");m_model.checkHit('z');break;
    	case '': controller.pauseOrResumeGame();break;
    	default: System.out.println("character: " + e.getKeyChar());break;
    	}
	}
    @Override
	public void keyReleased(KeyEvent e){
		//Do nothing
	}
    @Override
	public void keyTyped(KeyEvent e){
		//Do nothing
	}
    public void sendCalcController(CalcController asd)
    {
    	this.controller = asd;
    }
}