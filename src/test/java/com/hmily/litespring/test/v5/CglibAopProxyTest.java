package com.hmily.litespring.test.v5;

import com.hmily.litespring.aop.aspectj.AspectJAfterReturningAdvice;
import com.hmily.litespring.aop.aspectj.AspectJBeforeAdvice;
import com.hmily.litespring.aop.aspectj.AspectJExpressionPointcut;
import com.hmily.litespring.aop.framework.AopConfig;
import com.hmily.litespring.aop.framework.AopConfigSupport;
import com.hmily.litespring.aop.framework.CglibProxyFactory;
import com.hmily.litespring.service.v5.PetStoreService;
import com.hmily.litespring.tx.TransactionManager;
import com.hmily.litespring.util.MessageTracker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CglibAopProxyTest {
		
	private static AspectJBeforeAdvice beforeAdvice = null;
	private static AspectJAfterReturningAdvice afterAdvice = null;
	private static AspectJExpressionPointcut pc = null;
	
	private TransactionManager tx;
	
	@Before
	public  void setUp() throws Exception{		
		
		
		tx = new TransactionManager();
		String expression = "execution(* com.hmily.litespring.service.v5.*.placeOrder(..))";
		pc = new AspectJExpressionPointcut();
		pc.setExpression(expression);
		
		beforeAdvice = new AspectJBeforeAdvice(
				TransactionManager.class.getMethod("start"),
				pc,
				tx);
		
		afterAdvice = new AspectJAfterReturningAdvice(
				TransactionManager.class.getMethod("commit"),
				pc,
				tx);		
		
	}
	
	@Test
	public void testGetProxy(){
		
		AopConfig config = new AopConfigSupport();
		
		config.addAdvice(beforeAdvice);
		config.addAdvice(afterAdvice);
		config.setTargetObject(new PetStoreService());
		
		
		CglibProxyFactory proxyFactory = new CglibProxyFactory(config);
		
		PetStoreService proxy = (PetStoreService)proxyFactory.getProxy();
		
		proxy.placeOrder();				
		
		
		List<String> msgs = MessageTracker.getMsgs();
		Assert.assertEquals(3, msgs.size());
		Assert.assertEquals("start tx", msgs.get(0));	
		Assert.assertEquals("place order", msgs.get(1));	
		Assert.assertEquals("commit tx", msgs.get(2));	
		
		proxy.toString();
	}
	
	
	
	
}
