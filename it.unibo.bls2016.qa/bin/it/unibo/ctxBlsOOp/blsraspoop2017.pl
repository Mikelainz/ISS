%====================================================================================
% Context ctxBlsOOp  SYSTEM-configuration: file it.unibo.ctxBlsOOp.blsRaspOop2017.pl 
%====================================================================================
context(ctxblsoop, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( controloop , ctxblsoop, "it.unibo.controloop.MsgHandle_Controloop"   ). %%store msgs 
qactor( controloop_ctrl , ctxblsoop, "it.unibo.controloop.Controloop"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

