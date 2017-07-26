%====================================================================================
% Context ctxRadarSystemLogic  SYSTEM-configuration: file it.unibo.ctxRadarSystemLogic.radarSystemLogic.pl 
%====================================================================================
context(ctxradarsystemlogic, "localhost",  "TCP", "8039" ).  		 
%%% -------------------------------------------
qactor( radardevicelogic , ctxradarsystemlogic, "it.unibo.radardevicelogic.MsgHandle_Radardevicelogic"   ). %%store msgs 
qactor( radardevicelogic_ctrl , ctxradarsystemlogic, "it.unibo.radardevicelogic.Radardevicelogic"   ). %%control-driven 
qactor( radarguilogic , ctxradarsystemlogic, "it.unibo.radarguilogic.MsgHandle_Radarguilogic"   ). %%store msgs 
qactor( radarguilogic_ctrl , ctxradarsystemlogic, "it.unibo.radarguilogic.Radarguilogic"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxradarsystemlogic,"it.unibo.ctxRadarSystemLogic.Evh","obstacle").  
%%% -------------------------------------------

