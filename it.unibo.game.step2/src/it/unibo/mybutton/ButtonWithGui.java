package it.unibo.mybutton;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * ----------------------------------------------------------------
 * GOAL: an ActionListener that keeps track of the last event
 * ----------------------------------------------------------------
 */
public class ButtonWithGui extends Button implements ActionListener, IButton {
	
	//ButtonWithGui extends Button cuz we need the graphic representation of our item
	
	private static final long serialVersionUID = 1L;
	private Mybutton myButton = null;
	private String command;
	private int pinNum; //still not used
	
	public ButtonWithGui(Mybutton button, String command, int pinNum){
		super(command);
		this.command = command;
		this.myButton = button;
		this.pinNum = pinNum;
		this.addActionListener(this);
	}
 	
	public void pressed(){
		myButton.emit("buttonEvent","buttonEvent(" + this.command + ")");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.pressed();
    }
	
	
	
 }