package centauri.academy.cerepro.persistence.repository.coursepage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.CandidateStates;
import centauri.academy.cerepro.persistence.entity.CoursePage;
import centauri.academy.cerepro.persistence.entity.PositionUserOwner;
import centauri.academy.cerepro.persistence.entity.User;
import centauri.academy.cerepro.persistence.entity.custom.CoursePageCustom;
import centauri.academy.cerepro.persistence.entity.custom.ListedCandidateCustom;

/**
 * CoursePageRepositoryImpl
 * 
 * CoursePage table repository custom methods implementation
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class CoursePageRepositoryImpl implements CoursePageRepositoryCustom {

	private Logger logger = LoggerFactory.getLogger(CoursePageRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;	


	
	public List<CoursePageCustom> findAllCustom () {		

		@SuppressWarnings("unchecked")
		List<CoursePageCustom> results = (List<CoursePageCustom>)em
				  .createQuery(
						  "select "
						  + "    coursepage0_.id as col_0_0_, coursepage0_.bodyText as col_1_0_, coursepage0_.fileName as col_2_0_, coursepage0_.title as col_3_0_, user2_.id as col_4_0_, user2_.firstname as col_5_0_, user2_.lastname as col_6_0_ \n"
						  + "    from CoursePage coursepage0_ \n"
						  + "        left join PositionUserOwner positionus1_ on coursepage0_.id=positionus1_.coursePageId\n"
						  + "        left join User user2_                   on user2_.id=positionus1_.userId")
				  .getResultList();
		

		return results ;

	}
	
}
