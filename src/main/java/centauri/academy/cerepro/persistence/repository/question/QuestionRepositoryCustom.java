package centauri.academy.cerepro.persistence.repository.question;

import java.util.List;

import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.custom.QuestionCustom;

/**
 * 
 * Provides a repository interface to provides other methods signatures to Question repository
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public interface QuestionRepositoryCustom {

	/**
	 * extract questions form question table more position field from surveyquestions table and fit into a QuestionCustom Object
	 * @param surveyId
	 * @return
	 */
	List<QuestionCustom> findBySurveyId(long surveyId);
	
}