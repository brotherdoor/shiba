package store;

import java.util.List;

import domain.Customer;
import util.Pageable;

public interface CustomerStore {
	
	Customer selectOne(String id);
	List<Customer> selectAll();
	List<Customer> selectAll(Pageable page);
	void register(Customer customer);
	void delete(String id);

}
