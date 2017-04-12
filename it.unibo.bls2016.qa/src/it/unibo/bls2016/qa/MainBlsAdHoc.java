package it.unibo.bls2016.qa;
import java.util.Observable;
import java.util.Observer;
import it.unibo.bls.raspberry.components.adhoc.DeviceButtonPi4JAdHoc;
import it.unibo.bls.raspberry.components.adhoc.DeviceLedPi4jAdHoc;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.system.SituatedSysKb;

public class MainBlsAdHoc {
private IOutputEnvView outEnvView  = SituatedSysKb.standardOutEnvView ;

	public MainBlsAdHoc(){
		try {
			configureTheSystem();
 		} catch (Exception e) {
 			e.printStackTrace();
		}
	}
	public void configureTheSystem() throws Exception{
			DeviceButtonPi4JAdHoc button = new DeviceButtonPi4JAdHoc( outEnvView,  24 );
			DeviceLedPi4jAdHoc led       = new DeviceLedPi4jAdHoc( outEnvView,  25 );
			Control control              = new Control( outEnvView,led );
			button.addObserver(control);
			outEnvView.addOutput("================================================================");
			outEnvView.addOutput("ButtonLed on Raspberry in adhoc mode (library Pi4j)");
			outEnvView.addOutput("Ending within 60 secs .... ");
			outEnvView.addOutput("================================================================");		
			Thread.sleep(60000);
	}
 	/*
	 * --------------------------------------
	 * Main (rapid check)
	 * --------------------------------------
	 */
	public static void main(String args[]) throws Exception {
		new MainBlsAdHoc();
 	}
}

/*
 * ----------------------------------------------------------------
 * Control (to avoid any change in the DeviceButtonPi4J)
 * ----------------------------------------------------------------
 */
	 class Control implements Observer{
	 private DeviceLedPi4jAdHoc led;
	 private IOutputEnvView outEnvView;
		 public Control(IOutputEnvView outEnvView,DeviceLedPi4jAdHoc led){
			 this.outEnvView = outEnvView;
			 this.led = led;
			 outEnvView.addOutput("Control CREATED "  );
		 }
		@Override
		public void update(Observable obj, Object arg) {
			outEnvView.addOutput("Control " + arg );
 			led.ledSwitch();
		}		 
	 }
