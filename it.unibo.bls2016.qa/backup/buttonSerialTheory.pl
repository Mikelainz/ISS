/*
===============================================================
buttonSerialTheory.pl
Defines the rules to create and use a serial-proxy  Button
===============================================================
*/
portName( "COM5" ).

createButton( Name, Event, EventMsg ) :-  
 	actorobj( Actor ),
 	portName( Port ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createButtonSerialProxy( Name,Actor  ) ),
	class("it.unibo.devices.qa.DeviceButtonFactoryQa") <- 
			createButtonSerialProxy( Name, OutView ,Port, Actor, Event,EventMsg )  returns Button.
	