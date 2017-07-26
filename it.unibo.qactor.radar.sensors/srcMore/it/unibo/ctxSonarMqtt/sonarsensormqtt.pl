%====================================================================================
% Context ctxSonarMqtt  SYSTEM-configuration: file it.unibo.ctxSonarMqtt.sonarSensorMqtt.pl 
%====================================================================================
context(ctxsonarmqtt, "localhost",  "TCP", "8133" ).  		 
%%% -------------------------------------------
qactor( sonarmqtt , ctxsonarmqtt, "it.unibo.sonarmqtt.MsgHandle_Sonarmqtt"   ). %%store msgs 
qactor( sonarmqtt_ctrl , ctxsonarmqtt, "it.unibo.sonarmqtt.Sonarmqtt"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

