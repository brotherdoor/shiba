package service;

import java.util.List;

import domain.Customer;
import util.Pageable;

public interface CustomerService {
	
	Customer findOne(String id);
	List<Customer> findAll();
	List<Customer> findAll(Pageable page);
	void save(Customer customer);
	void remote(String id);

}
