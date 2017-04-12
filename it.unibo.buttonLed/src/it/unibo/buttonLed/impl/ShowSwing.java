package it.unibo.buttonLed.impl;

import java.awt.Color;

import javax.swing.JComponent;

import it.unibo.buttonLed.interfaces.IShow;

public class ShowSwing implements IShow {
	
	/*
	 * Questo e' solo un componente swing da
	 * colorare che svolge la funzione di led
	 */

	private JComponent led;
	
	public ShowSwing(JComponent led){
		this.led = led;
	}
	
	public void print(boolean on) {
		if(on) led.setBackground(Color.RED);
		else led.setBackground(null);
	}

}
