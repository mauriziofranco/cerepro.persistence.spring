package centauri.academy.cerepro.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.PositionUserOwner;

/**
 * 
 * @author m.peruzza@proximanetwork.it
 *
 */

@Repository
public interface PositionUserOwnerRepository extends JpaRepository<PositionUserOwner, Long>{
	
	
	List <Optional <PositionUserOwner>> findByCoursePageIdAndUserId(long course_page_id, long user_id);

}
