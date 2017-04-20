var http = require('http');
//var LedModule = require("./Led");
var LedModule = require("./LedRaspberry");
var ButtonModule = require("./ButtonObservable");
var ControlModule = require("./ControlObserver");

var led = new LedModule.Led("LED")
var button = new ButtonModule.Button("BUTTON");
var control = new ControlModule.Control(led);
 
var server = http.createServer(function (req, res) {
  button.press();
  res.end();
})

button.register(control);
server.listen(1337, '192.168.137.2');
console.log('Server running at 192.168.137.2');