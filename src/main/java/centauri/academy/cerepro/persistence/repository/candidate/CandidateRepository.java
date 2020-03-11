package centauri.academy.cerepro.persistence.repository.candidate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.CandidateCustom;
/**
 * CandidateRepository
 * 
 * It allows the management of the candidate table, through insert, delete,
 * update and insert question The connection with Database is made by ConfigDB
 * java class
 * 
 * @author giacomo
 *
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {
	
	List<Candidate> findByUserId(long userId);

	
}
