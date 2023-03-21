package centauri.academy.cerepro.persistence.repository.coursepage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
@Primary
public class CoursePageRepositoryImpl implements CoursePageRepositoryCustom {

	private Logger logger = LoggerFactory.getLogger(CoursePageRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;	

	public List<CoursePageCustom> findAllCustom () {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CoursePageCustom> query = cb.createQuery(CoursePageCustom.class);

		Root<CoursePage> rootTable = query.from(CoursePage.class);
		Root<PositionUserOwner> joinTable = query.from(PositionUserOwner.class);
		Root<User> joinTable2 = query.from(User.class);
		

		List<Predicate> criteria = new ArrayList<Predicate>();

		
		criteria.add(cb.equal(rootTable.get("id"), joinTable.get("coursePageId")));
		criteria.add(cb.equal(joinTable2.get("id"), joinTable.get("userId")));
//		criteria.add(cb.equal(joinTable.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
		
//		if (courseCode != null) {
//			criteria.add(cb.equal(rootTable.get("courseCode"), courseCode));
//		}
//		criteria.add(cb.equal(rootTable.get("candidateStateCode"), joinTable2.get("statusCode")));
//
//		query.orderBy(cb.desc(rootTable.get("candidacyDateTime")));
//
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		
		
		TypedQuery<CoursePageCustom> q = em.createQuery(query.multiselect(
				/*
				(Long id, String bodyText, String fileName, String title, Long userId,
			String coursePageOwner
				 */
				rootTable.get("id"),
				rootTable.get("bodyText"), 
				rootTable.get("fileName"), 
				rootTable.get("title"),
				rootTable.get("code"),
				joinTable2.get("id"), 
				joinTable2.get("firstname"),
			    joinTable2.get("lastname")			
		));

		List<CoursePageCustom> resultList = q.getResultList();
		return resultList ;

	}
	
	public List<CoursePageCustom> findAllCustomEmpty() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CoursePageCustom> query = cb.createQuery(CoursePageCustom.class);
		
		Root<CoursePage> rootTable = query.from(CoursePage.class);
		//Root<PositionUserOwner> joinTable = query.from(PositionUserOwner.class);
		
		List<Predicate> criteria = new ArrayList<Predicate>();
		
		//criteria.add(cb.notEqual(rootTable.get("id"), joinTable.get("coursePageId")));
		
		query.multiselect(rootTable);
		
		TypedQuery<CoursePageCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("bodyText"), 
				rootTable.get("fileName"), 
				rootTable.get("title"),
				rootTable.get("code")
		));
		
		List<CoursePageCustom> resultList = q.getResultList();
		return resultList ;
				
	}
	
}
