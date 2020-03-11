package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;


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
import centauri.academy.cerepro.persistence.repository.itconsultant.ItConsultantRepository;

/**
 * Unit test for ItConsultantRepository
 * @author giacomo
 * @author m.franco
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItConsultantRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(ItConsultantRepositoryTest.class);
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
		getFakeItConsultant();
		assertTrue(cr.count() == 1);
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
		ItConsultant current = getFakeItConsultant();
		assertTrue(cr.findById(current.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
    
    /**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(cr.count()==0);
		getFakeItConsultant();
		assertTrue(cr.count()==1);
		logger.info(" END -> insert() ");
    }
    
    /**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
    public void testUpdate(){
		logger.info(" START -> update() ");
    	ItConsultant current = getFakeItConsultant();
		current.setCvExternalPath("newPath");
		cr.save(current);
		assertTrue(cr.findById(current.getId()).isPresent());	
		assertTrue((cr.findById(current.getId()).get().getCvExternalPath().equals("newPath")));
		logger.info(" END -> update() ");
    }
    
    /**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeItConsultant();
    	assertTrue(cr.count()==1);
    	cr.deleteAll();
		assertTrue(cr.count()==0);
		logger.info(" END -> deleteAll() ");
    }
    
    /**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		ItConsultant current = getFakeItConsultant();
    	assertTrue(cr.count()==1);
    	cr.deleteById(current.getId());
    	assertTrue(cr.count()==0);
		logger.info(" END -> deleteById() ");
    }
	

}
