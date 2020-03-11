package centauri.academy.cerepro.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Interview;

/**
 * 
 * @author Fabio Li Greci
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Long>{

}
