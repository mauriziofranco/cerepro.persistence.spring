package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.NewsLetterMessage;
/**
 * @author Jefersson Serrrano
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsLetterMessageRepositoryTest extends AbstractRepositoryTest  {

	private static final Logger logger = LoggerFactory.getLogger(NewsLetterMessageRepositoryTest.class);
	
	@Autowired
	private NewsLetterMessageRepository nlmr;
	/**
	 * Provides to clean NewsLetterMessage table and all(previously) referenced tables:
     * in order to be able to execute tests.
     * Execute clean before and after each test
     */
	@Before
	@After
	public void initializeNewsLetterMessageTests () {
		logger.info("NewsLetterMessageRepositoryTest.initializeNewsLetterMessageTests - START");		
		nlmr.deleteAll();
		logger.info("NewsLetterMessageRepositoryTest.initializeNewsLetterMessageTests - END");
	}

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * NewsLetterMessage table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("NewsLetterMessageRepositoryTest.testSelectAllFilled() - START");
		getFakeNewsLetterMessage();
		assertTrue(nlmr.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * NewsLetterMessage' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info("NewsLetterMessageRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(nlmr.count()==0);
    }

	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("NewsLetterMessageRepositoryTest.testInsert() - START");
		assertTrue(nlmr.count()==0);
		getFakeNewsLetterMessage();
		assertTrue(nlmr.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("NewsLetterMessageRepositoryTest.testSelectById() - START");
		NewsLetterMessage currentNewsLetterMessage = getFakeNewsLetterMessage();
		assertTrue(nlmr.findById(currentNewsLetterMessage.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("NewsLetterMessageRepositoryTest.testUpdate() - START");
		NewsLetterMessage currentNewsLetterMessage = getFakeNewsLetterMessage();
		currentNewsLetterMessage.setSubject("subject 2 testUpdate");
		currentNewsLetterMessage.setMessage("message 2 testUpdate");
		nlmr.save(currentNewsLetterMessage);
		assertTrue(nlmr.findById(currentNewsLetterMessage.getId()).isPresent());	
		assertTrue((nlmr.findById(currentNewsLetterMessage.getId()).get().getSubject().equals("subject 2 testUpdate")));
		assertTrue((nlmr.findById(currentNewsLetterMessage.getId()).get().getMessage().equals("message 2 testUpdate")));
	}

	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("NewsLetterMessageRepositoryTest.testDeleteById() - START");
		NewsLetterMessage currentNewsLetterMessage = getFakeNewsLetterMessage();
    	assertTrue(nlmr.count()==1);
    	nlmr.deleteById(currentNewsLetterMessage.getId());
    	assertTrue(nlmr.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("NewsLetterMessageRepositoryTest.testDeleteAll() - START");
		getFakeNewsLetterMessage();
    	assertTrue(nlmr.count()==1);
    	nlmr.deleteAll();
		assertTrue(nlmr.count()==0);
		logger.info("NewsLetterMessageRepositoryTest.testDeleteAll() - END");
	}
}