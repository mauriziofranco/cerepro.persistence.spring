package centauri.academy.cerepro.persistence.repository;

/**
 * @author jesus centauri milan academy5
 */
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import centauri.academy.cerepro.persistence.entity.Trainee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TraineeRepositoryTest extends AbstractRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(TraineeRepositoryTest.class);

	@Autowired
	private TraineeRepository tr;

	/**
	 * initializeUserTests() method inserts a new Role in order to be able to insert
	 * a new Role
	 */
	@Before
	@After
	public void initializeTraineeTests() {
		logger.info("TraineeRepositoryTest.initializeTraineeTests - START");
		tr.deleteAll();
		logger.info("TraineeRepositoryTest.initializeTraineeTests - END");
	}

	/**
	 * testSelectAllFilled() method tests if the method selectAll() is really able
	 * to select all tuples from a populated(with one entity) user table
	 */
	@Test
	public void testSelectAllFilled() {
		logger.info("TraineeRepositoryTest.testSelectAllFilled() - START");
		getFakeTrainee();
		assertTrue(tr.count() == 1);
		logger.info("TraineeRepositoryTest.testSelectAllFilled() - END");
	}

	/**
	 * testSelectAllEmpty() method tests if the method selectAll() is really able to
	 * select all tuples from a empty users' table
	 */
	@Test
	public void testSelectAllEmpty() {
		logger.info("TraineeRepositoryTest.testSelectAllEmpty() - START");
		assertTrue(tr.count() == 0);
		logger.info("TraineeRepositoryTest.testSelectAllEmpty() - END");
	}
	
	/**
	 * testSelectAllEmpty() method tests if the method selectAll() is really able to
	 * select all tuples from a empty users' table
	 */
	@Test
	public void testfindAll() {// findAll()
		logger.info("TraineeRepositoryTest.testSelectAllEmpty() - START");
		List <Trainee> trainees = tr.findAll();
		assertTrue(trainees.size() == 0);
		logger.info("TraineeRepositoryTest.testSelectAllEmpty() - END");
	}

	/**
	 * testInsert() method tests if the method insert() really works
	 */
	@Test
	public void testInsert() {// save()
		logger.info("TraineeRepositoryTest.testInsert() - START");
		assertTrue(tr.count() == 0);
		getFakeTrainee();
		assertTrue(tr.count() == 1);
		logger.info("TraineeRepositoryTest.testInsert() - END");
	}

	/**
	 * testSelectById() method tests if the method selectById() really works
	 */
	@Test
	public void testFindById() {//findById()
		logger.info("TraineeRepositoryTest.testSelectById() - START");
		Trainee currentTrainee = getFakeTrainee();
		assertTrue(tr.findById(currentTrainee.getId()).isPresent());
		logger.info("TraineeRepositoryTest.testSelectById() - END");
	}

	/**
	 * testUpdate() method tests if the method update() really works
	 */
	@Test
	public void testUpdate() {//save()
		logger.info("TraineeRepositoryTest.testUpdate() - START");
		Trainee currentTrainee = getFakeTrainee();
		currentTrainee.setPassword("pippopippo");
		tr.save(currentTrainee);
		assertTrue(tr.findById(currentTrainee.getId()).isPresent());
		assertTrue(tr.findById(currentTrainee.getId()).get().getPassword().equals("pippopippo"));
		logger.info("TraineeRepositoryTest.testUpdate() - END");
	}

	/**
	 * testDeleteById() method tests if the method deleteById() really works
	 */
	@Test
	public void testDeleteById() {//deleteById()
		logger.info("TraineeRepositoryTest.testDeleteById() - START");
		Trainee currentTrainee = getFakeTrainee();
		assertTrue(tr.count() == 1);
		tr.deleteById(currentTrainee.getId());
		assertTrue(tr.count() == 0);
		logger.info("TraineeRepositoryTest.testSelectAllFilled() - END");
	}

	/**
	 * testDeleteAll() method tests if the method deleteAll() really works
	 */
	@Test
	public void testDeleteAll() {//deleteAll()
		logger.info("TraineeRepositoryTest.testDeleteAll() - START");
		getFakeTrainee();
		assertTrue(tr.count() == 1);
		tr.deleteAll();
		assertTrue(tr.count() == 0);
		logger.info("TraineeRepositoryTest.testDeleteAll() - END");
	}
	
	/**
	 * testFindByEmail() method tests if the method testFindByEmail() really works
	 */
	@Test
	public void testFindByEmail() {//findByEmail()
		logger.info("TraineeRepositoryTest.testFindByEmail() - START");
		getFakeTrainee();
		assertTrue(tr.findByEmail("email@mail.com").isPresent());
		logger.info("TraineeRepositoryTest.testFindByEmail() - END");
	}
	
	/**
	 * testFindByEnabled() method tests if the method testFindByEnabled() really works
	 */
	@Test
	public void testFindByEnabled() {//findByEnabled
		logger.info("TraineeRepositoryTest.testFindByEnabled() - START");
		Trainee currentTrainee = getFakeTrainee();
		currentTrainee.setEnabled(0);
		tr.save(currentTrainee);
		assertTrue(tr.findByEnabled(0).isPresent());
		logger.info("TraineeRepositoryTest.testFindByEnabled() - END");
	}
	
	/**
	 * testFindFilled() method tests if the method testFindFilled() really works
	 */
	@Test
	public void testFindFilled() {//findFilled()
		logger.info("TraineeRepositoryTest.testFindFilled() - START");
		Trainee fakeTrainee = getFakeTrainee();
		fakeTrainee.setHaspassword(1);
		tr.save(fakeTrainee);
		Trainee currentTrainee = new Trainee();
		currentTrainee.setEmail("mail2@mail.com");
		currentTrainee.setPassword("password!");
		currentTrainee.setFirstname("Juan");
		currentTrainee.setLastname("Perez");
		currentTrainee.setHaspassword(0);
		tr.save(currentTrainee);
		// check if there are two entities in the table, fakeTrainee and currentTrainee
		assertTrue(tr.count()==2);
		// check if only currentTrainee is selected (haspassword = 0)
		assertTrue(tr.findByFilled().size()==1);
		logger.info("TraineeRepositoryTest.testFindFilled() - END");
	}

}