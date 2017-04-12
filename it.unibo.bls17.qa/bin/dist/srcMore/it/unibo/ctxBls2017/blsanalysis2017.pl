%====================================================================================
% Context ctxBls2017  SYSTEM-configuration: file it.unibo.ctxBls2017.blsAnalysis2017.pl 
%====================================================================================
context(ctxbls2017, "localhost",  "TCP", "8010" ).  		 
%%% -------------------------------------------
qactor( button017 , ctxbls2017, "it.unibo.button017.MsgHandle_Button017"   ). %%store msgs 
qactor( button017_ctrl , ctxbls2017, "it.unibo.button017.Button017"   ). %%control-driven 
qactor( controller017 , ctxbls2017, "it.unibo.controller017.MsgHandle_Controller017"   ). %%store msgs 
qactor( controller017_ctrl , ctxbls2017, "it.unibo.controller017.Controller017"   ). %%control-driven 
qactor( led017 , ctxbls2017, "it.unibo.led017.MsgHandle_Led017"   ). %%store msgs 
qactor( led017_ctrl , ctxbls2017, "it.unibo.led017.Led017"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

