package centauri.academy.cerepro.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Trainee;

/**
 * UserRepository
 * 
 * It allows the management of the question table, through insert, delete,
 * update and insert question The connection with Database is made by ConfigDB
 * java class
 * 
 * @author joffre
 * @author anna
 * @author m.franco
 */

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

	Optional<Trainee> findByEmail(String email);
	

}
