/* Generated by AN DISI Unibo */ 
/*
This code is generated only ONCE
*/
package it.unibo.mycontrol;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.QActorContext;

public class Mycontrol extends AbstractMycontrol {
	
	private long score;
	private long startTime;
	
	public Mycontrol(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
		super(actorId, myCtx, outEnvView);
	}
	
	public void controlLogic(String cmd){
		//quando il bottone viene premuto controlla che il led corrispondente sia acceso	
	}
	
	public void saveStartTime(){
		startTime = System.currentTimeMillis();
	}
	
	public long updateScore(){
		score += 5000 - (System.currentTimeMillis() - startTime);
		return score;
	}
	
	public long printScore(){
		System.out.println(score);
		return score;
	}
	
	public void resetScore(){
		score = 0;
	}
}
