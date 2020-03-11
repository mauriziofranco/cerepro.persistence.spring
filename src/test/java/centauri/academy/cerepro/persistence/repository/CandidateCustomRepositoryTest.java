package centauri.academy.cerepro.persistence.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.CandidateCustom;
import centauri.academy.cerepro.persistence.repository.candidate.CandidateRepository;

/**
 * Unit test for CandidateCustomRepository
 * @author m.franco
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CandidateCustomRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CandidateCustomRepositoryTest.class);
	@Autowired
	private RoleRepository rr;
	@Autowired
	private UserRepository ur;
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private CoursePageRepository cpr;
	@Autowired
	private CourseResumeRepository crr;
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
		crr.deleteAll();
		cr.deleteAll();
		cpr.deleteAll();
		csr.deleteAll();
		ur.deleteAll();
		rr.deleteAll();
		logger.info(" END -> prepareDB() ");
	}

//    /**
//     * testSelectAllFilled() method tests if the method selectAll()
//     * is really able to select all tuples from a populated
//     * candidates' table
//     */
//	@Test
//    public void testSelectAllFilled(){
//		logger.info(" START -> selectAllFilled() ");
//		logger.info(" DEBUG XXX fakeCandidate: " + getFakeCandidate());
//		List<CandidateCustom> ccList = cr.getAllCustomCandidates();
//		logger.info("testSelectAllFilled - DEBUG - getAllCustomCandidates returns: " + ccList + " elements");
////		for (CandidateCustom current : ccList) logger.info("current candidate custom: " + current.toString());
//		assertTrue(cr.getAllCustomCandidates().size() == 1);
//		logger.info(" END -> selectAllFilled() ");
//    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * candidates' table
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
		Candidate currentCandidate = getFakeCandidate();
		logger.info(" testSelectById -> {}", currentCandidate);
		CandidateCustom currentCandidateCustom = cr.getSingleCustomCandidate(currentCandidate.getId());
		logger.info("current candidate custom  " + currentCandidateCustom);
		assertTrue( currentCandidateCustom != null ); 
		logger.info(" END -> selectById() ");
    }
	
	/**
	 * Commented because getAllCustomCandidatesPaginated no more used or used by the Backoffice Application just dismissed
	 * 
	 * 
     * testSelectAllFullAndRightOrdered() method tests if the method getAllCustomCandidatesPaginated() return the full list of the candidates in the correct order by candidacy time!!!!
     * really returns items in the right order
     *      
     */
//	@Test
//    public void testSelectAllFullAndRightOrdered(){
//		logger.info(" START -> selectAllEmpty() ");
//		assertTrue(cr.count()==0);
//		LocalDateTime ldtNow = LocalDateTime.now();
//		getFakeCandidateByCandidacyTime(ldtNow);
//		assertTrue(cr.count()==1);
//		LocalDateTime ldtYesterday = LocalDateTime.now().minusDays(1);
//		getFakeCandidateByCandidacyTime(ldtYesterday);
//		assertTrue(cr.count()==2);
//		Page<CandidateCustom>  currentPage = cr.getAllCustomCandidatesPaginated(PageRequest.of(0, 10));
//		assertTrue(currentPage.getTotalElements()==2);
//		CandidateCustom first = currentPage.getContent().get(0);
//		logger.info(" DEBUG - first.getId().longValue(): " + first.getId().longValue() + " - candidacyTime:"  );
//		CandidateCustom second = currentPage.getContent().get(1);
//		logger.info(" DEBUG - second.getId().longValue(): " + second.getId().longValue() + " - candidacyTime:" );
//		assertTrue(first.getId().longValue()>second.getId().longValue());
//		logger.info(" END -> testSelectAllFullAndRightOrdered() ");
//    }
	
	
	/**
	 * 
     * This method tests the getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode) method called by 
     * the SkillViewHr frontend to list candidates.
     * It tests normal functionality and that the candidates list is ordered by the candidacy_date_time
     * 
     * @author maurizio.franco
     */
	@Test
    public void testSelectAllCandidatesPaginatedByCourseCode(){
		logger.info("START --> testSelectAllCandidatesPaginatedByCourseCode() ");
		assertTrue(cr.count()==0);
		String courseCode = getFakeCoursePage().getCode();
		LocalDateTime ldtNow = LocalDateTime.now();
		getFakeCandidateByCandidacyTimeAndCourseCode(ldtNow, courseCode);
		assertTrue(cr.count()==1);
		LocalDateTime ldtYesterday = LocalDateTime.now().minusDays(1);
		getFakeCandidateByCandidacyTimeAndCourseCode(ldtYesterday, courseCode);
		assertTrue(cr.count()==2);
		Page<CandidateCustom>  currentPage = cr.getAllCustomCandidatesPaginatedByCourseCode(PageRequest.of(0, 10), courseCode);
		assertTrue(currentPage.getTotalElements()==2);
		CandidateCustom first = currentPage.getContent().get(0);
		logger.info(" DEBUG - first.getId().longValue(): " + first.getId().longValue() + " - candidacyTime:"  );
		CandidateCustom second = currentPage.getContent().get(1);
		logger.info(" DEBUG - second.getId().longValue(): " + second.getId().longValue() + " - candidacyTime:" );
		assertTrue(first.getId().longValue()<second.getId().longValue());
		logger.info(" END --> testSelectAllCandidatesPaginatedByCourseCode() ");
    }

}
