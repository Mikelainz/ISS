/*
===============================================================
talkTheory.pl

Defines rules to interpret the payload USERCMD of events 
    input : usercmd(executeInput(USERCMD))
===============================================================
*/

curPlan("pdefault").

executeInput( fibo(X,Y) ):- !,
	actorobj(Actor),
	Actor <- fibo(X,Y),
	actorPrintln( fibo(X,Y) ).

/*
General actions
*/
executeInput( do( [ GUARD], MOVE, 0 ) ):- !,
	execGeneral( GUARD,MOVE ).

/*
QActor actions
*/	
executeInput(do( [ GUARD],MOVE,DURATION ) ):- 	!,	
	actorobj(Actor),
	%% actorPrintln( executeInput( do( [ GUARD],MOVE,DURATION )  ) ),
	do( Actor, GUARD, MOVE, DURATION  ).
executeInput(do( [ GUARD],MOVE,DURATION,ENDEVENT) ):- 	!,	
	actorobj(Actor),
	%% actorPrintln( executeInput( do( [ GUARD],MOVE,DURATION,ENDEVENT)  ) ),
	do( Actor, GUARD, MOVE, DURATION, ENDEVENT ).
executeInput(do( [ GUARD ], MOVE,DURATION,ALARMS,PLANS) ):- !,	
	actorobj(Actor),
	actorPrintln( executeInput( [ GUARD ], MOVE,DURATION,ALARMS,PLANS) ), 
	do( Actor, GUARD, MOVE, DURATION, ALARMS, PLANS ).

executeInput( MOVE  ):- !,
	execGeneral(true,MOVE,0).


execGeneral(GUARD,MOVE ):-
	actorPrintln( execGeneral( GUARD,MOVE  ) ),
	GUARD,!,
	MOVE, !,
	actorPrintln( done( MOVE) ).
 execGeneral(GUARD,MOVE ):-
	actorobj(Actor),
	do( Actor, GUARD, MOVE, 0  ).

/*
SPECIFIC TIMED MOVES
*/
do( Actor, GUARD, play( FNAME ), DURATION ):-!,
 	%% actorPrintln( do( play( FNAME ), DURATION   ) ), 
	runDoSentence(Actor, sentence( GUARD, move( playsound, FNAME, DURATION ), "", "" ) ).

/*
SPECIFIC ASYNCH MOVES
*/
 

do( Actor, GUARD, play( FNAME ), DURATION, ENDEV ):-!,
 	%%actorPrintln( do( play( FNAME ), DURATION, ENDEV  ) ), 
	runDoSentence(Actor, sentence( GUARD, move( playsound, FNAME, DURATION , ENDEV ), "", "" ) ).
do( Actor, GUARD, MOVE, DURATION, ENDEV ):-!,
	actorPrintln(  "ASYNCH ACTION NOT IMPLEMENTED" ).

/*
SPECIFIC REACTIVE MOVES
*/
do( Actor, GUARD, play( FNAME ), DURATION, EVENTS, PLANS ):-!,
 	actorPrintln( do( play( FNAME ), DURATION, EVENTS, PLANS  ) ), 
	runDoSentence(Actor, sentence( GUARD, move( playsound, FNAME, DURATION  ), EVENTS, PLANS ) ).
do( Actor, GUARD, MOVE, DURATION, EVENTS, PLANS ):-!,
	actorPrintln(  "REACTIVE ACTION NOT IMPLEMENTED" ).


/*
EXECUTE the command
*/	
runDoSentence(Actor, SENTENCE ):-
  	curPlan(PLANNAME),
 	inc( pc,1,PC ) ,
 	actorPrintln(  runDoSentence( Actor, SENTENCE , PLANNAME, PC ) ), 
 	addRule(plan(PC,PLANNAME,SENTENCE) ),
	runTheSentence(Actor, SENTENCE ).		%%runTheSentence/2 is defined in the WorldTheory


	
/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initTalk  :-  
	actorobj(Actor),
	assign( pc,0 ),
	%% actorPrintln( actorobj(Actor) ),
	( Actor <- isSimpleActor returns R, R=true, !,
	  actorPrintln(" *** talkTheory loaded FOR ACTORS ONLY  ***  ");
	  actorPrintln(" *** talkTheory loaded FOR ROBOTS  *** ")
	).
initTalk1  :-  
	actorobj(Actor), 
	assign( pc,0 ),
	%% actorPrintln( actorobj(Actor) ),
	Actor <- isSimpleActor returns R, R=true, !,
	actorPrintln(" *** talkTheorySimple loaded FOR ACTORS ONLY  ***  ").
initTalk1  :-  
   actorPrintln(" *** talkTheorySimple loaded FOR ROBOTS  *** ").

:- initialization(initTalk1).