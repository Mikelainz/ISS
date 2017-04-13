%====================================================================================
% Context ctxButton  SYSTEM-configuration: file it.unibo.ctxButton.blsDistributed.pl 
%====================================================================================
context(ctxbutton, "localhost",  "TCP", "8010" ).  		 
context(ctxled, "192.168.137.2",  "TCP", "8030" ).  		 
%%% -------------------------------------------
qactor( myled , ctxled, "it.unibo.myled.MsgHandle_Myled"   ). %%store msgs 
qactor( myled_ctrl , ctxled, "it.unibo.myled.Myled"   ). %%control-driven 
qactor( mybutton , ctxbutton, "it.unibo.mybutton.MsgHandle_Mybutton"   ). %%store msgs 
qactor( mybutton_ctrl , ctxbutton, "it.unibo.mybutton.Mybutton"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

