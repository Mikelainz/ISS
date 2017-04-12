package it.unibo.myled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
 

/*
 * A Led that USES a GUI Panel into a given a Frame
 */
public class LedWithGui extends Panel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private final Dimension sizeOn  = new Dimension(20,20);
private final Dimension sizeOff = new Dimension(5,5);
private boolean isOn = false; 
	public LedWithGui( ) {
		turnOff();
	}		    
 	public void turnOn(){
		setBackground(Color.green);
 		setSize( sizeOn );
 		isOn = true;
		validate();
	}
 	public void turnOff() {
		setBackground(Color.red);
		setSize( sizeOff );
 		isOn = false;
		validate();
	}
 	public void ledSwitch() {
 		if( isOn ) turnOff();
 		else turnOn();
	}
 	public boolean isOn(){
 		return isOn;
 	}
}
