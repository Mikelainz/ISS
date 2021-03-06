package it.unibo.mybutton;

import java.util.Observable;
import java.util.Observer;

import it.unibo.is.interfaces.IOutputEnvView;

public class ButtonWithRasp implements IButton, Observer{

	//we need to implement observer too cuz we haven't a control logic element in our model	
	
	private DeviceButtonPi4JAdHoc buttonPi4j;
	private int pinNum;
	private String command;
	private Mybutton myButton = null;
	
	public ButtonWithRasp(Mybutton myButton, IOutputEnvView outEnvView, int pinNum, String command){
		this.myButton = myButton;
		this.pinNum = pinNum;
		this.command = command;
		try {
			buttonPi4j = new DeviceButtonPi4JAdHoc(  outEnvView , pinNum);
			buttonPi4j.addObserver(this);
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	
	public void pressed() {
		myButton.emit("buttonEvent","buttonEvent(" + this.command + ")");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.pressed();
	}

}
