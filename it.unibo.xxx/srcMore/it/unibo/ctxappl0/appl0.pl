%====================================================================================
% Context ctxappl0  SYSTEM-configuration: file it.unibo.ctxappl0.appl0.pl 
%====================================================================================
context(ctxappl0, "localhost",  "TCP", "8010" ).  		 
%%% -------------------------------------------
%%% -------------------------------------------
%%% -------------------------------------------
qactor( voyager , ctxappl0, "it.unibo.voyager.MsgHandle_Voyager" ). 
qactor( voyager_ctrl , ctxappl0, "it.unibo.voyager.Voyager" ). 

