/*
===============================================================
blsTheory.pl
===============================================================
*/
welcome :-  actorPrintln("welcome from blsTheory.pl").

/*
---------------------------------
Mode of interaction
---------------------------------
*/
mode(eventbased).
%% mode(msgbased).

 /*
---------------------------------
Condition
---------------------------------
*/
val(clicked).




/*
---------------------------------
Current state of the LED
---------------------------------
*/
ledState( off ).
ledType( gui ).


/*
---------------------------------
LED switch
---------------------------------
*/
ledSwitch(on) :-
	retract( ledState(off) ),!,
	assert( ledState(on) ).
	
ledSwitch(off) :-
	retract( ledState(on) ),!,
	assert( ledState(off) ).

/*
---------------------------------
IMPLEMENTATION
---------------------------------
*/
createPojoLed(LEDTYPE)  :-
	myname( Actor ),
  	Actor <- getOutputEnvView returns OutView,	
	%% actorPrintln( state( Actor, LEDTYPE,OutView ) ),
	class("it.unibo.bls.utils.BlsUtils") <- createTheLed( LEDTYPE, OutView ).

updatePojoLed(V):-
	class("it.unibo.bls.utils.BlsUtils") <- updateTheLed( V ).


createPojoButton(BUTTONTYPE, Port, EvId, EvMsg)  :-
 	myname( Actor ),
  	Actor <- getOutputEnvView returns OutView,	
	%% actorPrintln( state( Actor, BUTTONTYPE, Port, EvId, OutView ) ),
	class("it.unibo.bls.utils.BlsUtils") <- createTheButton( BUTTONTYPE, Port, EvId, EvMsg, OutView ).
	

/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initialize  :-  
	actorPrintln("initializing the blsTheory ...").
 
:- initialization(initialize).