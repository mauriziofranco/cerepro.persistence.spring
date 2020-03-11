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

import centauri.academy.cerepro.persistence.entity.Interview;
import centauri.academy.cerepro.persistence.entity.Question;


/**
 * 
 * @author Fabio Li Greci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewRepositoryTest extends AbstractRepositoryTest{
	private static final Logger logger = LoggerFactory.getLogger(InterviewRepositoryTest.class);
	
	@Autowired
	private InterviewRepository ir;
	@Autowired
	private SurveyRepository sr;
	
	
	
	@Before
	@After
	public void initializeInterviewTests () {
		logger.info("InterviewRepositoryTest.initializeInterviewTests - START");
		
		ir.deleteAll();
		sr.deleteAll();
		logger.info("InterviewRepositoryTest.initializeInterviewTests - END");
	}
	
	@Test
    public void testSelectAllFilled(){
		logger.info("InterviewRepositoryTest.testSelectAllFilled() - START");
		getFakeInterview();
		assertTrue(ir.count() == 1);
		logger.info("InterviewRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
		logger.info("InterviewRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(ir.count()==0);
		logger.info("InterviewRepositoryTest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
		logger.info("InterviewRepositoryTest.testInsert() - START");
		assertTrue(ir.count()==0);
		getFakeInterview();
		assertTrue(ir.count()==1);
		logger.info("InterviewRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testSelectById() {
		logger.info("InterviewRepositoryTest.testSelectById() - START");
		
		Interview currentInterview = getFakeInterview();
		assertTrue(ir.findById(currentInterview.getId()).isPresent());	
		logger.info("InterviewRepositoryTest.testSelectById() - END");
	}
	
	@Test
	public void testUpdate() {
		logger.info("interviewRepositoryTest.testUpdate() - START");
		Interview currentInterview = getFakeInterview();
		currentInterview.setAnsa("interview's developer");
		ir.save(currentInterview);
		assertTrue(ir.findById(currentInterview.getId()).isPresent());	
		assertTrue((ir.findById(currentInterview.getId()).get().getAnsa().equals("interview's developer")));
		logger.info("interviewRepositoryTest.testUpdate() - END");
	}
	
	@Test
	public void testDeleteById() {
		logger.info("InterviewRepositoryTest.testDeleteById() - START");
		Interview currentInterview = getFakeInterview();
    	assertTrue(ir.count()==1);
    	ir.deleteById(currentInterview.getId());
    	assertTrue(ir.count()==0);
    	logger.info("InterviewRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
		logger.info("InterviewRepositoryTest.testDeleteAll() - START");
		getFakeInterview();
    	assertTrue(ir.count()==1);
    	ir.deleteAll();
		assertTrue(ir.count()==0);
		logger.info("InterviewRepositoryTest.testDeleteAll() - END");
	}
}
