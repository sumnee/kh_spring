package com.kh.customer.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.customer.domain.Customer;
import com.kh.customer.service.CustomerService;
import com.kh.customer.store.CustomerStore;
import com.kh.customer.store.logic.CustomerStoreLogic;

@Component("customerService")
//xml에 쓰는 대신 Annotation으로 bean 등록
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	//의존성 자동 주입! 아래 1,2번 안해도댐
	
	private CustomerStore cStore;
	
	
//	1. setter 메소드를 이용한 의존성 주입
	public void setStore(CustomerStore cStore) {}
	
	public CustomerServiceImpl() {}
	
//	2. 생성자를 이용한 의존성 주입
	public CustomerServiceImpl(CustomerStore csStore) {}

	@Override
	public Customer findOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		//List<Customer> cList = cStore.selectAllCustomers();
		//return cList;
		//이렇게 변수 써서 해도 되고 아래처럼 변수없이 한줄로도 가능
		
		return cStore.selectAllCustomers();
	}

}
