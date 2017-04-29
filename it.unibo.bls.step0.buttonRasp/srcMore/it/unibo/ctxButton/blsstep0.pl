%====================================================================================
% Context ctxButton  SYSTEM-configuration: file it.unibo.ctxButton.blsStep0.pl 
%====================================================================================
context(ctxbutton, "192.168.137.2",  "TCP", "8010" ).  		 
context(ctxled, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

