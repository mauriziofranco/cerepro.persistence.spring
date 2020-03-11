/**
 * 
 */
package centauri.academy.cerepro.persistence.repository;

/**
 * @author Sebastiano Varchetta
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;

import centauri.academy.cerepro.persistence.entity.CandidateStates;


public interface CandidateStatesRepository extends JpaRepository<CandidateStates, Long>{
		CandidateStates findByRoleId(Long id);
		CandidateStates findByStatusCode(int  statusCode);
		CandidateStates findByStatusLabel(String statusLabel);
		CandidateStates findByStatusDescription(String statusDescription);
		CandidateStates findByStatusColor(String statusColor);
		
}
