%====================================================================================
% Context ctxSonar  SYSTEM-configuration: file it.unibo.ctxSonar.sonarSensor.pl 
%====================================================================================
context(ctxradartfce16, "192.168.251.1",  "TCP", "8033" ).  		 
context(ctxsonar, "192.168.251.118",  "TCP", "8133" ).  		 
%%% -------------------------------------------
qactor( sensorsonar , ctxsonar, "it.unibo.sensorsonar.MsgHandle_Sensorsonar"   ). %%store msgs 
qactor( sensorsonar_ctrl , ctxsonar, "it.unibo.sensorsonar.Sensorsonar"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

