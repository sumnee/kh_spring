package kr.iei.customer.service.logic;

import java.util.List;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.service.CustomerService;
import kr.iei.customer.store.CustomerStore;
import kr.iei.customer.store.logic.CustomerStoreLogic;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerStore cStore;
	
//	NullPointException 처리하기	
//	1. setter 메소드를 이용한 의존성 주입
//	CustomerStore cStore = new CustomerStoreLogic(); 역할을 해줌
//	xml 파일의 property
	public void setStore(CustomerStore cStore) {
		this.cStore = cStore;
	}
	
	public CustomerServiceImpl() {
		//이건 기본생성자
		//cStore = new CustomerStoreLogic();
		//윗줄을 빈으로 등록해서 스프링이 해줌
	}
	
//	2. 생성자를 이용한 의존성 주입
//	xml 파일의 constructor-arg
	public CustomerServiceImpl(CustomerStore csStore) {
		this.cStore = csStore;
	}

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
