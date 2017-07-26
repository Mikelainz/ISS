package it.unibo.qastepper;
import java.awt.Color;
import java.net.ServerSocket;
import java.net.Socket;
import it.unibo.baseEnv.basicFrame.EnvFrame;
import it.unibo.is.interfaces.protocols.IConnInteraction;
import it.unibo.is.interfaces.protocols.ITcpConnection;
import it.unibo.platform.tcp.SocketTcpConnSupport;
import it.unibo.supports.FactoryProtocol;
import it.unibo.supports.tcp.FactoryTcpProtocol;
import it.unibo.system.SituatedActiveObject;
import it.unibo.is.interfaces.IBasicEnvAwt;
import it.unibo.is.interfaces.IOutputEnvView; 

public class ServerTcpForPython extends SituatedActiveObject {
protected FactoryProtocol factory;
protected ITcpConnection supportTcp;
protected ServerSocket serverSock;
protected int n = 1;
protected boolean stopped = false;
 
//protected final static String[] myEvents = new String[]{SysKb.usonarEvent}; 
//protected final static String[] otherEvents = new String[]{ }; 

/*
 * The server interacts with a client written in python
 * The python client  (usonicSensorS2Client.py) sends a request to store a sensor value
 * The server answers with a goon  / stop message.
 * The stop message is sent when the server has received the number of messages SysKb.nServerIter
 * The server generates an event of name 'sensorMsg' and form  
 * "usonarEvent( usonarMsg, v )" 
 * when the received value is less than SysKb.distanceMin
 * The event is handled by the USonarEventHandler
 */
	public ServerTcpForPython(IOutputEnvView outEnvView ) {
		super(outEnvView, "ServerTcpForPython" );
//		super(outEnvView, SysKb.node1, myEvents, otherEvents );
 	}
	public void setStopped(){
		stopped = true;
	}
	protected IConnInteraction waitForTheConnection( ) throws Exception{	
		//println("	waitForTheConnection on" + this.serverSock );
 		Socket sock = supportTcp.acceptAConnection(serverSock);  
 		IConnInteraction conn = new SocketTcpConnSupport("TcpConnsupport",sock,env);
 		return conn;
 	}
	@Override
	public void startWork() throws Exception {		 
		init();
  	}
	protected void init() throws Exception {
		//SET TIMEOT 10 minuti
		System.setProperty("inputTimeOut","600000");
		FactoryTcpProtocol factory = new FactoryTcpProtocol( outView, "serverTcp");
		supportTcp = factory.createServerSupport( );
 	}
	@Override
	protected void doJob() throws Exception {
		while( true ){
		//Accept a connection	
		println("	ServerTcpForPython ACCEPTS A CONNECTION on " + SysKb.portNum  );
		serverSock = supportTcp.connectAsReceiver(SysKb.portNum);		
		IConnInteraction conn = waitForTheConnection( );
		try{
	 		while( ! stopped ){
		 		String receivedMsg = conn.receiveALine( );
//	   	 		println("	ServerTcpForPython RECEIVED " + n + ":" + receivedMsg);
	   	 		println("	ServerTcpForPython RECEIVED " + receivedMsg);
	 	 		if( receivedMsg.equals("null" )) break;
 		 		n++;
	 	 		//receivedMsg = p(distance, arg)
 		 		/*
	  	 		EventSensorMessage inMsg = new EventSensorMessage(receivedMsg);
	  	 		int d = Integer.parseInt(inMsg.getMsgKey());
	  	 		if( d < SysKb.distanceMin ){ 
	  				println("	ServerTcpForPython RAISE  " +  SysKb.usonarEvent+"::"+inMsg );
	  	 			SysKbInfoReplInfr.getNodejsLike().raiseEvent(null, SysKb.usonarEvent, inMsg.toString() );
		 		}else conn.sendALine( "none\n"   );
		 		*/
			}//while
			println("	ServerTcpForPython SENDING stop "  );
//			conn.sendALine( "stop\n"   );
			stopped = false;
		}catch( Exception e ){
			println("	Exception "  + e.getMessage());
		}
		stopped = false;
 		println("	ServerTcpForPython CONTINUES"  );
		}//while (accept another conn)
	}
	@Override
	public void endWork() throws Exception {		
		 
	}
	
	public static void main(String[] args){
		IBasicEnvAwt env = new EnvFrame("SERVERTcp", Color.yellow,Color.BLUE);
		env.init();
		new ServerTcpForPython(env.getOutputEnvView() ).start();
	}
}
