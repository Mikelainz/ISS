/*
===============================================================
ledMockTheory.pl
Defines the rules to create a mock for the Led
===============================================================
*/

createLed(Name,Color) :- 
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createPojoMockLed( Name, Color) ),
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- createLedMock( Name, OutView, Color )  returns LED.
/* -------------------------------------------------------------------------------
   WARNING: assert( led(LED) ) cannot be  used to store a reference to the LED
   We have to recur to the DeviceLedFactoryiQa.getTheLed operation
  -------------------------------------------------------------------------------
*/