%====================================================================================
% Context ctxLed  SYSTEM-configuration: file it.unibo.ctxLed.blsStep0.pl 
%====================================================================================
context(ctxbutton, "localhost",  "TCP", "8010" ).  		 
context(ctxled, "192.168.137.1",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

