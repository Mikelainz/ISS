%====================================================================================
% Context ctxButton  SYSTEM-configuration: file it.unibo.ctxButton.blsIOT.pl 
%====================================================================================
context(ctxbutton, "192.168.137.2",  "TCP", "8010" ).  		 
context(ctxled, "localhost",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
qactor( iotbutton , ctxbutton, "it.unibo.iotbutton.MsgHandle_Iotbutton"   ). %%store msgs 
qactor( iotbutton_ctrl , ctxbutton, "it.unibo.iotbutton.Iotbutton"   ). %%control-driven 
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
qactor( iotled , ctxled, "it.unibo.iotled.MsgHandle_Iotled"   ). %%store msgs 
qactor( iotled_ctrl , ctxled, "it.unibo.iotled.Iotled"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

