var onoff = require('onoff');
var Gpio = onoff.Gpio;


var Led = function(name, guiId) {
	this.name = name;
	this.guiId = guiId;
	this.ledState = false;
	this.physicalLed = new Gpio(25, 'out');
	this.physicalLed.write(0, function(){});
}

Led.prototype.switchState = function() {
	this.ledState = ! this.ledState;
	if(this.ledState==true) this.physicalLed.write(1, function(){});
	else this.physicalLed.write(0, function(){});
}

Led.prototype.getState = function() {
	return this.ledState;
}

Led.prototype.getGuiId = function() {
	return this.guiId;
}

//Exports
if (typeof document == "undefined") module.exports.Led = Led;