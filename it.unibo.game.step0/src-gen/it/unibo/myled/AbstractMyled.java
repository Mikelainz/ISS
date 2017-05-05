/* Generated by AN DISI Unibo */ 
package it.unibo.myled;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.ActorTerminationMessage;
import it.unibo.qactors.QActorMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.contactEvent.interfaces.IEventItem;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.action.ActionReceiveTimed;
import it.unibo.qactors.action.AsynchActionResult;
import it.unibo.qactors.action.IActorAction;
import it.unibo.qactors.action.IActorAction.ActionExecMode;
import it.unibo.qactors.action.IMsgQueue;
import it.unibo.qactors.akka.QActor;


//REGENERATE AKKA: QActor instead QActorPlanned
public abstract class AbstractMyled extends QActor { 
	protected AsynchActionResult aar = null;
	protected boolean actionResult = true;
	protected alice.tuprolog.SolveInfo sol;
	//protected IMsgQueue mysupport ;  //defined in QActor
	protected String planFilePath    = null;
	protected String terminationEvId = "default";
	protected String parg="";
	protected boolean bres=false;
	protected IActorAction  action;
	
			protected static IOutputEnvView setTheEnv(IOutputEnvView outEnvView ){
				return outEnvView;
			}
	
	
		public AbstractMyled(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
			super(actorId, myCtx,  
			"./srcMore/it/unibo/myled/WorldTheory.pl",
			setTheEnv( outEnvView )  , "init");		
			this.planFilePath = "./srcMore/it/unibo/myled/plans.txt";
			//Plan interpretation is done in Prolog
			//if(planFilePath != null) planUtils.buildPlanTable(planFilePath);
	 	}
		@Override
		protected void doJob() throws Exception {
			String name  = getName().replace("_ctrl", "");
			mysupport = (IMsgQueue) QActorUtils.getQActor( name ); 
	 		initSensorSystem();
			boolean res = init();
			//println(getName() + " doJob " + res );
			QActorContext.terminateQActorSystem(this);
		} 
		/* 
		* ------------------------------------------------------------
		* PLANS
		* ------------------------------------------------------------
		*/
	    public boolean init() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "init";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "init";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		temporaryStr = "qaled(starts)";
	    		println( temporaryStr );  
	    		if( ! planUtils.switchToPlan("sysOnRasp").getGoon() ) break;
	    		if( ! planUtils.switchToPlan("work").getGoon() ) break;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=init WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean sysOnPc() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "sysOnPc";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "sysOnPc";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(createGuiLed(25))";
	    		aar = solveGoalReactive(parg,3600000,"","");
	    		//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    		if( aar.getInterrupted() ){
	    			curPlanInExec   = "sysOnPc";
	    			if( aar.getTimeRemained() <= 0 ) addRule("tout(actorOp,"+getName()+")");
	    			if( ! aar.getGoon() ) break;
	    		} 			
	    		//QActorUtils.solveGoal(parg,pengine );
	    		//we should restore nPlanIter and curPlanInExec of the 'interrupted' plan ???
	    		returnValue = continueWork;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=sysOnPc WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean sysOnRasp() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "sysOnRasp";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "sysOnRasp";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(createPi4jLed(25))";
	    		aar = solveGoalReactive(parg,3600000,"","");
	    		//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    		if( aar.getInterrupted() ){
	    			curPlanInExec   = "sysOnRasp";
	    			if( aar.getTimeRemained() <= 0 ) addRule("tout(actorOp,"+getName()+")");
	    			if( ! aar.getGoon() ) break;
	    		} 			
	    		//QActorUtils.solveGoal(parg,pengine );
	    		//we should restore nPlanIter and curPlanInExec of the 'interrupted' plan ???
	    		returnValue = continueWork;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=sysOnRasp WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean work() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "work";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "work";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		//ReceiveMsg
	    		 		aar = planUtils.receiveAMsg(mysupport,60000, "" , "" ); 	//could block
	    			    if( ! aar.getGoon() || aar.getTimeRemained() <= 0 ){
	    			    	//println("	WARNING: receivemsg timeout " + aar.getTimeRemained());
	    			    	addRule("tout(receivemsg,"+getName()+")");
	    			    }
	    		//onMsg
	    		if( currentMessage.msgId().equals("controlMessage") ){
	    			String parg = "";
	    			/* SwitchPlan */
	    			parg =  updateVars(  Term.createTerm("controlMessage(X)"), Term.createTerm("controlMessage(\"startPattern\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    				if( parg != null ){
	    					 if( ! planUtils.switchToPlan("pattern").getGoon() ) break; 
	    				}//else println("guard  fails");  //parg is null when there is no guard (onEvent)
	    		}//onMsg
	    		if( currentMessage.msgId().equals("controlMessage") ){
	    			String parg = "";
	    			/* SwitchPlan */
	    			parg =  updateVars(  Term.createTerm("controlMessage(X)"), Term.createTerm("controlMessage(\"gameOver\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    				if( parg != null ){
	    					 if( ! planUtils.switchToPlan("gameOver").getGoon() ) break; 
	    				}//else println("guard  fails");  //parg is null when there is no guard (onEvent)
	    		}if( planUtils.repeatPlan(nPlanIter,0).getGoon() ) continue;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=work WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean pattern() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "pattern";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "pattern";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(switchLedState)";
	    		aar = solveGoalReactive(parg,3600000,"","");
	    		//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    		if( aar.getInterrupted() ){
	    			curPlanInExec   = "pattern";
	    			if( aar.getTimeRemained() <= 0 ) addRule("tout(actorOp,"+getName()+")");
	    			if( ! aar.getGoon() ) break;
	    		} 			
	    		//QActorUtils.solveGoal(parg,pengine );
	    		//ReceiveMsg
	    		 		aar = planUtils.receiveAMsg(mysupport,500, "" , "" ); 	//could block
	    			    if( ! aar.getGoon() || aar.getTimeRemained() <= 0 ){
	    			    	//println("	WARNING: receivemsg timeout " + aar.getTimeRemained());
	    			    	addRule("tout(receivemsg,"+getName()+")");
	    			    }
	    		//onMsg
	    		if( currentMessage.msgId().equals("controlMessage") ){
	    			String parg = "";
	    			/* SwitchPlan */
	    			parg =  updateVars(  Term.createTerm("controlMessage(X)"), Term.createTerm("controlMessage(\"stopPattern\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    				if( parg != null ){
	    					 if( ! planUtils.switchToPlan("game").getGoon() ) break; 
	    				}//else println("guard  fails");  //parg is null when there is no guard (onEvent)
	    		}//onMsg
	    		if( currentMessage.msgId().equals("controlMessage") ){
	    			String parg = "";
	    			/* SwitchPlan */
	    			parg =  updateVars(  Term.createTerm("controlMessage(X)"), Term.createTerm("controlMessage(\"gameOver\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    				if( parg != null ){
	    					 if( ! planUtils.switchToPlan("gameOver").getGoon() ) break; 
	    				}//else println("guard  fails");  //parg is null when there is no guard (onEvent)
	    		}if( planUtils.repeatPlan(nPlanIter,0).getGoon() ) continue;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=pattern WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean game() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "game";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "game";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(turnOn)";
	    		aar = solveGoalReactive(parg,3600000,"","");
	    		//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    		if( aar.getInterrupted() ){
	    			curPlanInExec   = "game";
	    			if( aar.getTimeRemained() <= 0 ) addRule("tout(actorOp,"+getName()+")");
	    			if( ! aar.getGoon() ) break;
	    		} 			
	    		//QActorUtils.solveGoal(parg,pengine );
	    		if( ! planUtils.switchToPlan("work").getGoon() ) break;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=game WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean gameOver() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "gameOver";
	    	boolean returnValue = suspendWork;		//MARCHH2017
	    while(true){
	    	curPlanInExec =  "gameOver";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(turnOff)";
	    		aar = solveGoalReactive(parg,3600000,"","");
	    		//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    		if( aar.getInterrupted() ){
	    			curPlanInExec   = "gameOver";
	    			if( aar.getTimeRemained() <= 0 ) addRule("tout(actorOp,"+getName()+")");
	    			if( ! aar.getGoon() ) break;
	    		} 			
	    		//QActorUtils.solveGoal(parg,pengine );
	    		temporaryStr = "qaled(ends)";
	    		println( temporaryStr );  
	    		//delay
	    		aar = delayReactive(5000,"" , "");
	    		if( aar.getInterrupted() ) curPlanInExec   = "gameOver";
	    		if( ! aar.getGoon() ) break;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=gameOver WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    protected void initSensorSystem(){
	    	//doing nothing in a QActor
	    }
	    
	 
		/* 
		* ------------------------------------------------------------
		* APPLICATION ACTIONS
		* ------------------------------------------------------------
		*/
		/* 
		* ------------------------------------------------------------
		* QUEUE  
		* ------------------------------------------------------------
		*/
		    protected void getMsgFromInputQueue(){
	//	    	println( " %%%% getMsgFromInputQueue" ); 
		    	QActorMessage msg = mysupport.getMsgFromQueue(); //blocking
	//	    	println( " %%%% getMsgFromInputQueue continues with " + msg );
		    	this.currentMessage = msg;
		    }
	  }
	
