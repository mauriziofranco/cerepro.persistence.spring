/**
 * 
 */
package centauri.academy.cerepro.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.NoteTemplate;

/**
 * @author marco morgana
 *
 */
@Repository
public interface NoteTemplateRepository extends JpaRepository<NoteTemplate, Long>{

	Optional<NoteTemplate> findById(Long id);
//	Optional<NoteTemplate> findByTitle(String title);

}
