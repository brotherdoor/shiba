package service.logic;

import java.util.List;

import domain.Customer;
import service.CustomerService;
import store.CustomerStore;
import util.Pageable;

public class CustomerServiceLogic implements CustomerService{
	
	private CustomerStore store;
	
//	생성자를 통한 DI
	public CustomerServiceLogic(CustomerStore store) {
		this.store = store;
	}

	@Override
	public Customer findOne(String id) {
		return store.selectOne(id);
	}

	@Override
	public List<Customer> findAll() {
		return store.selectAll();
	}

	@Override
	public List<Customer> findAll(Pageable page) {
		return store.selectAll(page);
	}

	@Override
	public void save(Customer customer) {
		store.register(customer);
	}

	@Override
	public void remote(String id) {
		store.delete(id);
	}

}
