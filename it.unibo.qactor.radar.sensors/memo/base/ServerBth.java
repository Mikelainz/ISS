package it.unibo.platform.bth.base;
 
import it.unibo.is.interfaces.protocols.IConnInteraction;
import it.unibo.platform.bth.BthService;
import it.unibo.platform.bth.BthSupport;

import javax.microedition.io.StreamConnectionNotifier;

public class ServerBth extends Thread{
	private BthSupport bthSupport;
	private IConnInteraction bthConn;
	private String receivedMsg="";
	private String name;
 	
		public ServerBth(String name){
			this.name = name;
//			kernel = CommunicationFactory.createBth();			
			bthSupport = new BthSupport("",true);				
		}
		
		public void run(){
 			try{
 				while(true){
	 		 		println("ServerBth ACCEPT A COONECTION");
	// 				IConnInteraction conn = bthSupport.startService("unibobth");
					StreamConnectionNotifier serverConn = bthSupport.connectAsReceiver("unibobth"); //by AN2016 btspp://localhost:8848;name=SPPserver1
 		 			IConnInteraction bthConn = bthSupport.setAConnection(serverConn);
	 				new BthService(bthConn);
	//				for( int i=1; i<=2; i++ ){
	// 					receive();
	// 					receivedMsg = "";
	//// 					println("ends");
	//// 					kernel.closeConnection();	
	// 				}
 				}//while
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		public synchronized String getReceivedMsg(){
			return receivedMsg;
		}
		
		protected void receive(){
			try {				
				while( !receivedMsg.equals("exit") ){					
					receivedMsg=bthConn.receiveALine( );
					println("server received " + receivedMsg);
					bthConn.sendALine( receivedMsg);
				}								
			} catch (Exception e) {
				println("errot " + e.getMessage());;
			}			
		}
		
		protected void println(String msg){
			System.out.println(" *** "+name+" "+msg);
		}

		
		public static void main(String[] atgs){
			new ServerBth("server").start();		
		}
}
