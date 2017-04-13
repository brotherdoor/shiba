package shop.service.logic;

import shop.domain.Customer;
import shop.service.facade.CustomerService;
import shop.store.facade.CustomerStore;
import shop.store.logic.CustomerStoreLogic;

public class CustomerServiceLogic implements CustomerService{
	
	private CustomerStore store;
	
	public CustomerServiceLogic(){
		store = new CustomerStoreLogic();
	}

	@Override
	public boolean login(String userId, String password) {
		Customer customer = store.findCustomerById(userId);
		if(customer != null && customer.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomer(String userId) {
		return store.findCustomerById(userId);
	}

}