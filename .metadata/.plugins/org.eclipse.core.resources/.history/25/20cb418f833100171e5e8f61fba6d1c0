%====================================================================================
% Context ctxLed  SYSTEM-configuration: file it.unibo.ctxLed.gameStep0.pl 
%====================================================================================
context(ctxbutton, "localhost",  "TCP", "8010" ).  		 
context(ctxcontrol, "192.168.137.1",  "TCP", "8020" ).  		 
context(ctxled, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( mycontrol , ctxcontrol, "it.unibo.mycontrol.MsgHandle_Mycontrol"   ). %%store msgs 
qactor( mycontrol_ctrl , ctxcontrol, "it.unibo.mycontrol.Mycontrol"   ). %%control-driven 
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
qactor( flashled , ctxled, "it.unibo.flashled.MsgHandle_Flashled"   ). %%store msgs 
qactor( flashled_ctrl , ctxled, "it.unibo.flashled.Flashled"   ). %%control-driven 
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

