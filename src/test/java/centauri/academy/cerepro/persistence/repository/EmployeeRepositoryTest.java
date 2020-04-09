package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
//import java.util.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.Employee;
import centauri.academy.cerepro.persistence.entity.Role;
import centauri.academy.cerepro.persistence.entity.User;


/**
 * 
 * Provides a repository test class to test repository methods
 * 
 * @author Centauri Academy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest extends AbstractRepositoryTest{

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRepositoryTest.class);
	
	@Autowired
	private EmployeeRepository er;
	@Autowired
	private UserRepository ur;
	@Autowired
	private RoleRepository rr;

	
	/**
	 * Provides to clean Employee table and all(previously) referenced tables:
	 * user, candidate and employee.
     * in order to be able to execute tests.
     * Execute clean before and after each test
     */
	@Before
	@After
	public void initializeEmployeeTests () {
		logger.info("EmployeeRepositoryTest.initializeEmployeeTests - START");		
		er.deleteAll();
		ur.deleteAll();
		rr.deleteAll();
		logger.info("EmployeeRepositoryTest.initializeEmployeeTests - END");
	}

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * Employee table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("EmployeeRepositoryTest.testSelectAllFilled() - START");
		getFakeEmployee();
		assertTrue(er.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * Employees' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info("EmployeeRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(er.count()==0);
    }

	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("EmployeeRepositoryTest.testInsert() - START");
		assertTrue(er.count()==0);
		getFakeEmployee();
		assertTrue(er.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("EmployeeRepositoryTest.testSelectById() - START");
		Employee currentEmployee = getFakeEmployee();
		assertTrue(er.findById(currentEmployee.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("EmployeeRepositoryTest.testUpdate() - START");
		Employee currentEmployee = getFakeEmployee();
		currentEmployee.setDomicileCity("Roma");
		er.save(currentEmployee);
		assertTrue(er.findById(currentEmployee.getId()).isPresent());	
		assertTrue((er.findById(currentEmployee.getId()).get().getDomicileCity().equals("Roma")));
	}

	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("EmployeeRepositoryTest.testDeleteById() - START");
		Employee currentEmployee = getFakeEmployee();
    	assertTrue(er.count()==1);
    	er.deleteById(currentEmployee.getId());
    	assertTrue(er.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("EmployeeRepositoryTest.testDeleteAll() - START");
		getFakeEmployee();
    	assertTrue(er.count()==1);
    	er.deleteAll();
		assertTrue(er.count()==0);
		logger.info("EmployeeRepositoryTest.testDeleteAll() - END");
	}
	
	
	
}