/*
===============================================================
sensorTheory.pl
===============================================================
*/
sensor( distance(DIST,DIR,POS) ):-
	actorobj(Actor),
	%% DIST < 20,
	%% actorPrintln( distance( DIST ) ),
	Actor <- emit( sensordata, sensordata(distance(DIST,DIR,POS)) ).
 
/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initialize  :-  
	actorobj(Actor),
 	( Actor <- isSimpleActor returns R, R=true, !,
	  actorPrintln(" *** sensorTheory loaded FOR ACTORS ONLY  ***  ");
	  actorPrintln(" *** sensorTheory loaded FOR ROBOTS  *** ")
	).
 
:- initialization(initialize).