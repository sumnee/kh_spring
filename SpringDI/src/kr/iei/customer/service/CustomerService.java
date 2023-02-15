package kr.iei.customer.service;

import java.util.List;

import kr.iei.customer.domain.Customer;

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
