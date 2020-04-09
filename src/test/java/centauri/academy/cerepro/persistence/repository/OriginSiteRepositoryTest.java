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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.OriginSite;
import centauri.academy.cerepro.persistence.repository.originsite.OriginSiteRepository;
/**
 * 
 * Provides a repository test class to test repository methods
 * 
 * @author Centauri Academy
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OriginSiteRepositoryTest extends AbstractRepositoryTest  {

	private static final Logger logger = LoggerFactory.getLogger(OriginSiteRepositoryTest.class);
	
	@Autowired
	private OriginSiteRepository osr;

	/**
	 * few tests for OriginSite Repository
     */
	@Before
	@After
	public void initializeOriginSiteTests () {
		logger.info("OriginSiteRepositoryTest.initializeOriginSiteTests - START");		
		osr.deleteAll();
		logger.info("OriginSiteRepositoryTest.initializeOriginSiteTests - END");
	}

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * OriginSite table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("OriginSiteRepositoryTest.testSelectAllFilled() - START");
		getFakeOriginSite();
		assertTrue(osr.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * OriginSites' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info("OriginSiteRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(osr.count()==0);
    }

	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("OriginSiteRepositoryTest.testInsert() - START");
		assertTrue(osr.count()==0);
		getFakeOriginSite();
		assertTrue(osr.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("OriginSiteRepositoryTest.testSelectById() - START");
		OriginSite currentOriginSite = getFakeOriginSite();
		assertTrue(osr.findById(currentOriginSite.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("OriginSiteRepositoryTest.testUpdate() - START");
		OriginSite currentOriginSite = getFakeOriginSite();
		currentOriginSite.setLabel("LABEL DIVERSA!!!");
		osr.save(currentOriginSite);
		assertTrue(osr.findById(currentOriginSite.getId()).isPresent());	
		assertTrue((osr.findById(currentOriginSite.getId()).get().getLabel().equals("LABEL DIVERSA!!!")));
	}

	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("OriginSiteRepositoryTest.testDeleteById() - START");
		OriginSite currentOriginSite = getFakeOriginSite();
    	assertTrue(osr.count()==1);
    	osr.deleteById(currentOriginSite.getId());
    	assertTrue(osr.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("OriginSiteRepositoryTest.testDeleteAll() - START");
		getFakeOriginSite();
    	assertTrue(osr.count()==1);
    	osr.deleteAll();
		assertTrue(osr.count()==0);
		logger.info("OriginSiteRepositoryTest.testDeleteAll() - END");
	}
	
//	@Test
//    public void testSelectAllFullAndRightOrdered(){
//		logger.info(" START -> selectAllEmpty() ");
//		assertTrue(osr.count()==0);
//		getFakeOriginSite();
//		assertTrue(osr.count()==1);
//		getFakeOriginSite();
//		assertTrue(osr.count()==2);
//		Page<OriginSite>  currentPage = osr.findAll(PageRequest.of(0, 10));
//		assertTrue(currentPage.getTotalElements()==2);
//		OriginSite first = currentPage.getContent().get(0);
//		logger.info(" DEBUG - first.getId().longValue(): " + first.getId().longValue());
//		OriginSite second = currentPage.getContent().get(1);
//		logger.info(" DEBUG - second.getId().longValue(): " + second.getId().longValue());
//		assertTrue(first.getId().longValue()>second.getId().longValue());
//		logger.info(" END -> testSelectAllFullAndRightOrdered() ");
//    }
}