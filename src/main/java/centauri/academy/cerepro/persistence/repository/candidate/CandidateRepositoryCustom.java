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
 * Candidates table repository custom methods declaration
 * 
 * @author maurizio.franco@ymail.com
 *
 */
public interface CandidateRepositoryCustom {
	
	CandidateCustom getSingleCustomCandidate(Long id) throws NoResultException ;
	
	List<ListedCandidateCustom> findByCourseCode(String code);

	Page<ListedCandidateCustom> getAllCustomCandidatesPaginatedByCourseCode(Pageable info, String courseCode);
	
}
