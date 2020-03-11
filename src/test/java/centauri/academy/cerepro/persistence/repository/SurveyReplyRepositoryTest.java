package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.SurveyReply;
import centauri.academy.cerepro.persistence.repository.surveyreply.SurveyReplyRepository;
/**
 * 
 * @author anna
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyReplyRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(SurveyReplyRepositoryTest.class);
	
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private SurveyReplyRepository srr;
	@Autowired
	private RoleRepository rr;
	
	
	/**
     * initializeUserTests() method inserts a new Role
     * in order to be able to insert a new Role
     */
	@Before
	@After
    public void initializeSurveyReplyTests() {
    	
    	logger.info("SurveyReplyRepositoryTest.initializeSurveyReplyTests - START");
    	
    	srr.deleteAll();	
		ur.deleteAll();
		sr.deleteAll();
		rr.deleteAll();
	
		logger.info("SurveyReplyRepositoryTest.initializeSurveyReplyTests - END");
    }

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * SurveyReply table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("SurveyReplyRepositoryTest.testSelectAllFilled() - START");
		getFakeSurveyReply();
		assertTrue(srr.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * SurveyReplys' table
     */
	@Test
    public void testSelectAllEmpty(){
		
		logger.info("SurveyReplyRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(srr.count()==0);
    }
   
	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("SurveyReplyRepositoryTest.testInsert() - START");
		assertTrue(srr.count()==0);
		getFakeSurveyReply();
		assertTrue(srr.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("SurveyReplyRepositoryTest.testSelectById() - START");
	//	SurveyReply currentSurveyReply = srr.save(getFakeSurveyReply());
		SurveyReply currentSurveyReply = getFakeSurveyReply();
		assertTrue(srr.findById(currentSurveyReply.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("SurveyReplyRepositoryTest.testUpdate() - START");
		SurveyReply currentSurveyReply = getFakeSurveyReply();
		currentSurveyReply.setAnswers("pippopippo");
		srr.save(currentSurveyReply);
		assertTrue(srr.findById(currentSurveyReply.getId()).isPresent());	
		assertTrue(srr.findById(currentSurveyReply.getId()).get().getAnswers().equals("pippopippo"));
	}
	
	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("SurveyReplyRepositoryTest.testDeleteById() - START");
		SurveyReply currentSurveyReply = getFakeSurveyReply();
    	assertTrue(srr.count()==1);
    	srr.deleteById(currentSurveyReply.getId());
    	assertTrue(srr.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll() {
		logger.info("SurveyReplyRepositoryTest.testDeleteAll() - START");
		getFakeSurveyReply();
    	assertTrue(srr.count()==1);
    	srr.deleteAll();
		assertTrue(srr.count()==0);
		logger.info("SurveyReplyRepositoryTest.testDeleteAll() - END");
	}
	
	/**
     * testGetSurveyReplyCountForDay()() method tests if the method getSurveyReplyCountForDay()
     * really works
     */

	@Test
	public void testGetSurveyReplyCountForDay() {
		logger.info("SurveyReplyRepositoryTest.testGetSurveyReplyCountForDay() - START");
		getFakeSurveyReply();
		assertTrue(srr.getSurveyReplyCountForDay(LocalDate.now())==1);
		logger.info("SurveyReplyRepositoryTest.testGetSurveyReplyCountForDay() - END");
	}
	
	
}