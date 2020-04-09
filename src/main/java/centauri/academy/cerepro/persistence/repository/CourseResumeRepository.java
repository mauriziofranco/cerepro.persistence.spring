package centauri.academy.cerepro.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.CourseResume;


/**
 * Provides a repository for the CourseResume entity
 * 
 * @author Centauri Academy
 *
 */
@Repository
public interface CourseResumeRepository extends JpaRepository<CourseResume, Long> {
	
	List<CourseResume> findByCode(String code);

}