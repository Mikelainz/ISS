function Control(led) {
	this.led = led;
	
	this.update = function() {
		this.controlLogic("");
	}
	
	this.controlLogic = function(cmd) {
		led.switchState();
		this.showLedState();
	}
	
	this.showLedState = function() {
		if(typeof document == "undefined")
			console.log("Led now is "+led.getState());
		else {
			if(led.getState()==true) document.getElementById(led.getGuiId()).style.backgroundColor='#00FF33';
			else document.getElementById(led.getGuiId()).style.backgroundColor='#FF0000';
		}
	}
}

//Exports
if (typeof document == "undefined") module.exports.Control = Control;