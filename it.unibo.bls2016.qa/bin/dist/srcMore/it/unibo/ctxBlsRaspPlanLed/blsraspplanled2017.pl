%====================================================================================
% Context ctxBlsRaspPlanLed  SYSTEM-configuration: file it.unibo.ctxBlsRaspPlanLed.blsRaspPlanLed2017.pl 
%====================================================================================
context(ctxblsraspplanled, "localhost",  "TCP", "8010" ).  		 
%%% -------------------------------------------
qactor( buttonplanned , ctxblsraspplanled, "it.unibo.buttonplanned.MsgHandle_Buttonplanned"   ). %%store msgs 
qactor( buttonplanned_ctrl , ctxblsraspplanled, "it.unibo.buttonplanned.Buttonplanned"   ). %%control-driven 
qactor( ledplanned , ctxblsraspplanled, "it.unibo.ledplanned.MsgHandle_Ledplanned"   ). %%store msgs 
qactor( ledplanned_ctrl , ctxblsraspplanled, "it.unibo.ledplanned.Ledplanned"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

