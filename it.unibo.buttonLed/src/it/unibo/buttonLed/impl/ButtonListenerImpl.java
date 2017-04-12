package it.unibo.buttonLed.impl;

import it.unibo.buttonLed.interfaces.IButtonListener;
import it.unibo.buttonLed.interfaces.ILed;
import it.unibo.buttonLed.interfaces.IShow;

public class ButtonListenerImpl implements IButtonListener { //questo risulta essere l'elaboratore effettivo

	private ILed led;
	private IShow show;
	
	public ButtonListenerImpl(ILed led, IShow show){
		this.led = led;
		this.show = show;
	}
	
	
	public void onButtonPressed(){
		if(led.isOn()) led.turnOff();
		else led.turnOn();
		show.print(led.isOn());
	}
	
}
