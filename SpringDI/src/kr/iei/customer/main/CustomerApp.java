package kr.iei.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.service.CustomerService;
import kr.iei.customer.service.logic.CustomerServiceImpl;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		Customer cus1 = (Customer)ctx.getBean("customer");
		System.out.println(cus1.toString());
		
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		List<Customer> cList = cService.findAllCustomers();
		for(Customer cOne : cList) {
			System.out.println(cOne.toString());
		}
	}

}

