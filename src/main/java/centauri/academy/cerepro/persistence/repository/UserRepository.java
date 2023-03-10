package centauri.academy.cerepro.persistence.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	Optional<User> findById(Long id);
	List<User> findByRole(int role);
	
	@Transactional
	@Modifying
	@Query("UPDATE User SET enabled = :b WHERE id = :id")
	Integer updateEnabledById(@Param("id") long id, @Param("b") boolean b);

}
