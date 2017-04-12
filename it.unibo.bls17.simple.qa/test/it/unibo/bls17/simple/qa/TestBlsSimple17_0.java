package it.unibo.bls17.simple.qa;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import alice.tuprolog.NoSolutionException;
import alice.tuprolog.SolveInfo;
import it.unibo.ctxBlsSimple2017.MainCtxBlsSimple2017;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;
 
/*
 * Each test recreates and runs the whole system
 */
public class TestBlsSimple17_0 {
   private QActorContext ctx;
   private QActor button;
   private QActor led;
   private String ledState;
   
  	@Before
	public void setUp() throws Exception  {
    	ctx = MainCtxBlsSimple2017.initTheContext();
  		System.out.println("====== setUp  " + ctx );
  		button  = QActorUtils.getQActor("buttongui017_ctrl");
  		led     = QActorUtils.getQActor("ledsimple017_ctrl");
 	}
	 @After
	 public void terminate(){
	  	System.out.println("====== terminate  " + ctx );
 	 }

  	@Test
	public void execTest() {  
  		System.out.println("====== execTest ==============="  );
		try {
    		assertTrue("execTest button", button != null );
  			assertTrue("actorTest led", led != null );
  			ledState = getLedState(led);
  			assertTrue("execTest led", ledState.equals("false") );
  			
 			raiseButtonClick(button);
 			ledState = getLedState(led);
     		assertTrue("execTest led", ledState.equals("true") );
  			
     		raiseButtonClick(button);
			ledState = getLedState(led);
			assertTrue("execTest led", ledState.equals("false") );
 
			raiseButtonClick(button);			
			ledState = getLedState(led);
   			assertTrue("execTest led", ledState.equals("true") );

   			Thread.sleep(1000);

  		} catch (Exception e) {
			fail("actorTest " + e.getMessage() );
		}		
	}
  	
  	public void raiseButtonClick(QActor button) throws InterruptedException{
		QActorUtils.emitEventAfterTime(button, "btn", "click", "click(1)", 500);
		//((it.unibo.buttongui017.Buttongui017)button).emit("click", "click(1)");			
		//((it.unibo.buttongui017.Buttongui017)button).emitDebug(); 			
		Thread.sleep(1000); 	//give time to handle the event		 		
  	}
  	public String getLedState(QActor led) throws NoSolutionException{
  		SolveInfo lsg      = led.solveGoal("value(ledState,V)");
  		String ledState = ""+lsg.getVarValue("V");
		System.out.println("		execTest ls="+ ledState);
		return ledState;
  	}
} 	
