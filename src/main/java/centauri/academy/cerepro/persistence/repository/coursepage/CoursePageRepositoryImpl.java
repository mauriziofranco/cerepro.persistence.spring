package centauri.academy.cerepro.persistence.repository.coursepage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.custom.CoursePageCustom;

/**
 * CoursePageRepositoryImpl
 * 
 * CoursePage table repository custom methods implementation
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
@Primary
public class CoursePageRepositoryImpl implements CoursePageRepositoryCustom {

	private Logger logger = LoggerFactory.getLogger(CoursePageRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;	


	
	public List<CoursePageCustom> findAllCustom () {
		logger.info("findAllCustom - START");
		@SuppressWarnings("unchecked")
		List<CoursePageCustom> results = (List<CoursePageCustom>)em
				  .createQuery(
						  "select "
						  + "    coursepage0_.id as col_0_0_, coursepage0_.bodyText as col_1_0_, coursepage0_.fileName as col_2_0_, coursepage0_.title as col_3_0_, coursepage0_.title as col_4_0_, user2_.id as col_5_0_, user2_.firstname as col_6_0_, user2_.lastname as col_7_0_ \n"
						  + "    from CoursePage coursepage0_ \n"
						  + "        left join PositionUserOwner positionus1_ on coursepage0_.id=positionus1_.coursePageId\n"
						  + "        left join User user2_                   on user2_.id=positionus1_.userId")
				  .getResultList();

		return results ;
				
	}
	
}
