package sk.konzultit.frame.service.employee;

import java.util.List;

import sk.loveit.frame.persist.entity.Employee;


public interface EmployeeService{

	List<Employee> findAll();
	
}
