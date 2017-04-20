var Led = function(name, guiId) {
	this.name = name;
	this.guiId = guiId;
	this.ledState = false;
}

Led.prototype.switchState = function() {
	this.ledState = ! this.ledState;
}

Led.prototype.getState = function() {
	return this.ledState;
}

Led.prototype.getGuiId = function() {
	return this.guiId;
}

//Exports
if (typeof document == "undefined") module.exports.Led = Led;