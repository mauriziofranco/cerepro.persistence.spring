package centauri.academy.cerepro.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.NewsLetterMessage;

/**
 * NewLetterMessageRepository
 * 
 * @author jefersson serrano
 */

@Repository
public interface NewsLetterMessageRepository extends JpaRepository<NewsLetterMessage, Long> {

	Optional<NewsLetterMessage> findById(Long id);
	List<NewsLetterMessage> findBySubject(String subject);

	

}
