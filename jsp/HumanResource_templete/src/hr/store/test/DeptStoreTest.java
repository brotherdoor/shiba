package hr.store.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import hr.domain.Employee;
import hr.store.logic.DepartmentStoreLogic;
import hr.store.logic.EmployeeStoreLogic;

public class DeptStoreTest {
	private DepartmentStoreLogic test = new DepartmentStoreLogic();
	private EmployeeStoreLogic emp = new EmployeeStoreLogic();

	@Test
	public void test() {
		List<Employee> list = emp.retrieveAll();
		System.out.println(list.get(2).getName());
	}

}
