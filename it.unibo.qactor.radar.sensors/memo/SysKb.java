package it.unibo.qastepper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SysKb {
 	public static final int winWith=700;
	public static final int portNum=8037;
	public static final String host="192.168.0.110";//192.168.43.229  // 
	public static final int radarRange = 80000; //80000;
	
	public static final String sensorMsg ="sensorMsg";
	public static final String usonarEvent ="usonar";
	public static final String usonarMsg ="distance";
	public static final String intruderEvent ="intruder";
	public static final String intruderMsg ="interval";

	//sensorMsg( usonarEvent, usonarMsg, v )
	public static final int distanceMin = 100;
	public static final int intruderDistance = 30;  //MUST BE > 26

 	public static final String configFile = "sysconfig.pl";
 	public static InputStream configInputStream = null;
 	
 	public static void setConfigFile() throws FileNotFoundException{
 		configInputStream = new FileInputStream(configFile);
 	}
 	
 	public final static String node1= "1"; 
 	public final static String node2= "2"; 
 	public final static String node3= "3"; 

}
