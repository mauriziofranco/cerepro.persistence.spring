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

import centauri.academy.cerepro.persistence.entity.CandidateSurveyToken;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;
import centauri.academy.cerepro.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;

/**
 * 
 * Provides a repository test class to test repository methods
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateSurveyTokenRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenRepositoryTest.class);
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private CandidateSurveyTokenRepository cstr;
	@Autowired
	private CandidateStatesRepository csr;
	
    /**
     * 
     * 
     */
//	@Before
//	@After
//	public void prepareDB () {
//		logger.info(" START -> prepareDB() ");
//		cstr.deleteAll();
//		cr.deleteAll();
//		sr.deleteAll();
//		ur.deleteAll();
//		csr.deleteAll();
//		rr.deleteAll();
//		logger.info(" END -> prepareDB() ");
//	}

    /**
     * 
     * 
     * 
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeCandidateSurveyToken();
		assertTrue(cstr.count() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
    /**
     * 
     *
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(cstr.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		CandidateSurveyToken currentCandidateSurveyToken = getFakeCandidateSurveyToken();
		assertTrue(cstr.findById(currentCandidateSurveyToken.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(cstr.count()==0);
		getFakeCandidateSurveyToken();
		assertTrue(cstr.count()==1);
		logger.info(" END -> insert() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testUpdate(){
		logger.info(" START -> update() ");
		CandidateSurveyToken currentCandidateSurveyToken = getFakeCandidateSurveyToken();
		currentCandidateSurveyToken.setGeneratedToken("newPath");
		cstr.save(currentCandidateSurveyToken);
		assertTrue(cstr.findById(currentCandidateSurveyToken.getId()).isPresent());	
		assertTrue((cstr.findById(currentCandidateSurveyToken.getId()).get().getGeneratedToken().equals("newPath")));
		logger.info(" END -> update() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeCandidateSurveyToken();
    	assertTrue(cstr.count()==1);
    	cstr.deleteAll();
		assertTrue(cstr.count()==0);
		logger.info(" END -> deleteAll() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		CandidateSurveyToken currentCandidateSurveyToken = getFakeCandidateSurveyToken();
    	assertTrue(cstr.count()==1);
    	cstr.deleteById(currentCandidateSurveyToken.getId());
    	assertTrue(cstr.count()==0);
		logger.info(" END -> deleteById() ");
    }

}