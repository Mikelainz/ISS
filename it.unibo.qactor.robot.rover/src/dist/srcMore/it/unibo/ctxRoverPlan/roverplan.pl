%====================================================================================
% Context ctxRoverPlan  SYSTEM-configuration: file it.unibo.ctxRoverPlan.roverPlan.pl 
%====================================================================================
context(ctxroverplan, "localhost",  "TCP", "8070" ).  		 
%%% -------------------------------------------
%%% -------------------------------------------
%%% -------------------------------------------
qactor( roverplanned , ctxroverplan, "it.unibo.roverplanned.MsgHandle_Roverplanned" ). 
qactor( roverplanned_ctrl , ctxroverplan, "it.unibo.roverplanned.Roverplanned" ). 

