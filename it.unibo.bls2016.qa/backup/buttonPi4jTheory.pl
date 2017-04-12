/*
===============================================================
buttonPi4jTheory.pl
Defines the rules to create a Button on Raspberry  
===============================================================
*/
buttonledwpi( 24 ).

createButton( Name, Event, EventMsg ) :- 
	buttonledwpi(PinNum) ,
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createPi4jButton( Name, PinNum) ),
	class("it.unibo.devices.qa.DeviceButtonFactoryQa") <- createButtonPi4j( Name, OutView, PinNum, Actor, Event, EventMsg ).
