package com.kh.marchpring.common;



public class LogAdvice {


	public void showLog() {
		System.out.println("[공통로그-LogAdvice] 비즈니스 로직 수행 전");
	}
	
	public void printLog() {
		System.out.println("[공통로그-LogAdvice] 비즈니스 로직 수행 후");
	}
}
