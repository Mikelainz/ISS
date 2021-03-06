package it.unibo.mybutton;
import it.unibo.gpio.GpioOnPi4j;
import it.unibo.is.interfaces.IOutputEnvView;
import java.util.Observable;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
   
/*
 * =======================================================================
 * The button is implemented as an observable by using the library pi4j
 * 
 * WARNING : no device model. See it.unibo.bls.raspberry.components
 * =======================================================================
 */
public class DeviceButtonPi4JAdHoc  extends Observable {
protected GpioPinDigitalInput device;
protected IOutputEnvView outEnvView;
private String inputStr = null;

	public DeviceButtonPi4JAdHoc( IOutputEnvView outEnvView , int pinNum ) throws Exception{
		this.outEnvView = outEnvView;
		myconfigure(pinNum);
	}
	protected void myconfigure(int pinNum) throws Exception{
		com.pi4j.io.gpio.Pin buttonGpioPinNum = GpioOnPi4j.getPin(pinNum);
		outEnvView.addOutput("DeviceButtonPi4JAdHoc pinNum="  + pinNum + " gpioPinNum=" + buttonGpioPinNum);
		/*
		 * To access a GPIO pin with Pi4J, we must first provision the pin. 
		 * Provisioning configures the pin based on how we intend to use it. 
		 * Provisioning can automatically export the pin, set its direction, 
		 * and setup any edge detection for interrupt based events.
		 * We provision the gpio pin as an input pin with its 
		 * internal pull down resistor enabled
 		 */
		device = GpioOnPi4j.controller.provisionDigitalInputPin(buttonGpioPinNum, PinPullResistance.PULL_DOWN);		
		outEnvView.addOutput("DeviceButtonPi4JAdHoc register Pi4jHandler "  );
 		device.addListener( new Pi4jHandler( ) );				
	}
	/*
	 * ----------------------------------------------------------------
	 * Pi4jHandler class 
	 * ----------------------------------------------------------------
	 */
 	protected class Pi4jHandler implements GpioPinListenerDigital{
  		@Override
		public synchronized void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
  			PinState input = event.getState();	//HIGH or LOW
  			//outEnvView.addOutput("DeviceButtonPi4JAdHoc Pi4jHandler= "  + ""+input );
  			if( input.isLow() ) return;
  			inputStr = input.toString().toLowerCase();
    		try {
  	 			outEnvView.addOutput("DeviceButtonPi4JAdHoc Pi4jHandler= "  + ""+input );
				execAction(inputStr);
			} catch (Exception e) {
 				e.printStackTrace();
			}
  		}	
	}
 	
 	protected synchronized void execAction(String s) throws Exception{
// 		while( inputStr == null ) wait();
// 		inputStr = null;
 		outEnvView.addOutput("DeviceButtonPi4JAdHoc execAction= "  + s );
		this.setChanged();
  		this.notifyObservers(s);  		
 	}
}