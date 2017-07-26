%====================================================================================
% Context ctxAvatar  SYSTEM-configuration: file it.unibo.ctxAvatar.avatar.pl 
%====================================================================================
context(ctxavatar, "localhost",  "TCP", "8070" ).  		 
%%% -------------------------------------------
%%% -------------------------------------------
eventhandler(evh,ctxavatar,"it.unibo.ctxAvatar.Evh","endmove,obstacle").  
%%% -------------------------------------------
qactor( avatar , ctxavatar, "it.unibo.avatar.MsgHandle_Avatar" ). 
qactor( avatar_ctrl , ctxavatar, "it.unibo.avatar.Avatar" ). 

