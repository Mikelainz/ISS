var ObservableModule = require("./Observable");

/*
 * Quando facciamo un file html che usa questo script la require(..) da errore.
 * La commentiamo, e nel file html va importato prima lo script Observable.js
 */

function Button(name) {
	this.name = name;
}

Button.prototype = new ObservableModule.Observable();
//Button.prototype = new Observable();
Button.prototype.press = function() {
	this.notify();
}

//Exports
if(typeof document == "undefined") module.exports.Button = Button;