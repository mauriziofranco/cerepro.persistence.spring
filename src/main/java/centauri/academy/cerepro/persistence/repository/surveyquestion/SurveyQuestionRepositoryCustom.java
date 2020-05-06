package centauri.academy.cerepro.persistence.repository.surveyquestion;
/**
 * 
 * @author joffre
 *
 */
import java.util.List;

import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.custom.SurveyQuestionCustom;

/**
 * 
 * Provides a repository interface to provides other methods signatures to SurveyQuestion repository
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface SurveyQuestionRepositoryCustom {

	List<SurveyQuestionCustom> getAllCustomSurveyQuestion() ;
	
}