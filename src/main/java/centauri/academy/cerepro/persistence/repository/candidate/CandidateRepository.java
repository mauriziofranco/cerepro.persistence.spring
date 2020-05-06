package centauri.academy.cerepro.persistence.repository.candidate;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.custom.CandidateCustom;
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
	
//	List<Candidate> findByUserId(long userId);

//	@Query("select count(can.id) from Candidate can join User us on can.userId = us.id where us.regdate >= :dataStart and us.regdate < :dataEnd")
//	long getCandidateCountWithRegdateInPeriod(LocalDateTime dataStart, LocalDateTime dataEnd);
	
	@Query("select count(can.id) from Candidate can where can.regdate >= :dataStart and can.regdate < :dataEnd")
	long getCandidateCountWithRegdateInPeriod(LocalDateTime dataStart, LocalDateTime dataEnd);
	
	
}
