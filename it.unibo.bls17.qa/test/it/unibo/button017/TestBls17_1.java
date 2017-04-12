package it.unibo.button017;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import it.unibo.ctxBls2017.MainCtxBls2017;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.QActorUtils;
import it.unibo.qactors.akka.QActor;
 
/*
 * Each test recreates and runs the whole system
 */
public class TestBls17_1 {
   private QActorContext ctx;
   
  	@Before
	public void setUp() throws Exception  {
    	ctx = MainCtxBls2017.initTheContext();
  		System.out.println("====== setUp  " + ctx );
 	}
	 @After
	 public void terminate(){
		ctx.terminateQActorSystem();
	  	System.out.println("====== terminate  " + ctx );
 	 }

  	@Test
	public void execTest() {  
  		System.out.println("====== execTest ==============="  );
		try {
  			QActor qa     = QActorUtils.getQActor("button017_ctrl");
  			assertTrue("actorTest qa", qa != null );
  			Prolog pengine = qa.getPrologEngine();
  			assertTrue("actorTest pengine", pengine != null );
   			SolveInfo sol = QActorUtils.solveGoal("fib(41,V)",pengine);
 			assertTrue("actorTest", sol.isSuccess());
 			int v = Integer.parseInt(  sol.getVarValue("V").toString() );
 			assertTrue("actorTest fib", v==165580141);
 			System.out.println("actorTest fib="+v);
  		} catch (Exception e) {
			fail("actorTest " + e.getMessage() );
		}		
	}
} 	
