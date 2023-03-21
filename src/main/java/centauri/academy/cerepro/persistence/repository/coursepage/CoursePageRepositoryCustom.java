package centauri.academy.cerepro.persistence.repository.coursepage;

import java.util.List;

import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.custom.CoursePageCustom;

/**
 * CoursePageRepositoryCustom
 * 
 * CoursePage table repository custom methods declaration
 * 
 * @author maurizio.franco@ymail.com
 *
 */


public interface CoursePageRepositoryCustom {
	
	
	List<CoursePageCustom> findAllCustom();
	
	
}
