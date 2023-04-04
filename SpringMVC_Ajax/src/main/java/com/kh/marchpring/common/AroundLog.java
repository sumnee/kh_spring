package com.kh.marchpring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;


public class AroundLog {
	

	public Object checkTime(ProceedingJoinPoint pjp) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();
		Object obj = null;
		
		stopWatch.start();
		
		//대상 메소드
		obj = pjp.proceed();
		
		stopWatch.stop();
		
		//aop:around 사용하여 메소드 실행 전후에 동작할 수 있게함
		
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		
		return obj;
	}

}
