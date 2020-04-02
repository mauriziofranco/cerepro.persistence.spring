package centauri.academy.cerepro.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Trainee;

/**
 * TraineeRepository
 * 
 * A class that manages basic operations like save(), delete(), getById, etc. between the database and the Entity class Trainee.
 * 
 * @author Jesus Bojorquez jbm.bojorquez@gmail.com
 */

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

	Optional<Trainee> findByEmail(String email);
	Optional<Trainee> findByEnabled(int enabled);
	
	@Query("SELECT obj FROM Trainee obj WHERE password is not null AND firstname is not null AND lastname is not null and haspassword = '0'")
	List<Trainee> findByFilled();
	
	@Query("SELECT obj FROM Trainee obj WHERE enabled = '0'")
	List<Trainee> findListByEnabled();
}
