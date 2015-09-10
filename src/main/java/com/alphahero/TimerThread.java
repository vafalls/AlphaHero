package com.alphahero;
import java.util.Random;
/**
 * 
 * @author Dave2
 * 
 */
public class TimerThread extends Thread
{
	//... modellen
	private static CalcModel m_model;
	
	//... slumpvariabler
	private double waiting_time;
	private Random slump;
	
	//... Constants
	private int antal_shapes;
	private int antal_shapes_kvar;
	private static boolean pausat;
	
    //==================================================================== constructor
	public TimerThread(CalcModel model, int ant_shapes)
	{
		this.antal_shapes = ant_shapes;
		this.antal_shapes_kvar = ant_shapes;
		this.slump = new Random();
		this.m_model = model;
		this.pausat = false;
	}
	
    //==================================================================== Other
	public void run()
	{
		for(int b=0; b<antal_shapes; b++)
		{
			waiting_time = slump.nextDouble()+0.5;
			TimerThread.waiting(waiting_time);
			antal_shapes_kvar--;
		}
	}
	public static void waiting (double n)
	{    
        long t0, t1;
        t0 =  System.currentTimeMillis();
        do
        {
            t1 = System.currentTimeMillis();
        }
        while ((t1 - t0) < (n * 1000));
        
        m_model.addShapeToArraylist(pausat);
        
    }
	
    //================================================================= getValues
	public int getNoOfShapes(){
		return this.antal_shapes;
	}
	public int getNoOfShapesLeft(){
		return antal_shapes_kvar;
	}
	public void pausa()
	{
		if(!this.pausat)
		{
			this.pausat=true;
		}
		else
		{
			this.pausat=false;
		}
	}
}