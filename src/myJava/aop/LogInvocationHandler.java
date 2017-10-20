package myJava.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler{
	
	private Object target; //目标对象   
	  
    LogInvocationHandler(Object target) {   
        this.target = target;   
    }   

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object oj = method.invoke(target, args);
		if(oj.getClass().getName().equals("doSomething")){
			System.out.println("记录日志");
		}
		return null;
	}

}
