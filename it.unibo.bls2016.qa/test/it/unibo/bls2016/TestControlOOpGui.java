package it.unibo.bls2016;

import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.unibo.controloop.ButtonListener;
import it.unibo.controloop.Controloop;
import it.unibo.ctxBlsOOp.MainCtxBlsOOp;
import it.unibo.qactors.QActorUtils;
 
public class TestControlOOpGui {
	private ScheduledThreadPoolExecutor sched = 
			   new ScheduledThreadPoolExecutor( Runtime.getRuntime().availableProcessors() );
	private Controloop control;
	private ButtonListener btnListerner;
	
  	@Before
	public void setUp() throws Exception  {
  		MainCtxBlsOOp.initTheContext();
  		control      = (Controloop) QActorUtils.getQActor("controloop_ctrl");
  		//getQActor return control when the actor is active
  		System.out.println("control=" + control);
  		btnListerner = control.testing_getButtonListener();
   	}
	@After
	public void terminate(){
	  	System.out.println("====== terminate  "  );
	}
	 @Test
	 public void execTest() {  
		 System.out.println("====== execTest ==============="  );
		 try {
			 assertTrue( btnListerner != null );
			 ActionEvent e = new ActionEvent(control.testing_getButton(), 0, "CLICK");
			 for( int i=1; i<=5; i++ ){
				 btnListerner.actionPerformed(e);
				 assertTrue( control.testing_getLed().isOn() );
				 Thread.sleep(200);
				 btnListerner.actionPerformed(e);
				 assertTrue( ! control.testing_getLed().isOn() );
				 Thread.sleep(200);
			 }
 		 } catch (Exception e) {
			 System.out.println("execTest ERROR=" + e.getMessage());
			fail("execTest " + e.getMessage() );
		 }		
	 }
	 
/*
 * To be used for distributed systems with several contexts
 */
	 
	 private void activateCtxs( ){
		 sched.submit( new Runnable(){
			@Override
			public void run() {
				try {
					//QActorContext ctx = 
					MainCtxBlsOOp.initTheContext();
 				} catch (Exception e) { e.printStackTrace(); } 
			}			 
		 });
		 
	 }
	 
}
