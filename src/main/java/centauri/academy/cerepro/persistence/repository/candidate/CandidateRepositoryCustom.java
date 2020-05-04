package centauri.academy.cerepro.persistence.repository.candidate;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import centauri.academy.cerepro.persistence.entity.CandidateCustom;

/**
 * CandidateRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 * 
 * @author m.franco
 *
 */
public interface CandidateRepositoryCustom {
	
	
	CandidateCustom getSingleCustomCandidate(Long id);
	
	List<CandidateCustom> findByCourseCode(String code);

	
	Page<CandidateCustom> getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode);
	
}
