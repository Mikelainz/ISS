package it.unibo.buttonLed.impl;

import it.unibo.buttonLed.interfaces.IShow;

public class ShowConsole implements IShow {

	public void print(boolean on){
		System.out.println("Led is "+(on?"ON":"OFF"));
	}
	
}
