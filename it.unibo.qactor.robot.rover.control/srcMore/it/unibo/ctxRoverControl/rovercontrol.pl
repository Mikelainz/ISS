%====================================================================================
% Context ctxRoverControl  SYSTEM-configuration: file it.unibo.ctxRoverControl.roverControl.pl 
%====================================================================================
context(ctxrover, "127.0.0.1",  "TCP", "8070" ).  		 
context(ctxrovercontrol, "127.0.0.1",  "TCP", "8050" ).  		 
%%% -------------------------------------------
qactor( rovermind , ctxrovercontrol, "it.unibo.rovermind.MsgHandle_Rovermind"   ). %%store msgs 
qactor( rovermind_ctrl , ctxrovercontrol, "it.unibo.rovermind.Rovermind"   ). %%control-driven 
qactor( roverconsole , ctxrovercontrol, "it.unibo.roverconsole.MsgHandle_Roverconsole"   ). %%store msgs 
qactor( roverconsole_ctrl , ctxrovercontrol, "it.unibo.roverconsole.Roverconsole"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxrovercontrol,"it.unibo.ctxRoverControl.Evh","endplay,sonarDetect").  
%%% -------------------------------------------

