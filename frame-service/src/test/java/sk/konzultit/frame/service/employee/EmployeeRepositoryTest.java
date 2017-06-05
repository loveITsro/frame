package sk.konzultit.frame.service.employee;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sk.konzultit.frame.service.config.ServiceConfig;
import sk.konzultit.frame.service.employee.EmployeeService;
import sk.loveit.frame.persist.config.JpaConfig;
import sk.loveit.frame.persist.entity.Employee;


/**	
 * Employee Service test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JpaConfig.class, ServiceConfig.class}, loader=AnnotationConfigContextLoader.class)
public class EmployeeRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testAllDAO() throws SQLException {
		assertNotNull("Employee Service is not null.", employeeService);
		
		List<Employee> employees = employeeService.findAll();
		
		assertNotNull("Action list is not null.", employees);
	}
}
