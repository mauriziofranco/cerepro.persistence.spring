package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.UserSurveyTokenCustom;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;
import centauri.academy.cerepro.persistence.repository.usersurveytoken.UserSurveyTokenRepository;

/**
 * Unit test for UserSurveyTokenCustomRepository
 * @author joffre
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSurveyTokenCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(UserSurveyTokenCustomRepositoryTest.class);
	
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private UserSurveyTokenRepository userSurveyTokenRepository;
	@Autowired
	private CandidateRepository cr;
	
    /**
     * prepareDB method prepares the database in order to test
     * CandidateRepository's methods
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		userSurveyTokenRepository.deleteAll();
		cr.deleteAll();
		ur.deleteAll();
		rr.deleteAll();
		sr.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

    /**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated
     * candidates' table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info(" START -> selectAllFilled() ");
		getFakeUserTokenSurvey();
		
		List<UserSurveyTokenCustom> userSurveyTokenCustomList = userSurveyTokenRepository.getAllCustomUserTokenSurvey();
		for (UserSurveyTokenCustom current : userSurveyTokenCustomList) logger.info("current userSurveyTokenCustom: " + current.toString());
		assertTrue(userSurveyTokenRepository.getAllCustomUserTokenSurvey().size() == 1);
		logger.info(" END -> selectAllFilled() ");
    }
    
//    /**
//     * testSelectAllEmpty() method tests if the method selectAll()
//     * is really able to select all tuples from a empty
//     * candidates' table
//     */
//	@Test
//    public void testSelectAllEmpty(){
//		logger.info(" START -> selectAllEmpty() ");
//		assertTrue(cr.count()==0);
//		logger.info(" END -> selectAllEmpty() ");
//    }
//    
//    /**
//     * testSelectById() method tests if the method selectById()
//     * really works
//     */
//	@Test
//    public void testSelectById(){
//		logger.info(" START -> selectById() ");
//		Candidate currentCandidate = getFakeCandidate();
//		assertTrue(cr.findById(currentCandidate.getId()).isPresent());
//		logger.info(" END -> selectById() ");
//    }
    
//	/**
//     * testGetAllCustomUserTokenSurveyExpired() method tests if the method getAllCustomUserTokenSurveyExpired()
//     * is really able to select all tuples from a populated
//     * candidates' table
//     */
//	@Test
//    public void testGetAllCustomUserTokenSurveyExpired(){
//		logger.info(" START -> testGetAllCustomUserTokenSurveyExpired() ");
//		getFakeUserTokenSurveyExpired();
//		getFakeUserTokenSurvey();
//		
//		List<UserSurveyTokenCustom> userSurveyTokenCustomList = userSurveyTokenRepository.getAllCustomUserTokenSurveyExpired();
//		for (UserSurveyTokenCustom current : userSurveyTokenCustomList) logger.info("current userSurveyTokenCustom: " + current.toString());
//		assertTrue(userSurveyTokenCustomList.size() == 1);
//		logger.info(" END -> testGetAllCustomUserTokenSurveyExpired() ");
//    }
	
//	/**
//     * testGetAllCustomUserTokenSurveyActive() method tests if the method getAllCustomUserTokenSurveyActive()
//     * is really able to select all tuples from a populated
//     * candidates' table
//     */
//	@Test
//    public void testGetAllCustomUserTokenSurveyActive(){
//		logger.info(" START -> testGetAllCustomUserTokenSurveyActive() ");
//		getFakeUserTokenSurveyExpired();
//		getFakeUserTokenSurvey();
//		
//		List<UserSurveyTokenCustom> userSurveyTokenCustomList = userSurveyTokenRepository.getAllCustomUserTokenSurveyActive();
//		for (UserSurveyTokenCustom current : userSurveyTokenCustomList) logger.info("current userSurveyTokenCustom: " + current.toString());
//		assertTrue(userSurveyTokenCustomList.size() == 1);
//		logger.info(" END -> testGetAllCustomUserTokenSurveyActive() ");
//    }
}
