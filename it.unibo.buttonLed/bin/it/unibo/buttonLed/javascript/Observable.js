/**
 * 
 */

Observable =function(){
	this.k = 0;
	this.observerFunc = [ ];
	this.observer = [ ];
	this.register = function(obs){
		//println(" Observable register  " + this.k + " " + func);
		this.observerFunc[this.k++] = func;
	}
	this.notify = function(){
		for (var i=0;i< this.observer.length;i++){
			//println("Observable update" + this.observer[i]);
			this.observer[i].update();
		}
		for (var i=0;i< this.observerFunc.length;i++){
			//println("Observable calls" + this.observerFunc[i]);
			this.observerFunc[i]();
		}
		}
	}
}