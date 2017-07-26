%====================================================================================
% Context ctxOtherSensors  SYSTEM-configuration: file it.unibo.ctxOtherSensors.radarOtherSensors.pl 
%====================================================================================
context(ctxradar, "localhost",  "TCP", "8080" ).  		 
context(ctxothersensors, "localhost",  "TCP", "8039" ).  		 
%%% -------------------------------------------
qactor( sensormock , ctxothersensors, "it.unibo.sensormock.MsgHandle_Sensormock"   ). %%store msgs 
qactor( sensormock_ctrl , ctxothersensors, "it.unibo.sensormock.Sensormock"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

