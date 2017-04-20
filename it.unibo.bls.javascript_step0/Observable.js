Observable = function () {
	this.k = 0;
	this.observer = [ ];
	
	this.register = function(obs) {
		//console.log("Observable register "+this.k);
		this.observer[this.k++] = obs;
	}
	
	this.notify = function() {
		for(var i=0; i<this.observer.length; i++) {
			//console.log("Observable update "+this.observer[i]);
			this.observer[i].update();
		}
	}
}

//Exports
if(typeof document == "undefined") module.exports.Observable = Observable;