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

import centauri.academy.cerepro.persistence.entity.custom.CandidateSurveyTokenCustom;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;
import centauri.academy.cerepro.persistence.repository.candidatesurveytoken.CandidateSurveyTokenRepository;

/**
 * Unit test for CandidateSurveyTokenCustomRepository
 * @author maurizio.franco@ymail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateSurveyTokenCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CandidateSurveyTokenCustomRepositoryTest.class);
	
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private SurveyRepository sr;
	@Autowired
	private CandidateSurveyTokenRepository candidateSurveyTokenRepository;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private CandidateStatesRepository csr;
	
    /**
     * prepareDB method prepares the database in order to test
     * CandidateRepository's methods
     */
	@Before
	@After
	public void prepareDB () {
		logger.info(" START -> prepareDB() ");
		candidateSurveyTokenRepository.deleteAll();		
		cr.deleteAll();
		ur.deleteAll();
		csr.deleteAll();
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
		getFakeCandidateSurveyToken();
		
		List<CandidateSurveyTokenCustom> candidateSurveyTokenCustomList = candidateSurveyTokenRepository.getAllCustomCandidateSurveyToken();
		for (CandidateSurveyTokenCustom current : candidateSurveyTokenCustomList) logger.info("current userSurveyTokenCustom: " + current.toString());
		assertTrue(candidateSurveyTokenRepository.getAllCustomCandidateSurveyToken().size() == 1);		
		logger.info(" END -> selectAllFilled() ");
    }
}