package centauri.academy.cerepro.persistence.repository.candidate;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import centauri.academy.cerepro.persistence.entity.custom.CandidateCustom;
import centauri.academy.cerepro.persistence.entity.custom.ListedCandidateCustom;

/**
 * CandidateRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 * 
 * @author m.franco
 *
 */
public interface CandidateRepositoryCustom {
	
	
	CandidateCustom getSingleCustomCandidate(Long id) throws NoResultException ;
	
	List<ListedCandidateCustom> findByCourseCode(String code);

	Page<ListedCandidateCustom> getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode);
	
}
