package centauri.academy.cerepro.persistence.repository.surveyquestion;
/**
 * 
 * @author joffre
 *
 */
import java.util.List;

import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.SurveyQuestionCustom;

@Repository
public interface SurveyQuestionRepositoryCustom {

	List<SurveyQuestionCustom> getAllCustomSurveyQuestion() ;
	
}