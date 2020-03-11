package centauri.academy.cerepro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import centauri.academy.cerepro.persistence.entity.Question;

/**
 * QuestionRepository with SpringBoot
 * 
 * It allows the management of the question table, through insert, delete,
 * update and insert question The connection with Database is made by ConfigDB
 * java class
 * 
 * @author daniele piccinni
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	List<Question> findByLabel(String label);
}
