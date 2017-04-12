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
public class TestBls17_0 {
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
	public void ctxTest() {  
  		System.out.println("====== ctxTest ==============="  );
		try {
			System.out.println("ctxTest name:"+ctx.getName());
			System.out.println("ctxTest port:"+ctx.getCtxPort());
 			assertTrue("ctxTest", ctx.getCtxPort()==8010);
  		} catch (Exception e) {
			fail("ctxTest " + e.getMessage() );
		}		
	}
 	@Test
	public void actorTest() {  
  		System.out.println("====== actorTest ==============="  );
		try {
  			QActor qa     = QActorUtils.getQActor("button017_ctrl");
  			assertTrue("actorTest qa", qa != null );
  			QActor qa1     = QActorUtils.getQActor("button017");
  			assertTrue("actorTest qa1", qa1 != null );
  		} catch (Exception e) {
			fail("actorTest " + e.getMessage() );
		}		
	}
 	@Test
	public void evalTest() {  
  		System.out.println("====== evalTest ==============="  );
		try {
  			QActor qa      = QActorUtils.getQActor("button017_ctrl");
   			Prolog pengine = qa.getPrologEngine();
  			assertTrue("evalTest pengine", pengine != null );
   			SolveInfo sol = QActorUtils.solveGoal("fib(41,V)",pengine);
 			assertTrue("evalTest", sol.isSuccess());
 			int v = Integer.parseInt(  sol.getVarValue("V").toString() );
 			assertTrue("evalTest fib", v==165580141);
 			System.out.println("evalTest fib="+v);
  		} catch (Exception e) {
			fail("evalTest " + e.getMessage() );
		}		
	}
} 	
