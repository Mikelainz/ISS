package it.unibo.platform.bth.base;

 
import it.unibo.is.interfaces.protocols.IConnInteraction;
import it.unibo.platform.bth.BthSupport;
import it.unibo.platform.bth.IBthConnection;

import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.StreamConnection;

public class ClientBth extends Thread{
	private BthSupport bthSupport;
	private IConnInteraction bthconn;
	private StreamConnection conn;
	private String name;
	private InputStream dis;
	private OutputStream dos;
	private String receivedMsg="";
	
	public ClientBth(String name){
		this.name = name;
 		bthSupport = new BthSupport("",false);				
	}
	
	public void run(){
 		try{
 			for( int i=1; i<=3; i++){
	 			println("started " + i);
	 			bthconn = bthSupport.connectAsClient("unibobth");  
//				kernel = new BthConnSupport( "",conn );
				send();
	//			conn.close();											
		 		println("ends");
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized String getReceivedEchoMsg(){
		return receivedMsg;
	}
	
	protected void send(){
		try {				
	 		System.out.println(" client sending ... " + bthconn);
//			while( !receivedMsg.equals("exit") ){					
				bthconn.sendALine( "init" );
				receivedMsg=bthconn.receiveALine( );
				println("client received: " + receivedMsg);
				bthconn.sendALine( "message1");
				receivedMsg=bthconn.receiveALine( );
				println("client received: " + receivedMsg);
				bthconn.sendALine( "message2");
				receivedMsg=bthconn.receiveALine( );
				println("client received: " + receivedMsg);
//				kernel.sendALine( "exit");
//				receivedMsg=kernel.receiveALine( );
//				println("client received: " + receivedMsg);
//			}								
		} catch (Exception e) {
			println("error " + e.getMessage());;
		}			
	}

	protected void println(String msg){
		System.out.println(" *** "+name+" "+msg);
	}

	public static void main(String[] atgs){
		new ClientBth("client").start();		
	}	
}
