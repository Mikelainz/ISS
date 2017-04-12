/*
===============================================================
ledTheory.pl
Defines the rules to load a specific theory for each Led implementation
===============================================================
*/
%% ledImplementation( mock ).
ledImplementation( gui ).
%% ledImplementation( rasp ).
%% ledImplementation( serial ).

/*
* -----------------------------------------------------
* For each implementation get the proper theory
* -----------------------------------------------------
*/
ledImplementationFile( mock,   "ledMockTheory.pl"    ).
ledImplementationFile( gui,    "ledGuiTheory.pl"     ).
ledImplementationFile( rasp,   "ledPi4jTheory.pl"    ).
ledImplementationFile( serial, "ledSerialTheory.pl"  ).
/*
* -----------------------------------------------------
* initialize :
*   if there is a concrete implementation use it
*   otherwise use a simple rule-based led prototype
* -----------------------------------------------------
*/	
initialize  :-  
	ledImplementation( I ),!,
	ledImplementationFile( I,F ),
	%% actorPrintln( ledImplementationFile( I,F )  ),
	consult( F ),
	consult("ledUsageTheory.pl").

initialize  :- 
	actorPrintln("initializing ledMsgTheory without any implementation"),
	consult( "ledNoImplTheory.pl" ).

:- initialization(initialize).