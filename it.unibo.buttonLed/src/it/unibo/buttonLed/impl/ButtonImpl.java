package it.unibo.buttonLed.impl;

import it.unibo.buttonLed.interfaces.IButton;
import it.unibo.buttonLed.interfaces.IButtonListener;

public class ButtonImpl implements IButton{
	
	private IButtonListener listener;
	
	public ButtonImpl(IButtonListener listener){
		this.listener = listener;
	}
	
	@Override
	public void pressed(){
		listener.onButtonPressed();
	}
	
}
