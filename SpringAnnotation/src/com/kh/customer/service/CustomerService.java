package com.kh.customer.service;

import java.util.List;

import com.kh.customer.domain.Customer;


public interface CustomerService {

	/**
	 * 아이디로 조회 Service
	 * @param id
	 * @return
	 */
	public Customer findOneById(String id);
	
	
	/**
	 * 전체 조회 Service
	 * @return
	 */
	public List<Customer> findAllCustomers();
}
