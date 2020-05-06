package centauri.academy.cerepro.persistence.repository.usersurveytoken;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import centauri.academy.cerepro.persistence.entity.Role;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Survey;
import centauri.academy.cerepro.persistence.entity.User;
import centauri.academy.cerepro.persistence.entity.UserTokenSurvey;
import centauri.academy.cerepro.persistence.entity.custom.UserSurveyTokenCustom;
/**
 * CandidateRepositoryImpl
 * 
 * This class provides implementation for CandidateRepositoryCustom methods
 * 
 * @author m.franco
 * @author Daniele Piccinni
 *
 */
@Repository
public class UserSurveyTokenRepositoryImpl implements UserSurveyTokenRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserSurveyTokenCustom> getAllCustomUserTokenSurvey() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserSurveyTokenCustom> query = null;
		query = cb.createQuery(UserSurveyTokenCustom.class);
		Root<UserTokenSurvey> rootTable = query.from(UserTokenSurvey.class);
		Root<User> joinUserTable = query.from(User.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("userId"), joinUserTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<UserSurveyTokenCustom> q = em.createQuery(query.multiselect(
			rootTable.get("id"),
			rootTable.get("userId"), 
			rootTable.get("surveyId"),
			rootTable.get("generatedtoken"),
			rootTable.get("expirationdate"),
			rootTable.get("expired"),
			joinSurveyTable.get("label"),
			joinUserTable.get("firstname"),
			joinUserTable.get("lastname"),
			joinUserTable.get("email")
		));
		List<UserSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	}
	
//	@Override
//	public List<UserSurveyTokenCustom> getAllCustomUserTokenSurveyExpired() {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<UserSurveyTokenCustom> query = null;
//		query = cb.createQuery(UserSurveyTokenCustom.class);
//		Root<UserTokenSurvey> rootTable = query.from(UserTokenSurvey.class);
//		Root<User> joinUserTable = query.from(User.class);
//		Root<Survey> joinSurveyTable = query.from(Survey.class);
//
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		criteria.add(cb.equal(rootTable.get("userId"), joinUserTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("expired"), true));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		query.orderBy(cb.desc(rootTable.get("expirationdate")));
//		TypedQuery<UserSurveyTokenCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("userId"), 
//				rootTable.get("surveyId"),
//				rootTable.get("expirationdate"),
//				joinSurveyTable.get("label"),
//				joinUserTable.get("firstname"),
//				joinUserTable.get("lastname"),
//				joinUserTable.get("email")
//				));
//		
//		
//		List<UserSurveyTokenCustom> resultList = q.getResultList();
//
//		return resultList ;
//	}
//	
//	@Override
//	public List<UserSurveyTokenCustom> getAllCustomUserTokenSurveyActive() {
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<UserSurveyTokenCustom> query = null;
//		query = cb.createQuery(UserSurveyTokenCustom.class);
//		Root<UserTokenSurvey> rootTable = query.from(UserTokenSurvey.class);
//		Root<User> joinUserTable = query.from(User.class);
//		Root<Survey> joinSurveyTable = query.from(Survey.class);
//
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		criteria.add(cb.equal(rootTable.get("userId"), joinUserTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
//		criteria.add(cb.equal(rootTable.get("expired"), false));
//		
//		query.where(criteria.toArray(new Predicate[criteria.size()]));
//		query.orderBy(cb.desc(rootTable.get("expirationdate")));
//		TypedQuery<UserSurveyTokenCustom> q = em.createQuery(query.multiselect(
//				rootTable.get("id"),
//				rootTable.get("userId"), 
//				rootTable.get("surveyId"),
//				rootTable.get("expirationdate"),
//				joinSurveyTable.get("label"),
//				joinUserTable.get("firstname"),
//				joinUserTable.get("lastname"),
//				joinUserTable.get("email")
//				));
//		
//		
//		List<UserSurveyTokenCustom> resultList = q.getResultList();
//
//		return resultList ;
//	}
	
	/********** PAGEABLE  -> START */
	/**
	 * @author giacomo
	 * @author daniele
	 */
	public Page<UserSurveyTokenCustom> getAllCustomUserTokenSurveyPaginated(Pageable info, Boolean situation) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserSurveyTokenCustom> query = null;
		query = cb.createQuery(UserSurveyTokenCustom.class);
		Root<UserTokenSurvey> rootTable = query.from(UserTokenSurvey.class);
		Root<User> joinTableUser = query.from(User.class);
		Root<Survey> joinTableSurvey = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("userId"), joinTableUser.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinTableSurvey.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), situation));

		criteria.add(cb.equal(joinTableUser.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<UserSurveyTokenCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("userId"), 
				rootTable.get("surveyId"),
				rootTable.get("expirationdate"),
				joinTableSurvey.get("label"),
				joinTableUser.get("firstname"),
				joinTableUser.get("lastname"),
				joinTableUser.get("email")
				));
		List<UserSurveyTokenCustom> resultList = q.getResultList();
		int start=(int) info.getOffset();
		int end = (start + info.getPageSize()) > resultList .size() ? resultList .size() : (start + info.getPageSize());        
		int totalRows = resultList .size();
		Page<UserSurveyTokenCustom> pageToReturn = new PageImpl<UserSurveyTokenCustom>(resultList .subList(start, end), info, totalRows); 
		return pageToReturn;
	
	}
	
/*********** PAGEABLE  -> END */
}
