%====================================================================================
% Context ctxRadarDevice  SYSTEM-configuration: file it.unibo.ctxRadarDevice.radarDevice.pl 
%====================================================================================
context(ctxradargui, "192.168.251.1",  "TCP", "8080" ).  		 
context(ctxradardevice, "192.168.251.104",  "TCP", "8037" ).  		 
%%% -------------------------------------------
qactor( radardevice , ctxradardevice, "it.unibo.radardevice.MsgHandle_Radardevice"   ). %%store msgs 
qactor( radardevice_ctrl , ctxradardevice, "it.unibo.radardevice.Radardevice"   ). %%control-driven 
qactor( qastepper , ctxradardevice, "it.unibo.qastepper.MsgHandle_Qastepper"   ). %%store msgs 
qactor( qastepper_ctrl , ctxradardevice, "it.unibo.qastepper.Qastepper"   ). %%control-driven 
qactor( qasonar , ctxradardevice, "it.unibo.qasonar.MsgHandle_Qasonar"   ). %%store msgs 
qactor( qasonar_ctrl , ctxradardevice, "it.unibo.qasonar.Qasonar"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

