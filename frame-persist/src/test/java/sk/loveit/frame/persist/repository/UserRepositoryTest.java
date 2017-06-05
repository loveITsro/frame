package sk.loveit.frame.persist.repository;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sk.loveit.frame.persist.config.JpaConfig;
import sk.loveit.frame.persist.entity.User;


/**
 * User Repository test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JpaConfig.class, loader=AnnotationConfigContextLoader.class)
public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private BaseEntityRepository<User> userRepository;

	@Test
	public void testFindOneDAO() throws SQLException {
		assertNotNull("User Repository is not null.", userRepository);
		
		Iterable<User> users = userRepository.findAll();
		
		assertNotNull("User list is not null.", users);
	}
}
