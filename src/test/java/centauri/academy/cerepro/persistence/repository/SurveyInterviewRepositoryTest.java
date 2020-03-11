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

import centauri.academy.cerepro.persistence.entity.SurveyInterview;
import centauri.academy.cerepro.persistence.entity.SurveyQuestion;

/**
 * @author Fabio Li Greci
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyInterviewRepositoryTest extends AbstractRepositoryTest{
	
	public static final Logger logger = LoggerFactory.getLogger(SurveyInterviewRepositoryTest.class);
	private SurveyInterviewRepositoryTest surveyInterviewRepository;
	@Autowired
	private SurveyInterviewRepository sir;	
	@Autowired
	private SurveyRepository sr;	
	@Autowired
	private InterviewRepository ir;
	
	@Before
	@After
    public void prepareDB() {
    	logger.info("SurveyInterviewTest.initializeSurveyInterviewTests - START");	
		sir.deleteAll();
		sr.deleteAll();
		ir.deleteAll();	
		logger.info("SurveyInterviewRepositoryTest.initializeSurveyInterviewTests - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(sir.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
	
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		SurveyInterview currentSI = getFakeSurveyInterview();
		assertTrue(sir.findById(currentSI.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
	
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(sir.count()==0);
		getFakeSurveyInterview();
		assertTrue(sir.count()==1);
		logger.info(" END -> insert() ");
    }
	
	@Test
    public void testUpdate(){
		logger.info("SurveyInterviewRepositoryTest.testUpdate() START -> update() ");
		SurveyInterview currentSI = getFakeSurveyInterview();
    	currentSI.setPosition(100);
		sir.save(currentSI);
		assertTrue(sir.findById(currentSI.getId()).isPresent());	
		assertTrue((sir.findById(currentSI.getId()).get().getPosition()==(100L)));
		logger.info(" END -> update() ");
    }
	
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeSurveyInterview();
    	assertTrue(sir.count()==1);
    	sir.deleteAll();
		assertTrue(sir.count()==0);
		logger.info(" END -> deleteAll() ");
    }
	
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		SurveyInterview currentSI = getFakeSurveyInterview();
    	assertTrue(sir.count()==1);
    	sir.deleteById(currentSI.getId());
    	assertTrue(sir.count()==0);
		logger.info(" END -> deleteById() ");
    }
	
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeSurveyInterview();
		assertTrue(sir.count() == 1);
		logger.info(" END -> selectAllFilled() ");
    }

}
