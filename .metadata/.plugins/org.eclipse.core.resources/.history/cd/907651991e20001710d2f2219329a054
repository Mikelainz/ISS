%====================================================================================
% Context ctxLed  SYSTEM-configuration: file it.unibo.ctxLed.blsDistributed.pl 
%====================================================================================
context(ctxbutton, "192.168.137.1",  "TCP", "8010" ).  		 
context(ctxled, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

