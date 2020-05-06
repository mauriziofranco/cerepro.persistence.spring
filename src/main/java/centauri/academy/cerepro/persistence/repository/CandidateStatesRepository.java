/**
 * 
 */
package centauri.academy.cerepro.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import centauri.academy.cerepro.persistence.entity.CandidateStates;

/**
 * 
 * @author Sebastiano Varchetta
 */
public interface CandidateStatesRepository extends JpaRepository<CandidateStates, Long>{
		CandidateStates findByRoleId(Long id);
		CandidateStates findByStatusCode(int statusCode);
		CandidateStates findByStatusLabel(String statusLabel);
		CandidateStates findByStatusDescription(String statusDescription);
		CandidateStates findByStatusColor(String statusColor);
		
}
