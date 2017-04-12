/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.controloop;
import java.awt.Button;
import java.util.Observable;
import it.unibo.bls.raspberry.components.adhoc.DeviceButtonPi4JAdHoc;
import it.unibo.bls.raspberry.components.adhoc.DeviceLedPi4jAdHoc;
import it.unibo.is.interfaces.IObserver;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Controloop extends AbstractControloop implements IObserver{ 
private DeviceLedPi4jAdHoc    ledPi4j ;

private LedWithGui    ledGui ;
private ButtonListener btnListener ;  
private Button btnGui ;

private boolean withGui = false ;

	public Controloop(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	/*
	 * -----------------------------------------------------
	 * GUI	
	 * -----------------------------------------------------
	 */
	public void createGuiLed(int pinNum ){
		withGui = true;
		ledGui = new LedWithGui(  );		
		outEnvView.getEnv().addPanel(ledGui);
	}
	public void createGuiButton(int pinNum ){
		btnGui      = new Button("CLICK");
		btnListener = new ButtonListener(this);
		btnGui.addActionListener( btnListener );
		outEnvView.getEnv().addPanel(btnGui);
	}
	//Utility for testing
	public ButtonListener testing_getButtonListener(){
		while( btnListener == null ){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
 				e.printStackTrace();
			}
		}
		return btnListener;
	}
	public Button testing_getButton(){
		return btnGui;
	}
	public LedWithGui testing_getLed(){
		return ledGui;
	}
	/*
	 * -----------------------------------------------------
	 * Pi4j	
	 * -----------------------------------------------------
	 */
	public void createPi4jLed(int pinNum ){
		try {
			ledPi4j = new DeviceLedPi4jAdHoc(  outEnvView , pinNum);
		}catch (Exception e) {
			println("ERROR " + e.getMessage() );
		}
	}
	
	public void createPi4jButton(int pinNum){
		try {
			DeviceButtonPi4JAdHoc buttonPi4j  = new DeviceButtonPi4JAdHoc(  outEnvView , pinNum);
			buttonPi4j.addObserver(this);
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	@Override
	public void update(Observable obj, Object arg) {
 		println("Controloop update " + arg + " from " + obj);
 		controlLogic("");
	}
	
	public void controlLogic(String cmd){
		if( withGui ) ledGui.ledSwitch();	
		else ledPi4j.ledSwitch();		
	}
	
}