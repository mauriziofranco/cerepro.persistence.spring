//package centauri.academy.cerepro.persistence.repository;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import centauri.academy.cerepro.persistence.entity.CourseResume;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CourseResumeRepositoryTest extends AbstractRepositoryTest {
//
//	private static final Logger logger = LoggerFactory.getLogger(CourseResumeRepositoryTest.class);
//	
//	@Autowired
//	private CourseResumeRepository crr;
//
//	/**
//     * initializeCourseResumeTests() method inserts a new CoursePage code
//     * in order to be able to insert a new CourseResume
//     */
//	@Before
//	@After
//    public void initializeCourseResumeTests() {	
//    	logger.info("CourseResumeRepositoryTest.initializeCourseResumeTests - START");	
//		crr.deleteAll();
//		logger.info("CourseResumeRepositoryTest.initializeCourseResumeTests - END");
//    }
//
//	/**
//     * testSelectAllFilled() method tests if the method selectAll()
//     * is really able to select all tuples from a populated(with one entity)
//     * CourseResume table
//     */
//	@Test
//    public void testSelectAllFilled(){
//		logger.info("CourseResumeRepositoryTest.testSelectAllFilled() - START");
//		getFakeCourseResume();
//		assertTrue(crr.count() == 1);
//    }
//    
//    /**
//     * testSelectAllEmpty() method tests if the method selectAll()
//     * is really able to select all tuples from a empty
//     * CourseResumes' table
//     */
//	@Test
//    public void testSelectAllEmpty(){	
//		logger.info("CourseResumeRepositoryTest.testSelectAllEmpty() - START");
//		assertTrue(crr.count()==0);
//    }
//   
//	/**
//     * testInsert() method tests if the method insert()
//     * really works
//     */
//	@Test
//	public void testInsert() {
//		logger.info("CourseResumeRepositoryTest.testInsert() - START");
//		assertTrue(crr.count()==0);
//		getFakeCourseResume();
//		assertTrue(crr.count()==1);
//	}
//
//	/**
//     * testSelectById() method tests if the method selectById()
//     * really works
//     */
//	@Test
//	public void testSelectById() {
//		logger.info("CourseResumeRepositoryTest.testSelectById() - START");
//		CourseResume currentCourseResume = getFakeCourseResume();
//		assertTrue(crr.findById(currentCourseResume.getId()).isPresent());		
//	}
//	
//	/**
//     * testUpdate() method tests if the method update()
//     * really works
//     */
//	@Test
//	public void testUpdate() {
//		logger.info("CourseResumeRepositoryTest.testUpdate() - START");
//		CourseResume currentCourseResume = getFakeCourseResume();
//		currentCourseResume.setTitle("titleUPDATE");
//		crr.save(currentCourseResume);
//		assertTrue(crr.findById(currentCourseResume.getId()).isPresent());	
//		assertTrue(crr.findById(currentCourseResume.getId()).get().getTitle().equals("titleUPDATE"));
//	}
//	
//	/**
//     * testDeleteById() method tests if the method deleteById()
//     * really works
//     */
//	@Test
//	public void testDeleteById() {
//		logger.info("CourseResumeRepositoryTest.testDeleteById() - START");
//		CourseResume currentCourseResume = getFakeCourseResume();
//    	assertTrue(crr.count()==1);
//    	crr.deleteById(currentCourseResume.getId());
//    	assertTrue(crr.count()==0);
//	}
//	
//	/**
//     * testDeleteAll() method tests if the method deleteAll()
//     * really works
//     */
//	@Test
//	public void testDeleteAll () {
//		logger.info("CourseResumeRepositoryTest.testDeleteAll() - START");
//		getFakeCourseResume();
//    	assertTrue(crr.count()==1);
//    	crr.deleteAll();
//		assertTrue(crr.count()==0);
//		logger.info("CourseResumeRepositoryTest.testDeleteAll() - END");
//	}
//	
//	/**
//     * testPageSelectAllFilled() method tests if the method selectAll() 
//     * with pageable option
//     * is really able to select all tuples from a populated
//     * CourseResume table
//     */
//	@Test
//    public void testPageSelectAllFilled(){
//		logger.info("CourseResumeRepositoryTest.testPageSelectAllFilled() - START");
//		getFakeCourseResume();
//		Page<CourseResume> currentPage = crr.findAll(PageRequest.of(0, 5, Sort.Direction.ASC, "title"));
//		assertTrue(currentPage.getNumberOfElements() == 1);
//    }
//	
//	/**
//     * testPageSelectAllFilledFail() method tests if the method selectAll() 
//     * with pageable option
//     * is really able to select all tuples from a populated
//     * CourseResume table
//     */
//	@Test
//    public void testPageSelectAllFilledFail(){
//		logger.info("CourseResumeRepositoryTest.testPageSelectAllFilledFail() - START");
//		getFakeCourseResume();
//		Page<CourseResume> currentPage = crr.findAll(PageRequest.of(1, 5, Sort.Direction.ASC, "title"));
//		assertTrue(currentPage.getNumberOfElements() == 0);
//    }
//
//}