package store.logic;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import store.CustomerStore;
import util.Pageable;

public class CustomerStoreLogic implements CustomerStore{

	@Override
	public Customer selectOne(String id) {
		Customer cus = new Customer();
		cus.setId(id);
		cus.setName("형문");
		cus.setAddress("구리");
		cus.setEmail("08306@naver.com");
		return cus;
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<>();
		for(int i = 0; i < 10; i ++){
			Customer cus = new Customer();
			cus.setId(i + "");
			cus.setName(i + "");
			cus.setAddress(i + "");
			cus.setEmail(i + "");
			list.add(cus);
		}
		return list;
	}

	@Override
	public List<Customer> selectAll(Pageable page) {
		List<Customer> list = new ArrayList<>();
		
		int index = page.getIndex();
		int size = page.getSize();
		
		for(int i = index; i < index + size; i ++){
			Customer cus = new Customer();
			cus.setId(i + "");
			cus.setName(i + "");
			cus.setAddress(i + "");
			cus.setEmail(i + "");
			list.add(cus);
		}
		return list;
	}

	@Override
	public void register(Customer customer) {
		System.out.println(customer.getName() + "의 데이터가 저장되었음.");
	}

	@Override
	public void delete(String id) {
		Customer cus = selectOne(id);
		System.out.println(cus.getId() + "의 데이터가 삭제되었음.");
	}

}
