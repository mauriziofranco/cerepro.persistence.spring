package centauri.academy.cerepro.persistence.repository.candidate;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Candidate;
/**
 * CandidateRepository
 * 
 * Candidates table repository
 * 
 * @author giacomo
 * @author maurizio.franco@ymail.com
 * @author Antonio Iannaccone - Roma Academy VII
 *
 */
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long>, CandidateRepositoryCustom {
	
	@Query("select count(can.id) from Candidate can where can.regdate >= :dataStart and can.regdate < :dataEnd")
	long getCandidateCountWithRegdateInPeriod(LocalDateTime dataStart, LocalDateTime dataEnd);
	
	Optional<Candidate> findById(Long id);
}
