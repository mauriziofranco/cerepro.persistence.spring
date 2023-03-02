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

import centauri.academy.cerepro.persistence.entity.UserTokenSurvey;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;
import centauri.academy.cerepro.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;
import centauri.academy.cerepro.persistence.repository.usersurveytoken.UserSurveyTokenRepository;

/**
 * 
 * Provides a repository test class to test repository methods
 * 
 * @author Anna
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSurveyTokenRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(UserSurveyTokenRepositoryTest.class);
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private UserSurveyTokenRepository ustr;
	@Autowired
	private CandidateSurveyTokenRepository cstr;
	@Autowired
	private CandidateStatesRepository csr;
	
    /**
     * 
     * 
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		cstr.deleteAll();
		ustr.deleteAll();
		cr.deleteAll();
		sr.deleteAll();
		ur.deleteAll();
		csr.deleteAll();
		rr.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

    /**
     * 
     * 
     * 
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeUserTokenSurvey();
		assertTrue(ustr.count() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
    /**
     * 
     *
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info(" START -> selectAllEmpty() ");
		assertTrue(ustr.count()==0);
		logger.info(" END -> selectAllEmpty() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testSelectById(){
		logger.info(" START -> selectById() ");
		UserTokenSurvey currentUserSurveyToken = getFakeUserTokenSurvey();
		assertTrue(ustr.findById(currentUserSurveyToken.getId()).isPresent());
		logger.info(" END -> selectById() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testInsert(){
		logger.info(" START -> insert() ");
		assertTrue(ustr.count()==0);
		getFakeUserTokenSurvey();
		assertTrue(ustr.count()==1);
		logger.info(" END -> insert() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testUpdate(){
		logger.info(" START -> update() ");
		UserTokenSurvey currentUserSurveyToken = getFakeUserTokenSurvey();
		currentUserSurveyToken.setGeneratedtoken("newPath");
		ustr.save(currentUserSurveyToken);
		assertTrue(ustr.findById(currentUserSurveyToken.getId()).isPresent());	
		assertTrue((ustr.findById(currentUserSurveyToken.getId()).get().getGeneratedtoken().equals("newPath")));
		logger.info(" END -> update() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testDeleteAll(){
		logger.info(" START -> deleteAll() ");
		getFakeUserTokenSurvey();
    	assertTrue(ustr.count()==1);
    	ustr.deleteAll();
		assertTrue(ustr.count()==0);
		logger.info(" END -> deleteAll() ");
    }
    
    /**
     * 
     * 
     */
	@Test
    public void testDeleteById(){
		logger.info(" START -> deleteById() ");
		UserTokenSurvey currentUserSurveyToken = getFakeUserTokenSurvey();
    	assertTrue(ustr.count()==1);
    	ustr.deleteById(currentUserSurveyToken.getId());
    	assertTrue(ustr.count()==0);
		logger.info(" END -> deleteById() ");
    }

}