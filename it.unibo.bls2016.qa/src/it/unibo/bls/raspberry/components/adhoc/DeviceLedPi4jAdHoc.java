package it.unibo.bls.raspberry.components.adhoc;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import it.unibo.gpio.base.GpioOnPi4j;
import it.unibo.is.interfaces.IOutputEnvView;

/*
 * =======================================================================
 * The led is implemented by using the library pi4j
 * 
 * WARNING : no device model. See it.unibo.bls.raspberry.components
 * =======================================================================
 */
public class DeviceLedPi4jAdHoc  {
protected GpioPinDigitalOutput ledpi4j; 
protected IOutputEnvView outEnvView;
protected boolean ledOn = false;
 	public DeviceLedPi4jAdHoc( IOutputEnvView outEnvView, int pinNum ) throws Exception{
		this.outEnvView = outEnvView;
  		myconfigure(pinNum);
 	}
	protected void myconfigure(int ledPinNum) throws Exception{
		/*
		 * To access a GPIO pin with Pi4J, we must first provision the pin. 
		 * Provisioning configures the pin based on how we intend to use it. 
		 * Provisioning can automatically export the pin, set its direction, 
		 * and setup any edge detection for interrupt based events.
		 */
//		ledpi4j = GpioOnPi4j.controller.provisionDigitalOutputPin( GpioOnPi4j.getPin(ledPinNum) );		
		ledpi4j = GpioFactory.getInstance().provisionDigitalOutputPin( GpioOnPi4j.getPin(ledPinNum) );
	}
 	public void turnOn() {
		ledpi4j.high();
		ledOn = true;
 	}
 	public void turnOff() {
 		if(ledpi4j!=null) ledpi4j.setState(PinState.LOW);
 		ledOn = false;
 	}	
 	public boolean isOn(){
 		return ledOn;
 	}
	public void ledSwitch(){
 		if(  isOn() ) turnOff();
		else turnOn();
	}
}