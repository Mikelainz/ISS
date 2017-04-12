%====================================================================================
% Context ctxBlsRaspOOp  SYSTEM-configuration: file it.unibo.ctxBlsRaspOOp.blsRaspOop2017.pl 
%====================================================================================
context(ctxblsraspoop, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( controloop , ctxblsraspoop, "it.unibo.controloop.MsgHandle_Controloop"   ). %%store msgs 
qactor( controloop_ctrl , ctxblsraspoop, "it.unibo.controloop.Controloop"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

