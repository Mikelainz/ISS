/*
===============================================================
talkTheory.pl
===============================================================
*/

curPlan("pdefault").
 	
%% 1) Attempt to execute Input as a Prolog term
executeInput( true  ) :- !, setAnswer( true ) . %%WARNING: actorPrintln( true  ) fails
 
executeInput(do(GUARD,GOAL)):- !, do(GUARD,GOAL).
executeInput(do(GUARD,GOAL,DURATION)):- !, do(GUARD,GOAL,DURATION).
executeInput(do(GUARD,GOAL,DURATION,ANSWEREV)):- !, do(GUARD,GOAL,DURATION,ANSWEREV).
executeInput(do(GUARD,GOAL,DURATION,EVENTS,PLANS)):- 
	( list(EVENTS), list(PLANS),
	  ltos(EVENTS,ES),
	  ltos(PLANS,PS),!,
	  actorPrintln( do5(GUARD,GOAL,DURATION,ES,PS) ),
	  do(GUARD,GOAL,DURATION,ES,PS) ,!;
	  setAnswer( failure(syntax)  ) 
	).

executeInput( Input  ) :-
    actorPrintln( executeInput( prolog, Input)  ),
 	Input, !,
  	%% actorPrintln( executeInputgoal( result(Input)  ) ), 
 	setAnswer( Input ).
executeInput( Input  ):-
	setAnswer( failure ) .
	
a :- actorPrintln( "a" ), ltos( [a,b],S ), actorPrintln( result(S)  ).

ltos( L,S ) :- ltos( L,"",S ) .

ltos( [],S,S ).
ltos( [H|T],'',R ):- !,
	text_term(HS,H),
	ltos(T,HS,R).
ltos( [H|T],S,R ):- !,
 	text_term(HS,H),	
 	text_concat(S,',',CS),
	text_concat(CS,HS,RS),
  	ltos(T,RS,R).
ltos(S,S).		%% input should be a string

/*
Commands with GUARD
*/
do(  [ GUARD ]  , MOVE  ) :-	 
	actorobj(Actor),
 	do( Actor, GUARD, MOVE, 0, '' , '', '' ).
do( [ GUARD ], MOVE, DURATION  ) :- 
	actorobj(Actor), DURATION >= 0, 
	do( Actor, GUARD, MOVE, DURATION, '' , '', '' ), !.
do( [ GUARD ], MOVE, DURATION , ENDEV ) :-	 
	actorobj(Actor), DURATION >= 0, atomic( ENDEV ), 
	do( Actor, GUARD, MOVE, DURATION, ENDEV , '', '' ).
do( [ GUARD ], MOVE, DURATION , EVENTS, PLANS) :-	 
	actorobj(Actor), DURATION >= 0,  
	do( Actor, GUARD, MOVE, DURATION, '' , EVENTS, PLANS ).
	
 	
do( Actor, GUARD, print( ARG ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( print, ARG ), EVENTS, PLANS ) ).

do( Actor, GUARD, println( ARG ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( print, ARG ), EVENTS, PLANS ) ).

do( Actor, GUARD, play( FNAME ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( playsound, FNAME, DURATION, ENDEV ), EVENTS, PLANS ) ).

do( Actor, GUARD, move(CMD, SPEED, ANGLE), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( robotmove, CMD, SPEED, DURATION, ANGLE ), EVENTS, PLANS ) ).

do( Actor, GUARD, raise( EVID, CONTENT ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( emit, EVID, CONTENT ), EVENTS, PLANS ) ).

do( Actor, GUARD, forward( DEST, MSGID, MSGCNT ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	runDoSentence(Actor, sentence( GUARD, move( forward, DEST, MSGID, MSGCNT ), EVENTS, PLANS ) ).

do( Actor, GUARD, addRule( Rule ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	addRule( Rule ).

do( Actor, GUARD, removeRule( Rule ), DURATION, ENDEV , EVENTS, PLANS ):-!,
	removeRule( Rule ).
	
do( Actor, GUARD, GOAL, DURATION, ENDEV , EVENTS, PLANS ):-
	actorPrintln( goingtosolve(GOAL)  ),
	runTheSentence(Actor, sentence( GUARD, GOAL, DURATION, ENDEV, EVENTS, PLANS ) ). %%runTheSentence/2 is defined in the WorldTheory


runDoSentence(Actor, SENTENCE ):-
  	curPlan(PLANNAME),
 	actorPrintln(  runDoSentence( Actor, SENTENCE , PLANNAME ) ), 
	%% class("it.unibo.robot.interpreter.RobotInterpreter") <- getPC returns PC, 
 	addRule(plan(PC,PLANNAME,SENTENCE) ),
	runTheSentence(Actor, SENTENCE ).		%%runTheSentence/2 is defined in the WorldTheory
  
runSentence(Input,_):-
	setAnswer( error(removedTalk) ).
 

%%% ---------  println	---------------		
println(M) :-
	actorobj(Actor),
	Actor <- println(M).

%%% ---------  move	---------------		
move(CMD,SPEED,DURATION ):-
	move(CMD,SPEED,DURATION,0).
move(CMD,SPEED,DURATION,ANGLE):-
	actorobj(Actor),
	mapCmdToMove(CMD,MOVE),
	actorPrintln(  executeGoal(Actor, MOVE, SPEED, ANGLE, DURATION, '', '') ),
	Actor <- execute(MOVE, SPEED, ANGLE, DURATION, '', '').	
%%% ---------  Move names	---------------
mapCmdToMove( mf, forward  ).	
mapCmdToMove( moveforward, forward  ).
mapCmdToMove( mb, backward ).
mapCmdToMove( movebackward, backward  ).
mapCmdToMove( ml, left ).
mapCmdToMove( moveleft, left  ).
mapCmdToMove( mr, right ).
mapCmdToMove( moveright, right  ).
mapCmdToMove( h,  stop ). 
mapCmdToMove( movehalt, stop  ).


%%% ---------  raise	---------------	
raise(EVID,CONTENT):-
	actorobj(Actor),
	Actor <- emit( EVID,CONTENT ),
	Actor <- memoCurrentEvent.
emit(EVID,CONTENT):-
	actorobj(Actor),
	Actor <- emit( EVID,CONTENT ),
	Actor <- memoCurrentEvent.
%%% ---------  resumePlan	---------------		
resumePlan(P).


%%% --------- clean 	--------------- 
clean :-
	retactall( msg( MSGID, MSGTYPE, SENDER, RECEIVER, CONTENT, SEQNUM ) ).	
	
%%% --------- forward 	--------------- 
  forward( DEST, MSGID, MSGCONTENT) :-
  	actorobj(Actor),
  	Actor <- forwardFromProlog(MSGID, DEST , MSGCONTENT ).
  
/*
-----------------------------------
Used to test guards and actions
-----------------------------------
*/	
v(12).

/*
------------------------------------------------------------
Actor GUI usercmd 
------------------------------------------------------------
*/

w(SPEED) :-  actorobj(Actor), cvtSpeed(SPEED,S),Actor <- execute(forward, S, 0, 0, '', '').
a(SPEED) :-  actorobj(Actor), cvtSpeed(SPEED,S),Actor <- execute(left, S, 0, 0, '', '').
s(SPEED) :-  actorobj(Actor), cvtSpeed(SPEED,S),Actor <- execute(backward, S, 0, 0, '', '').
d(SPEED) :-  actorobj(Actor), cvtSpeed(SPEED,S),Actor <- execute(right, S, 0, 0, '', '').
h(SPEED) :-  actorobj(Actor), cvtSpeed(SPEED,S),Actor <- execute(stop, S, 0, 0, '', '').

e(fire)    :-  actorobj(Actor), Actor <-emit( "alarm", "fire" ).
e(obstacle):-  actorobj(Actor), Actor <-emit( "alarm", "obstacle" ).

cvtSpeed(low,40).
cvtSpeed(medium,70).
cvtSpeed(high,100).

robotgui(CMD) :- 
	%% actorPrintln(   robotgui(CMD) ),
	moveCmdTable(CMD, MOVE, SPEED ),
	actorobj(Actor),
	actorPrintln(   robotgui(Actor, MOVE, SPEED) ),
	Angle=0,
	Duration=0,	
	Actor <- execute(MOVE, SPEED, Angle, Duration, '', ''),
	actorPrintln(   robotgui(Actor, hasdone) ).

moveCmdTable( w(low), forward, 40 ).
moveCmdTable( w(medium), forward, 70 ).
moveCmdTable( w(high), forward, 100 ).
moveCmdTable( a(low), left, 40 ).
moveCmdTable( a(medium), left, 70 ).
moveCmdTable( a(high), left, 100 ).
moveCmdTable( s(low), backward, 40 ).
moveCmdTable( s(medium), backward, 70 ).
moveCmdTable( s(high), backward, 100 ).
moveCmdTable( d(low), right, 40 ).
moveCmdTable( d(medium), right, 70 ).
moveCmdTable( d(high), right, 100 ).
moveCmdTable( h(low), stop, 0 ).
moveCmdTable( h(medium), stop, 70 ).
moveCmdTable( h(high), stop, 100 ).

welcome :-   actorPrintln("welcome from robotTalkTheory.pl").

execcmdinput :-
	actorobj(Actor),
 	retract( stored(MSGID, usercmd(executeInput(MOVE) ) ) ),
	actorPrintln( executeInput(MOVE) ),
	executeInput(MOVE),
	continue(Actor). 
continue(Actor):-
	retract( unsolved(S) ),!,
 	actorPrintln( "sorry, prolog actions cannot be executed as PlanActions" ).
continue(Actor):-
	result(X), 
	actorPrintln( result(X) ).

/*
------------------------------------------------------------
initialize
------------------------------------------------------------
*/
initTalkTh  :-  
	actorobj(Actor),
 	( Actor <- isSimpleActor returns R, R=true, !,
	  actorPrintln(" *** talkTheoryxxx loaded FOR ACTORS ONLY  ***  ");
	  actorPrintln(" *** talkTheoryxxx loaded FOR ROBOTS  *** ")
	).
 
:- initialization(initTalkTh).