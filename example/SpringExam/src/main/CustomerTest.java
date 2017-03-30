package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Customer;
import service.CustomerService;
import util.Pageable;

public class CustomerTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		CustomerService service = (CustomerService)ctx.getBean("customerService");
		
		List<Customer> list = service.findAll();
		
		for(Customer c : list){
			System.out.println(c.toString());
		}
		
		Customer cusOne = service.findOne("chm1820");
		System.out.println("cusOne:" + cusOne.toString());
		
		service.save(cusOne);
		
		service.remote("chm1820");
		
		Pageable page = new Pageable(1, 1);
		List<Customer> pageList = service.findAll(page);
		for(Customer c : pageList){
			System.out.println(c.toString());
		}
	}

}
