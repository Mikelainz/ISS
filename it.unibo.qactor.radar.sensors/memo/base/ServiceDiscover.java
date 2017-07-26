package it.unibo.platform.bth.base;

import it.unibo.platform.bth.BthSupport;

/**
 * Populates the service record in BthSupport
 */
public class ServiceDiscover  {
     
    public ServiceDiscover(){
	        new BthSupport("",false).initServiceRecord();
    }    
	public static void main(String[] args)  {
	    new ServiceDiscover();
	} 
 	    
}

