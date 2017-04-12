%====================================================================================
% Context ctxBlsRaspButton  SYSTEM-configuration: file it.unibo.ctxBlsRaspButton.blsRaspButton2017.pl 
%====================================================================================
context(ctxblsraspbutton, "localhost",  "TCP", "8020" ).  		 
%%% -------------------------------------------
qactor( buttongpio , ctxblsraspbutton, "it.unibo.buttongpio.MsgHandle_Buttongpio"   ). %%store msgs 
qactor( buttongpio_ctrl , ctxblsraspbutton, "it.unibo.buttongpio.Buttongpio"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxblsraspbutton,"it.unibo.ctxBlsRaspButton.Evh","local_click").  
%%% -------------------------------------------

