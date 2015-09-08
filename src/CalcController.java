// stucture/calc-mvc/CalcController.java - Controller
//    Handles user interaction with listeners.
//    Calls View and Model as needed.
// Fred Swartz -- December 2004

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CalcController implements ActionListener
{
	//Variables
	private Timer timer;
	
    //... The Controller needs to interact with both the Model and View.
    private CalcModel m_model;
    private CalcView  m_view;
    private userinterface userint;
    
    //... Ny processortråd
    static TimerThread t1;

    //=============================================================== Constructor
    CalcController(CalcModel model, CalcView view)
    {
    	//initiera modellerna
        this.m_model = model;
        this.m_model.sendCalcController(this);
        this.m_view  = view;
        this.m_view.sendCalcController(this);
        this.userint = new userinterface();
        
        //Initiera den andra processortråden
        t1 = new TimerThread(model, 50);
    }
    //=============================================================== Starta spelet
    public void startAnimation()
    {
    	// Create, and start, the timer-object responsible for the animation
    	// Signal every 10 milliseconds (actionPerformed is called)
    	timer = new Timer(10, this);
    	
    	//Starta processortrådarna
    	timer.start();
    	t1.start();
    }
    //=============================================================== Others
    public void pauseOrResumeGame()
    {
    	if(this.timer.isRunning())
    	{
    		this.timer.stop();
    		this.t1.pausa();
    	}
    	else
    	{
    		this.timer.start();
    		this.t1.pausa();
    	}
    }
	public void speletAvslutat()
	{
		int val;
		val = JOptionPane.showConfirmDialog(null, "Game Over!\nVill du spara din Highscore? ");
		switch(val)
		{
		case -1:
			System.exit(0);
			break;
		case 0:
			userint.addScore(m_model.getPoangRakning());
			userint.removeScore();
			userint.closeFile();
			HighScoreView hs = new HighScoreView();
			break;
		case 1:
			System.exit(0);
			break;
		case 2:
			break;
		}
		//-1 = krysset
		//0  = ja
		//1  = nej
		//2  = avbryt
	}
    //=============================================================== Aaaaaaand Action!
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	//... Move
		this.m_model.move();
		
		//... Rita ut
		this.m_view.repaint();
		
		//... Kolla om shapsen är döda
		m_model.checkShapeDead();
		
		//... Poängräkning
		m_view.setPointsField(m_model.getPoangRakning());
	}
}