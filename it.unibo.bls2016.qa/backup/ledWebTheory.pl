/*
===============================================================
ledWebSenderTheory.pl
===============================================================
*/

executeInput(on):-  
	actorPrintln( executeInput(on) ),
 	turnOn.
executeInput(off):- 
	actorPrintln( executeInput(off) ),
	turnOff.
 