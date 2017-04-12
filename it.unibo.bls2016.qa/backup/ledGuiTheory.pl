/*
===============================================================
ledGuiTheory.pl
Defines the rules to create a GUI-based virtual Led
===============================================================
*/

createLed(Name,Color) :-  
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createPojoGuiLed( Name, Color) ),
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- createLedGui( Name, OutView, Color )  returns LED.