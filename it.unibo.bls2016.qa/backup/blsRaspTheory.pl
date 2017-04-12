/*
===============================================================
blsRaspTheory.pl
===============================================================
*/
createPi4jButton(PinNum, EvId, EvMsg)  :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView,	
	class("it.unibo.devices.qa.DeviceButtonPi4jQa") <- createButton( OutView, PinNum, EvId, EvMsg ) returns BUTTON.
 
createPi4jLed( PinNum)  :-
 	actorobj( Actor ),
  	Actor <- getOutputEnvView returns OutView ,	
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- createLed( OutView, PinNum ) returns LED.
/* -------------------------------------------------------------------------------
   WARNING: assert( led(LED) ) cannot be  used to store a reference to the LED
   We have to recur to the DeviceLedGui.getTheLed operation
  -------------------------------------------------------------------------------
*/

/*
---------------------------------
LED switch
---------------------------------
*/
ledState( off ).

ledSwitch  :-
	retract( ledState(off) ), !,	 
 	turnTheLed(on) .
 	
ledSwitch  :-
	retract( ledState(on) ), 	 
 	turnTheLed(off).


turnTheLed( on ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	%% LED <- getName returns LedName,
	%% actorPrintln( turnTheLed(on, LedName, LED) ),
	class("com.pi4j.system.SystemInfo") <- getMemoryFree returns M,
	inc(counter,1,V1),
%%	( V1 == 5, !  , actorPrintln(gc,V1), class("java.lang.System") <-gc; true ),
%%	( V1 == 20, ! , actorPrintln(gc,V1), class("java.lang.System") <-gc; true ),
	actorPrintln( memfree(V1,M,LED) ),
	LED <- turnOn ,
	assert( ledState(on) ).
	
turnTheLed( off ):-
	class("it.unibo.devices.qa.DeviceLedPi4jQa") <- getTheLed  returns LED,
	%% LED <- getName returns LedName,
	%% actorPrintln( turnTheLed(off, LedName, LED) ),
	LED <- turnOff ,
	assert( ledState(off) ).
 
/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initialize  :-   actorPrintln("initializing the blsRaspTheory ..."),
	assign(counter,0).
:- initialization(initialize).