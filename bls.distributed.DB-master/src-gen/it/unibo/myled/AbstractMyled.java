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
	    	boolean returnValue = suspendWork;
	    while(true){
	    	curPlanInExec =  "init";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		temporaryStr = "\"myLed  STARTS\"";
	    		println( temporaryStr );  
	    		if( ! planUtils.switchToPlan("sysOnRasp").getGoon() ) break;
	    		if( ! planUtils.switchToPlan("work").getGoon() ) break;
	    		//delay
	    		aar = delayReactive(60000,"" , "");
	    		if( aar.getInterrupted() ) curPlanInExec   = "init";
	    		if( ! aar.getGoon() ) break;
	    		temporaryStr = "\"myLed  ENDS\"";
	    		println( temporaryStr );  
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=init WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean sysWithGuiOnPc() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "sysWithGuiOnPc";
	    	boolean returnValue = suspendWork;
	    while(true){
	    	curPlanInExec =  "sysWithGuiOnPc";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(createGuiLed(25))";
	    		//aar = solveGoalReactive(parg,3600000,"","");
	    		//genCheckAar(m.name)»
	    		QActorUtils.solveGoal(parg,pengine );
	    		returnValue = continueWork; //we must restore nPlanIter and curPlanInExec of the 'interrupted' plan
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=sysWithGuiOnPc WARNING:" + e.getMessage() );
	       QActorContext.terminateQActorSystem(this); 
	       return false;  
	    }
	    }
	    public boolean sysOnRasp() throws Exception{	//public to allow reflection
	    try{
	    	int nPlanIter = 0;
	    	//curPlanInExec =  "sysOnRasp";
	    	boolean returnValue = suspendWork;
	    while(true){
	    	curPlanInExec =  "sysOnRasp";	//within while since it can be lost by switchlan
	    	nPlanIter++;
	    		parg = "actorOp(createPi4jLed(25))";
	    		//aar = solveGoalReactive(parg,3600000,"","");
	    		//genCheckAar(m.name)»
	    		QActorUtils.solveGoal(parg,pengine );
	    		returnValue = continueWork; //we must restore nPlanIter and curPlanInExec of the 'interrupted' plan
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
	    	boolean returnValue = suspendWork;
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
	    		if( currentMessage.msgId().equals("click") ){
	    			String parg = "actorOp(startBlink)";
	    			/* ActorOp */
	    			parg =  updateVars( Term.createTerm("click(x)"), Term.createTerm("click(\"start\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    			if( parg != null ){
	    				aar = solveGoalReactive(parg,3600000,"","");
	    				//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    				if( aar.getInterrupted() ){
	    					curPlanInExec   = "work";
	    					if( ! aar.getGoon() ) break;
	    				} 			
	    			}
	    		}//onMsg
	    		if( currentMessage.msgId().equals("click") ){
	    			String parg = "actorOp(stopBlink)";
	    			/* ActorOp */
	    			parg =  updateVars( Term.createTerm("click(x)"), Term.createTerm("click(\"stop\")"), 
	    				    		  					Term.createTerm(currentMessage.msgContent()), parg);
	    			if( parg != null ){
	    				aar = solveGoalReactive(parg,3600000,"","");
	    				//println(getName() + " plan " + curPlanInExec  +  " interrupted=" + aar.getInterrupted() + " action goon="+aar.getGoon());
	    				if( aar.getInterrupted() ){
	    					curPlanInExec   = "work";
	    					if( ! aar.getGoon() ) break;
	    				} 			
	    			}
	    		}printCurrentMessage(false);
	    		if( planUtils.repeatPlan(nPlanIter,0).getGoon() ) continue;
	    break;
	    }//while
	    return returnValue;
	    }catch(Exception e){
	       //println( getName() + " plan=work WARNING:" + e.getMessage() );
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
	
