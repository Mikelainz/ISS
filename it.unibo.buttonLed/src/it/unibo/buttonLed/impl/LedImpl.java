package it.unibo.buttonLed.impl;

import it.unibo.buttonLed.interfaces.ILed;

public class LedImpl implements ILed {

	
	private boolean state;
	
	
	//constructor
	public LedImpl(){
		state = false;
	}
	
	public void turnOn(){
		state = true;
	}
	public void turnOff(){
		state = true;
	}
	public boolean isOn(){
		return state;
	}
	
	
}
