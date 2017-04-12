/*
===========================================================================
buttonTheory.pl
Defines the rules to load a specific theory for each Button implementation
===========================================================================
*/
/*
handleButtonInput is called by a button observer (ButtonObserverForActors)
*/
%% ---------------------------------------------------------------
%% If actorPerceivesEvents set, the actor works in event-based way
%% We do not nothing here
%% ---------------------------------------------------------------
handleButtonInput( V ):-
	actorPerceivesEvents, !.
%% ---------------------------------------------------------------
%% If sendMessageImmediately set, we send a message as specified in templateMsgToSend/4 
%% If no rule is set, we switch to the plan named entryAsObserver
%% ---------------------------------------------------------------

handleButtonInput( V ):-
 	actorobj( Actor ),
 	%% actorPrintln( handleButtonInput( Actor,RECEIVER,MSGTYPE,MSGID,V ) ),	
	( sendMessageImmediately, !, sendMsg(Actor,V) ;
	  executeObserverPlan(Actor,V)
	).
executeObserverPlan(Actor,V):-
 	assert( buttonValue( V ) ),
  	Actor <- entryAsObserver returns Bool.
sendMsg(Actor, V ):-
	templateMsgToSend(RECEIVER,MSGTYPE,MSGID,PAYLOAD),		%%defined at model level
	bind( PAYLOAD, V , CONTENT ),
	Actor <- sendMsg( MSGID, RECEIVER, MSGTYPE, CONTENT ).

%% 'injects' the value V in the structure Term with arity 1
bind( Term , V, R ):-
	functor(Term, Functor, 1),
 	R =.. [ Functor, V ].

/*
* -----------------------------------------------------
* For each implementation get the proper theory
* -----------------------------------------------------
*/
%% buttonImplementation( mock ).
buttonImplementationFile( mock,   "buttonMockTheory.pl"    ).
 
buttonImplementation( gui ).
%% buttonImplementation( rasp ).
%% buttonImplementation( serial ).

buttonImplementationFile( gui,    "buttonGuiTheory.pl"     ).
buttonImplementationFile( rasp,   "buttonPi4jTheory.pl"    ).
buttonImplementationFile( serial, "buttonSerialTheory.pl"  ).
/*
* -----------------------------------------------------
* initialize :
*   if there is a concrete implementation use it
*   otherwise use a simple rule-based button prototype
* -----------------------------------------------------
*/	
initialize  :-  
	buttonImplementation( I ),!,
	buttonImplementationFile( I,F ),
	actorPrintln( buttonImplementationFile( I,F )  ),
	consult( F ).

initialize  :- 
	actorPrintln("initializing buttonMsgTheory without any implementation").

:- initialization(initialize).