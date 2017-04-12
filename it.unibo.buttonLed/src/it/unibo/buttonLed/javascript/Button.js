/**
 * 
 */
function Button ( name ){
	this.name = name;
}

Button.prototype = new Observable();
//Button.prototype.constructor = Button
Button.prototype.press = function(){
	this.notify // va a richiamare la funzione di observable sopra
}

//EXPORTS
if (typeof document == "undefined")
	module.exports.Button = Button;