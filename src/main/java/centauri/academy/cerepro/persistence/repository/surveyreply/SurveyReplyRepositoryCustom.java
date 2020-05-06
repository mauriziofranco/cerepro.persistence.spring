package centauri.academy.cerepro.persistence.repository.surveyreply;


import java.time.LocalDate;
import java.util.List;

import centauri.academy.cerepro.persistence.entity.custom.UserSurveyTokenCustom;

/**
 * SurveyReplyRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 *
 */
public interface SurveyReplyRepositoryCustom  {

	long getSurveyReplyCountForDay(LocalDate day) ;
	
	
	

}
