%====================================================================================
% Context ctxBlsRasp  SYSTEM-configuration: file it.unibo.ctxBlsRasp.blsRasp2017.pl 
%====================================================================================
context(ctxblsrasp, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( buttongpio , ctxblsrasp, "it.unibo.buttongpio.MsgHandle_Buttongpio"   ). %%store msgs 
qactor( buttongpio_ctrl , ctxblsrasp, "it.unibo.buttongpio.Buttongpio"   ). %%control-driven 
qactor( ledgpio , ctxblsrasp, "it.unibo.ledgpio.MsgHandle_Ledgpio"   ). %%store msgs 
qactor( ledgpio_ctrl , ctxblsrasp, "it.unibo.ledgpio.Ledgpio"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxblsrasp,"it.unibo.ctxBlsRasp.Evh","local_click").  
%%% -------------------------------------------

