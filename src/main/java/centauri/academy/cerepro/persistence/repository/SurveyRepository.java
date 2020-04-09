package centauri.academy.cerepro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import centauri.academy.cerepro.persistence.entity.Survey;


/**
 * Provides a repository for the Survey entity
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
	
	

}