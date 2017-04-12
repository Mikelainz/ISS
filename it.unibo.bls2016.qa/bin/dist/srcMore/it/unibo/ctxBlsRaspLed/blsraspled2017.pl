%====================================================================================
% Context ctxBlsRaspLed  SYSTEM-configuration: file it.unibo.ctxBlsRaspLed.blsRaspLed2017.pl 
%====================================================================================
context(ctxblsraspled, "localhost",  "TCP", "8010" ).  		 
%%% -------------------------------------------
qactor( button , ctxblsraspled, "it.unibo.button.MsgHandle_Button"   ). %%store msgs 
qactor( button_ctrl , ctxblsraspled, "it.unibo.button.Button"   ). %%control-driven 
qactor( led , ctxblsraspled, "it.unibo.led.MsgHandle_Led"   ). %%store msgs 
qactor( led_ctrl , ctxblsraspled, "it.unibo.led.Led"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

