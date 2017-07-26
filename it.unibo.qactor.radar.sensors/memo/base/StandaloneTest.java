package it.unibo.platform.bth.base;

import javax.bluetooth.BluetoothStateException;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;

/**
 * This class provides a stand-alone test for Blue Cove
 * 
 */
public class StandaloneTest implements DiscoveryListener{
    public RemoteDevice e;
    public LocalDevice l;
    
    public StandaloneTest(){
	    try {
	        l = LocalDevice.getLocalDevice();
	    } catch(BluetoothStateException e) {
	        System.err.println("Cannot get local device: " + e);
	        return;
	    }
	    
	    System.out.println("Local btaddr is " + l.getBluetoothAddress());
	    System.out.println("Local name is " + l.getFriendlyName());
	    try{
	    	l.getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC,this);
	    	Thread.sleep(600000);
	    }catch(Exception e){
	    	System.out.println(e.getMessage());
	    }
	   
	}
    
	public static void main(String[] args)  {
	    new StandaloneTest();
	} 
	
    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
         e=btDevice;
        try{
        System.out.println("Found ---> name:  -- address: " + btDevice.getBluetoothAddress() + " -- cod: " + cod);
        }catch(Exception e){}
    }

    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
    }

    public void serviceSearchCompleted(int transID, int respCode) {
    }

    public void inquiryCompleted(int discType) {     
    }
	    
}

