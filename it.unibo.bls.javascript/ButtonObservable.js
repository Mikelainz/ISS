
function Button (name) {
	this.name = name;
}

Button.prototype = require("./Observable");
//Button.prototype.constructor = Button;
Button.prototype.press = function(){
	this.notify();
}

//Exports
if(typeof document == "undefined") module.exports.Button = Button;
