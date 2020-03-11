package centauri.academy.cerepro.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.User;

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
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	List<User> findByRole(int role);

	@Query("select count(can.id) from Candidate can join User us on can.userId = us.id where us.regdate >= :dataStart and us.regdate < :dataEnd")
	long getUserRegdateInPeriod(LocalDateTime dataStart, LocalDateTime dataEnd);
}
