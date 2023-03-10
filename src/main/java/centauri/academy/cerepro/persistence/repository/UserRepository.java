package centauri.academy.cerepro.persistence.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	@Modifying
	@Query("UPDATE users SET u.enabled :b WHERE u.id :id")
	Integer updateEnabledById(@Param("id") Long id, @Param("b") Boolean b);

}