/*
===============================================================
ledNoImplTheory.pl
Defines the rules to create a Led on the knowledge base  
===============================================================
*/
/*
---------------------------------
Current state of the LED
---------------------------------
*/
ledState( off ).

/*
---------------------------------
Led construction rule
---------------------------------
*/
createLed(Name,Color) :- 
	assert( ledName( Name ) ),
	assert( ledColor( Color ) ),
	turnTheLed( off ).
/*
-------------------------------------------------
Led internal behavior (led implemented as a fact)
-------------------------------------------------
*/
turnTheLed( on ):-
	retract( ledState( _ ) ),
	assert( ledState(on) ),
	show.
turnTheLed( off ):-
	retract( ledState( _ ) ),
 	assert( ledState(off) ),
 	show.
show:-
	ledName( N ),
	ledColor( C ),
	ledState( V ),
	actorPrintln( led( N,C,V ) ).
/*
-------------------------------------------------
Led 'public' operations (ILed interface)
-------------------------------------------------
*/
isOn  :-
	ledState(on).
turnOn :-
	turnTheLed( on ),
	isOn.		%%test
turnOff :-
	turnTheLed( off ),
 	not isOn.	%%test
doSwitch :-
	isOn,!,
	turnOff.
doSwitch :-
 	turnOn.		