package centauri.academy.cerepro.persistence.repository;
/**
 * @author anna
 */
import static org.junit.Assert.assertTrue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.User;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
	
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private EmployeeRepository er;
	
	/**
     * initializeUserTests() method inserts a new Role
     * in order to be able to insert a new Role
     */
	@Before
	@After
    public void initializeUserTests() {	
    	logger.info("UserRepositoryTest.initializeUserTests - START");	
		er.deleteAll();
		cr.deleteAll();
		ur.deleteAll();	
		rr.deleteAll();

		logger.info("UserRepositoryTest.initializeUserTests - END");
    }

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * user table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("UserRepositoryTest.testSelectAllFilled() - START");
		getFakeUser();
		assertTrue(ur.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * users' table
     */
	@Test
    public void testSelectAllEmpty(){	
		logger.info("UserRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(ur.count()==0);
    }
   
	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("UserRepositoryTest.testInsert() - START");
		assertTrue(ur.count()==0);
		getFakeUser();
		assertTrue(ur.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("UserRepositoryTest.testSelectById() - START");
		User currentUser = getFakeUser();
		assertTrue(ur.findById(currentUser.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("UserRepositoryTest.testUpdate() - START");
		User currentUser = getFakeUser();
		currentUser.setPassword("pippopippo");
		ur.save(currentUser);
		assertTrue(ur.findById(currentUser.getId()).isPresent());	
		assertTrue(ur.findById(currentUser.getId()).get().getPassword().equals("pippopippo"));
	}
	
	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("UserRepositoryTest.testDeleteById() - START");
		User currentUser = getFakeUser();
    	assertTrue(ur.count()==1);
    	ur.deleteById(currentUser.getId());
    	assertTrue(ur.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("UserRepositoryTest.testDeleteAll() - START");
		getFakeUser();
    	assertTrue(ur.count()==1);
    	ur.deleteAll();
		assertTrue(ur.count()==0);
		logger.info("UserRepositoryTest.testDeleteAll() - END");
	}
	
	/**
     * testPageSelectAllFilled() method tests if the method selectAll() 
     * with pageable option
     * is really able to select all tuples from a populated
     * user table
     */
	@Test
    public void testPageSelectAllFilled(){
		logger.info("UserRepositoryTest.testPageSelectAllFilled() - START");
		getFakeUser();
		Page<User> currentPage = ur.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "email"));
		assertTrue(currentPage.getNumberOfElements() == 1);
    }
	
	/**
     * testPageSelectAllFilledFail() method tests if the method selectAll() 
     * with pageable option
     * is really able to select all tuples from a populated
     * user table
     */
	@Test
    public void testPageSelectAllFilledFail(){
		logger.info("UserRepositoryTest.testPageSelectAllFilledFail() - START");
		getFakeUser();
		Page<User> currentPage = ur.findAll(PageRequest.of(1, 5, Sort.Direction.ASC, "email"));
		assertTrue(currentPage.getNumberOfElements() == 0);
    }

}