package centauri.academy.cerepro.persistence.repository.usersurveytoken;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import centauri.academy.cerepro.persistence.entity.UserSurveyTokenCustom;

/**
 * UserSurveyTokenRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 * 
 * @author joffre
 * @author Daniele Piccinni
 * @author giacomo
 */
public interface UserSurveyTokenRepositoryCustom  {

	List<UserSurveyTokenCustom> getAllCustomUserTokenSurvey() ;
	
//	List<UserSurveyTokenCustom> getAllCustomUserTokenSurveyExpired() ;
//	
//	List<UserSurveyTokenCustom> getAllCustomUserTokenSurveyActive() ;
	
	Page<UserSurveyTokenCustom> getAllCustomUserTokenSurveyPaginated(Pageable info, Boolean situation);

}
