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
import centauri.academy.cerepro.persistence.entity.CoursePage;

/**
 * 
 * @author TraianC - Milano Centauri Academy III
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursePageRepositoryTest extends AbstractRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CoursePageRepositoryTest.class);
	
	@Autowired
	private CoursePageRepository cpr;
	
	@Before
	@After
    public void initializeCoursePageTest() {
    	logger.info("CoursePageRepositoryTest.initializeCoursePageTest - START");    	
    	cpr.deleteAll();
		logger.info("CoursePageRepositoryTest.initializeCoursePageTest - END");
    }
	
	@Test
    public void testSelectAllFilled(){
    	logger.info("CoursePageRepositoryTest.testSelectAllFilled() - START");    	
    	getFakeCoursePage();
    	assertTrue(cpr.count() == 1);
    	logger.info("CoursePageRepositoryTest.testSelectAllFilled() - END");
    }
	
	@Test
    public void testSelectAllEmpty(){
    	logger.info("CoursePageRepositoryTest.testSelectAllEmpty() - START");    	
		assertTrue(cpr.count()==0);
		logger.info("CoursePageRepositoryTest.testSelectAllEmpty() - END");
    }
	
	@Test
	public void testInsert() {
    	logger.info("CoursePageRepositoryTest.testInsert() - START");    	
		assertTrue(cpr.count()==0);
		getFakeCoursePage();
		assertTrue(cpr.count()==1);
		logger.info("CoursePageRepositoryTest.testInsert() - END");
	}
	
	@Test
	public void testSelectById() {
    	logger.info("CoursePageRepositoryTest.testSelectById() - START");    	
    	CoursePage currentCoursePage = getFakeCoursePage();
		assertTrue(cpr.findById(currentCoursePage.getId()).isPresent());	
		logger.info("CoursePageRepositoryTest.testSelectById() - END");
	}
	
	@Test
	public void testSelectByCodeOk() {
    	logger.info("CoursePageRepositoryTest.testSelectByCodeOk() - START");
    	int random = (int)(Math.random() * 10000);
    	String code = "test_code_" + random ;
    	getFakeCoursePageWithCode(code);
		assertTrue(cpr.findByCode(code)!=null);	
		logger.info("CoursePageRepositoryTest.testSelectByCodeOk() - END");
	}
	
	@Test
	public void testSelectByCodeKo() {
    	logger.info("CoursePageRepositoryTest.testSelectByCodeKo() - START");
    	int random = (int)(Math.random() * 10000);
    	String code = "test_code_" + random ;
    	String fakeCode = code + "X" ;
    	getFakeCoursePageWithCode(code);
		assertTrue(cpr.findByCode(fakeCode)==null);	
		logger.info("CoursePageRepositoryTest.testSelectByCodeKo() - END");
	}
	
	@Test
	public void testUpdate() {
		logger.info("CoursePageRepositoryTest.testUpdate() - START");
		CoursePage currentCoursePage = getFakeCoursePage();
		currentCoursePage.setFileName("testUpdate");
		cpr.save(currentCoursePage);
		assertTrue(cpr.findById(currentCoursePage.getId()).isPresent());	
		assertTrue(cpr.findById(currentCoursePage.getId()).get().getFileName().equals("testUpdate"));
	}
	@Test
	public void testDeleteById() {
    	logger.info("CoursePageRepositoryTest.testDeleteById() - START");    	
    	CoursePage currentCoursePage = getFakeCoursePage();
    	assertTrue(cpr.count()==1);
    	cpr.deleteById(currentCoursePage.getId());
    	assertTrue(cpr.count()==0);
    	logger.info("CoursePageRepositoryTest.testDeleteById() - END");
	}
	
	@Test
	public void testDeleteAll () {
    	logger.info("CoursePageRepositoryTest.testDeleteAll() - START");    	
    	getFakeCoursePage();
    	assertTrue(cpr.count()==1);
    	cpr.deleteAll();
		assertTrue(cpr.count()==0);
		logger.info("CoursePageRepositoryTest.testDeleteAll() - END");
	}

}
