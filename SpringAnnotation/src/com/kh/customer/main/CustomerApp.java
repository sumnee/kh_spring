package com.kh.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.customer.domain.Customer;
import com.kh.customer.service.CustomerService;
import com.kh.customer.service.logic.CustomerServiceImpl;


public class CustomerApp {

	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		/*
		 * 필요없음!
		 * Customer cus1 = (Customer)ctx.getBean("customer");
		 * System.out.println(cus1.toString());
		 */
		
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		List<Customer> cList = cService.findAllCustomers();
		for(Customer cOne : cList) {
			System.out.println(cOne.toString());
		}
	}

}

