package centauri.academy.cerepro.persistence.repository.usersurveytoken;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.UserTokenSurvey;

@Repository
public interface UserSurveyTokenRepository extends JpaRepository<UserTokenSurvey, Long>, UserSurveyTokenRepositoryCustom {

	List<UserTokenSurvey> findBySurveyId(long surveyId);
	UserTokenSurvey findByGeneratedtoken(String generatedtoken);
	List<UserTokenSurvey> findByUserId(long userId);
}
