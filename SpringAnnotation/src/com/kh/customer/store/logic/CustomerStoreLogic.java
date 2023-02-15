package com.kh.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kh.customer.domain.Customer;
import com.kh.customer.store.CustomerStore;

@Component("customerStore")
//xml에 쓰는 대신 Annotation으로 bean 등록
public class CustomerStoreLogic implements CustomerStore{

	@Override
	public Customer selectOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> cList = new ArrayList();
		for(int i=0; i<10; i++) {
			Customer cOne = new Customer(i+"", i+"", i+"", i+"");
			cList.add(cOne);
		}
		return cList;
	}

}
