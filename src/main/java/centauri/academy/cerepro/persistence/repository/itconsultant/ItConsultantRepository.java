package centauri.academy.cerepro.persistence.repository.itconsultant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.ItConsultant;
/**
 * ItConsultantRepository
 * 
 * It allows the management of the ItConsultant table, through insert, delete,
 * update and insert  
 * 
 * @author giacomo
 * @author m.franco
 *
 */
@Repository
public interface ItConsultantRepository extends JpaRepository<ItConsultant, Long>, ItConsultantRepositoryCustom {
	
	List<ItConsultant> findByUserId(long userId);
}
