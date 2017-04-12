/*
===============================================================
ledPi4jTheory.pl
Defines the rules to create a Led on Raspberry  
===============================================================
*/
pinledwpi( 25 ).

createLed(Name,Color) :- 
	pinledwpi(Pin),
	createPi4jLed( Name,Color,Pin ).

createPi4jLed(  Name,Color,PinNum )  :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createPi4jLed( Name, Color,PinNum) ),
	class("it.unibo.devices.qa.DeviceLedFactoryQa") <- createLedPi4j( Name, OutView, Color, PinNum ).
