//QActorWebUI.js
    console.log("QActorWebUI.js : server IP= "+document.location.host);
 /*
 * WEBSOCKET
 */
    var sock = new WebSocket("ws://"+document.location.host, "protocolOne");
    sock.onopen = function (event) {
         //console.log("QActorWebUI.js : I am connected to server.....");
     };
    sock.onmessage = function (event) {
        //console.log("QActorWebUI.js : "+event.data);
       alert( "onmessage " + event);    	
    }
    sock.onerror = function (error) {
        //console.log('WebSocket Error %0',  error);
    	alert( "onerror " + error);
    };    
 	function send(message) {
 		var msg = "msg( MSGID, MSGTYPE, SENDER, RECEIVER, CONTENT, 0 )"
 		msg = "m-" + msg.replace("MSGID","turnLed").replace("MSGTYPE","dispatch").
 			replace("SENDER","web").replace("RECEIVER","ledmsg").replace("CONTENT",message);
  		//alert( "send " + msg);
 		sock.send(msg);
	};
// 	alert("loaded");
