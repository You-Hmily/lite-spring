package com.hmily.litespring.test.v5;


import com.hmily.litespring.service.v5.PetStoreService;
import com.hmily.litespring.tx.TransactionManager;
import org.junit.Test;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CGLibTest {
	
	@Test
	public void testCallBack(){
		
		Enhancer enhancer = new Enhancer();
		
        enhancer.setSuperclass(PetStoreService.class);
        
        enhancer.setCallback( new TransactionInterceptor() );
        PetStoreService petStore = (PetStoreService)enhancer.create();
        petStore.placeOrder();
        
        
	}
	
	
	public static class TransactionInterceptor implements MethodInterceptor {
		TransactionManager txManager = new TransactionManager();
	    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	        
	        txManager.start();
	        Object result = proxy.invokeSuper(obj, args);
	        txManager.commit();
	       
	        return result;
	    }
	}
	
	
	@Test 
	public void  testFilter(){
		
		Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PetStoreService.class);
        
        enhancer.setInterceptDuringConstruction(false);
        
        Callback[] callbacks = new Callback[]{new TransactionInterceptor(),NoOp.INSTANCE};
        
        Class<?>[] types = new Class<?>[callbacks.length];
		for (int x = 0; x < types.length; x++) {
			types[x] = callbacks[x].getClass();
		}
		
		
		
        enhancer.setCallbackFilter(new ProxyCallbackFilter());
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackTypes(types);
        
        
        PetStoreService petStore = (PetStoreService)enhancer.create();
        petStore.placeOrder();
        System.out.println(petStore.toString());
        
	}
	private static class ProxyCallbackFilter implements CallbackFilter {	

		public ProxyCallbackFilter() {			
			
		}
		
		public int accept(Method method) {
			if(method.getName().startsWith("place")){
				return 0;
			} else{
				return 1;
			}
			
		}

	}
}
