package centauri.academy.cerepro.persistence.repository.itconsultant;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import centauri.academy.cerepro.persistence.entity.custom.ItConsultantCustom;

/**
 * ItConsultantRepositoryCustom
 * 
 * Provides signs for custom implementation methods
 * 
 * @author m.franco
 *
 */
public interface ItConsultantRepositoryCustom {
	
	List<ItConsultantCustom> getAllCustomItConsultants() ;
	
	ItConsultantCustom getSingleCustomItConsultant(Long id);
	
	Page<ItConsultantCustom> getAllCustomItConsultantsPaginated(Pageable info);
	
}
