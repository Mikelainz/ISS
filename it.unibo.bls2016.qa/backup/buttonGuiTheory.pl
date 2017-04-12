/*
===============================================================
buttonGuiTheory.pl
Defines the rules to create and use a GUI-based virtual Button
===============================================================
*/

createButton( Name, Event, EventMsg ) :-  
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
  	actorPrintln( createButton( Name,Actor, Event,EventMsg  ) ),
	class("it.unibo.devices.qa.DeviceButtonFactoryQa") <- 
			createButtonGui( Name, OutView , Actor, Event,EventMsg )  returns Button.
	