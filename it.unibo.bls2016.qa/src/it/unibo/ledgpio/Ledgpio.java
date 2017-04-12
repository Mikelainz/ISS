/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.ledgpio;
 
import it.unibo.bls.highLevel.interfaces.IDevLed.LedColor;
import it.unibo.bls.raspberry.components.DeviceLedPi4j;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Ledgpio extends AbstractLedgpio { 
	protected DeviceLedPi4j ledpi4j; 
	
	public Ledgpio(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	public void createPi4jLed(int pinNum ){
		try {
			println("Led createPi4jLed STARTS "   + pinNum   );
			ledpi4j = new DeviceLedPi4j( "led", outEnvView,  LedColor.GREEN, pinNum );
			ledpi4j.turnOn();
			Thread.sleep(500);
			ledpi4j.turnOff();
			Thread.sleep(500);
			ledpi4j.turnOn();
			Thread.sleep(500);
			ledpi4j.turnOff();
			println("Led createPi4jLed ENDS "   );
		} catch (Exception e) {
			println("ERROR " + e.getMessage() );
		}
	}
	public void ledOff(){
		if( ledpi4j != null ) ledpi4j.turnOff();
	}
	public void ledSwitch(){
		println("Led ledSwitch  "   + ledpi4j   );
		if( ledpi4j == null ) return;
		if( ledpi4j.isOn() ) ledpi4j.turnOff();
		else ledpi4j.turnOn();
		println("led ison=" + ledpi4j.isOn() );
	}
	
}
