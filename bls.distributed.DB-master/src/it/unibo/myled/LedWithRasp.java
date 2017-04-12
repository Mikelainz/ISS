package it.unibo.myled;



import com.pi4j.io.gpio.GpioPinDigitalOutput;





public class LedWithRasp {

	private boolean isOn;
	GpioPinDigitalOutput ledpi4j;
	
	public LedWithRasp(int pinNum){
		this.ledpi4j = GpioOnPi4j.controller.provisionDigitalOutputPin( GpioOnPi4j.getPin(pinNum) );
		this.turnOff();		
	}
	
	public void turnOn(){
		ledpi4j.high();
 		isOn = true;
	}
 	public void turnOff() {
 		if(ledpi4j!=null) ledpi4j.low();
 		isOn = false;
	}
 	public void ledSwitch() {
 		if( isOn ) turnOff();
 		else turnOn();
	}
 	public boolean isOn(){
 		return isOn;
 	}
	
}
