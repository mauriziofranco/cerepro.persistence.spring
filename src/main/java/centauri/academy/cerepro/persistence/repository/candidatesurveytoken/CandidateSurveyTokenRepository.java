package centauri.academy.cerepro.persistence.repository.candidatesurveytoken;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.CandidateSurveyToken;

/**
 * 
 * Provides a repository for the UserSurveyToken entity
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public interface CandidateSurveyTokenRepository extends JpaRepository<CandidateSurveyToken, Long>, CandidateSurveyTokenRepositoryCustom {

	List<CandidateSurveyToken> findBySurveyId(long surveyId);
	CandidateSurveyToken findByGeneratedToken(String generatedToken);
	List<CandidateSurveyToken> findByCandidateId(long candidateId);
}
