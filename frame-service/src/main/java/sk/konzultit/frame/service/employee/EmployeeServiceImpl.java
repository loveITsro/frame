package sk.konzultit.frame.service.employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.loveit.frame.persist.entity.Employee;
import sk.loveit.frame.persist.repository.EmployeeRepository;


/**
 * Employee Service implementation
 */
@Service("employeeService")
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService, Serializable {

	private static final long serialVersionUID = -2126903322228099095L;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		List<Employee> result = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(result::add);
		return result;
	}
}
