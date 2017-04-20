//var LedModule = require("./Led");
var LedModule = require("./LedRaspberry");
var ButtonModule = require("./ButtonObservable");
var ControlModule = require("./ControlObserver");
var led = new LedModule.Led("LED")
var button = new ButtonModule.Button("BUTTON");
var control = new ControlModule.Control(led);

function fibonacci(n) {
	if(n<=2) return 1;
	else return fibonacci(n-1) + fibonacci(n-2);
}

function main() {
	
	button.register(control);
	
	button.press();
	fibonacci(35);
	button.press();
	fibonacci(35);
	button.press();
	fibonacci(35);
	button.press();
	fibonacci(35);
}

//Chiamata del main.
main();
//------------------
