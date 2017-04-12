//Questa e' la classe "base" Observable che implementa i metodi
//generali registerFunc e notify.

Observable = function() {
	this.k = 0;
	this.observerFunc = [ ];
	this.observer = [ ];
	
	this.register = function(observer) {
		//println("Observable register "+thiz.k);
		this.observer[this.k++] = observer;
	}
	
	this.registerFunc = function(func) {
		//println("Observable registerFunc "+thiz.k);
		this.observerFunc[this.k++] = func;
	}
	
	this.notify = function() {
		for(var i=0; i<this.observer.lenght; i++) {
			//println("Observable update "+this.observer[i]);
			this.observer[i].update();
		}
		for(var i=0; i<this.observerFunc.lenght; i++) {
			//println("Observable calls "+this.observerFunc[i]);
			this.observerFunc[i]();
		}
	}
}