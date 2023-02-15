package kr.iei.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.store.CustomerStore;

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
