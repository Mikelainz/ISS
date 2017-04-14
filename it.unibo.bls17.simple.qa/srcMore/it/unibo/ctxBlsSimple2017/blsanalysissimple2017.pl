%====================================================================================
% Context ctxBlsSimple2017  SYSTEM-configuration: file it.unibo.ctxBlsSimple2017.blsAnalysisSimple2017.pl 
%====================================================================================
context(ctxblssimple2017, "localhost",  "TCP", "8010" ).  		 
context(ctxblssimple2017, "localhost",  "TCP", "8011" ).  		 
%%% -------------------------------------------
qactor( buttongui017 , ctxblssimple2017, "it.unibo.buttongui017.MsgHandle_Buttongui017"   ). %%store msgs 
qactor( buttongui017_ctrl , ctxblssimple2017, "it.unibo.buttongui017.Buttongui017"   ). %%control-driven 
qactor( ledsimple017 , ctxblssimple2017, "it.unibo.ledsimple017.MsgHandle_Ledsimple017"   ). %%store msgs 
qactor( ledsimple017_ctrl , ctxblssimple2017, "it.unibo.ledsimple017.Ledsimple017"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

