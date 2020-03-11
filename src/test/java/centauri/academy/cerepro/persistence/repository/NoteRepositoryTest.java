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

import centauri.academy.cerepro.persistence.entity.NoteTemplate;
/**
 * @author marco morgana
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteRepositoryTest extends AbstractRepositoryTest  {

	private static final Logger logger = LoggerFactory.getLogger(NoteRepositoryTest.class);
	
	@Autowired
	private NoteTemplateRepository ntr;
	/**
	 * Provides to clean NoteTemplate table and all(previously) referenced tables:
     * in order to be able to execute tests.
     * Execute clean before and after each test
     */
	@Before
	@After
	public void initializeRoleTests () {
		logger.info("NoteRepositoryTest.initializeNoteTests - START");		
		ntr.deleteAll();
		logger.info("NoteRepositoryTest.initializeNoteTests - END");
	}

	/**
     * testSelectAllFilled() method tests if the method selectAll()
     * is really able to select all tuples from a populated(with one entity)
     * NoteTemplate table
     */
	@Test
    public void testSelectAllFilled(){
		logger.info("NoteRepositoryTest.testSelectAllFilled() - START");
		getFakeNoteTemplate();
		assertTrue(ntr.count() == 1);
    }
    
    /**
     * testSelectAllEmpty() method tests if the method selectAll()
     * is really able to select all tuples from a empty
     * roles' table
     */
	@Test
    public void testSelectAllEmpty(){
		logger.info("NoteRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(ntr.count()==0);
    }

	/**
     * testInsert() method tests if the method insert()
     * really works
     */
	@Test
	public void testInsert() {
		logger.info("NoteRepositoryTest.testInsert() - START");
		assertTrue(ntr.count()==0);
		getFakeNoteTemplate();
		assertTrue(ntr.count()==1);
	}

	/**
     * testSelectById() method tests if the method selectById()
     * really works
     */
	@Test
	public void testSelectById() {
		logger.info("NoteRepositoryTest.testSelectById() - START");
		NoteTemplate currentNote = getFakeNoteTemplate();
		assertTrue(ntr.findById(currentNote.getId()).isPresent());		
	}
	
	/**
     * testUpdate() method tests if the method update()
     * really works
     */
	@Test
	public void testUpdate() {
		logger.info("NoteRepositoryTest.testUpdate() - START");
		NoteTemplate currentNote = getFakeNoteTemplate();
		currentNote.setTitle("El Machico");
		ntr.save(currentNote);
		assertTrue(ntr.findById(currentNote.getId()).isPresent());	
		assertTrue((ntr.findById(currentNote.getId()).get().getTitle().equals("El Machico")));
	}

	/**
     * testDeleteById() method tests if the method deleteById()
     * really works
     */
	@Test
	public void testDeleteById() {
		logger.info("NoteRepositoryTest.testDeleteById() - START");
		NoteTemplate currentNote = getFakeNoteTemplate();
    	assertTrue(ntr.count()==1);
    	ntr.deleteById(currentNote.getId());
    	assertTrue(ntr.count()==0);
	}
	
	/**
     * testDeleteAll() method tests if the method deleteAll()
     * really works
     */
	@Test
	public void testDeleteAll () {
		logger.info("NoteRepositoryTest.testDeleteAll() - START");
		getFakeNoteTemplate();
    	assertTrue(ntr.count()==1);
    	ntr.deleteAll();
		assertTrue(ntr.count()==0);
		logger.info("NoteRepositoryTest.testDeleteAll() - END");
	}
}