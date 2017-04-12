package it.unibo.bls.raspberry.components;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import it.unibo.buttonLed.components.DeviceButtonImpl;
import it.unibo.gpio.base.GpioOnSys;
import it.unibo.gpio.base.IGpioConfig;
import it.unibo.is.interfaces.IOutputView;

public class DeviceButtonGpioPolling extends DeviceButtonImpl {
public static int maxSim = 10;
protected Vector<String> gpioLikeValues = new Vector<String>();
protected int head = 0;
protected String lastVal = "0";
protected GpioOnSys gpio ;
protected FileWriter fwrLed;
protected FileWriter fwrBuzzer;

	public DeviceButtonGpioPolling(String name,  IOutputView outView , int pinNum) {
		super(name,outView);
		System.out.println("DevButtonGpioPolling CREATED " );
		gpio = new GpioOnSys();
		try {
			configureGpio(  ""+pinNum );
		} catch (IOException e) {
 			e.printStackTrace();
		}
 	}	
	protected void configureGpio(String pinNum) throws IOException{
		gpio.prepareGpio( pinNum );
		gpio.openInputDirection(pinNum);		
		new DevButtonGpioPollingControl().start();
	}
	@Override
	public int getInput()  {
		String inps;
		try {
			inps = gpio.readGPio( IGpioConfig.gpioInButton );
			if( inps.equals("1")) return 1;
			else return 0;
		} catch (Exception e) {
 			e.printStackTrace();
 			return 0;
		}
	}	
 	protected void emit(String msg){
		System.out.println("DevButtonGpioPolling emit -> " + msg  );
		super.notifyTheObservers(msg);
	}	
	protected class DevButtonGpioPollingControl extends Thread{
		public void run(){
			try {
				for( int i = 1; i<=100; i++) {
					String inps = gpio.readGPio( IGpioConfig.gpioInButton );
					System.out.println("DevButtonGpioPollingControl -> " + inps + "/" + i);
					emit(""+inps.equals("1"));
					java.lang.Thread.sleep(200);
				}
				emit( "0" );
			} catch (Exception e) {
 				e.printStackTrace();
			}
		}
	}
 }