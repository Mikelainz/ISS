/**
 * 
 */

var led = {
		name: "led1" ,
		guiId: "ledGuiId" ,
		ledState: false ,


turnOn: function(){
	this.ledState = true;
},

turnOff: function(){
	this.ledState = false;
},

switchState: function(){
	this.ledState = ! this.ledState;
},

getState: function(){
	return this.state;
},

getName: function(){
	return this.name;
},

getDefaultRep: function(){
	return this.name+"||"+this.ledState;
},

showDefaultGui: function(){
	if ( typeof document != "undefined" ) {
		if ( this.ledState ) document.getElementById(this.guiId).style.backgroundColor='#00FF33';
		else document.getElementById(this.guiId).style.backgroundColor='#FF0000';
	}
	println( this.getDefaultRep() );
},//trailing comma

};

println = function( v ) {
	try{
		if (  typeof document != "undefined" ) showMsg( 'outView', v+"<br/>" );
		else console.log( v );
	} catch (e){
		console.log( v );
	}
}

/*
 * Make led visible in other modules
 */
if ( typeof document == "undefined" ) 
	module.exports.led = led;
