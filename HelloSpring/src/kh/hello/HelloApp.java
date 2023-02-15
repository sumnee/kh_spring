package kh.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		MessageBean bean = (MessageBeanEng)ctx.getBean("messageBean");
		bean.sayHello("Spring");

	}

}
