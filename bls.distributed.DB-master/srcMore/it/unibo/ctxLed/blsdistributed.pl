%====================================================================================
% Context ctxLed  SYSTEM-configuration: file it.unibo.ctxLed.blsDistributed.pl 
%====================================================================================
context(ctxbutton, "localhost",  "TCP", "8010" ).  		 
context(ctxled, "192.168.137.2",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( timer , ctxbutton, "it.unibo.timer.MsgHandle_Timer"   ). %%store msgs 
qactor( timer_ctrl , ctxbutton, "it.unibo.timer.Timer"   ). %%control-driven 
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

