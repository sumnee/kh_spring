package kr.iei.customer.store;

import java.util.List;

import kr.iei.customer.domain.Customer;

public interface CustomerStore {

	/**
	 * 아이디로 조회 Store
	 * @param id
	 * @return
	 */
	public Customer selectOneById(String id);
	
	
	/**
	 * 전체 조회 Store
	 * @return
	 */
	public List<Customer> selectAllCustomers();
}
