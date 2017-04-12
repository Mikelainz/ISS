/*
===============================================================
ledGuiTheory.pl
Defines the rules to create a serial-proxy Led
===============================================================
*/
portName( "COM5" ).

createLed(Name,Color) :- 
	portName( PORTNAME ),
	createSerialLedProxy( Name, Color, PORTNAME ).

createSerialLedProxy( Name, Color, PORTNAME )  :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createSerialLedProxy( Name, Color, PORTNAME) ),
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- createLedSerialProxy(Name,OutView,Color,PORTNAME) returns LED.
