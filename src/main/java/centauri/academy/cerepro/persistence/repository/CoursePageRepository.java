package centauri.academy.cerepro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import centauri.academy.cerepro.persistence.entity.CoursePage;

/**
 * @author TraianC - Milano Centauri Academy III
 * @author giacomo
 * 
 */

@Repository
public interface CoursePageRepository extends JpaRepository<CoursePage, Long> {
	
	List<CoursePage> findByFileName(String fileName);
	List<CoursePage> findByTitle(String title);
	CoursePage findByCode(String code);
	
	
}
