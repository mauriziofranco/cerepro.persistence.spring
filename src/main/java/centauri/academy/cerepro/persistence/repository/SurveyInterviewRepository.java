package centauri.academy.cerepro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.SurveyInterview;


/**
 * 
 * @author Fabio Li Greci
 */
@Repository
public interface SurveyInterviewRepository extends JpaRepository<SurveyInterview, Long>{
	SurveyInterview findBySurveyIdAndInterviewId(long surveyId, long interviewId);
	List<SurveyInterview> findBySurveyId(long surveyId);
	List<SurveyInterview> findBySurveyIdOrderByPositionAsc(long surveyId);
	
}
