package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.ItConsultant;
import centauri.academy.cerepro.persistence.entity.custom.ItConsultantCustom;
import centauri.academy.cerepro.persistence.repository.itconsultant.ItConsultantRepository;

/**
 * Unit test for ItConsultantCustomRepository
 * @author m.franco
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItConsultantCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(ItConsultantCustomRepositoryTest.class);
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private ItConsultantRepository cr;
	
    /**
     * prepareDB method prepares the database in order to test
     * ItConsultantRepository's methods
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		cr.deleteAll();
		ur.deleteAll();
		rr.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * ItConsultants' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		logger.info(" DEBUG XXX fakeItConsultant: " + getFakeItConsultant());
		List<ItConsultantCustom> ccList = cr.getAllCustomItConsultants();
		logger.info("testSelectAllFilled - DEBUG - getAllCustomItConsultants returns: " + ccList + " elements");
//		for (ItConsultantCustom current : ccList) logger.info("current ItConsultant custom: " + current.toString());
		assertTrue(cr.getAllCustomItConsultants().size() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * ItConsultants' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(cr.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
    
    /**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		ItConsultant currentItConsultant = getFakeItConsultant();
		logger.info(" testSelectById -> {}", currentItConsultant);
		ItConsultantCustom currentItConsultantCustom = cr.getSingleCustomItConsultant(currentItConsultant.getId());
		logger.info("current ItConsultant custom  " + currentItConsultantCustom);
		assertTrue( currentItConsultantCustom != null ); 
		logger.info(" END -> selectById() ");
    }
    
}
