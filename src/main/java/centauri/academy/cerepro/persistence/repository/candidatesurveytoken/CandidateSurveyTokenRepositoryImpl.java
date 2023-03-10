package centauri.academy.cerepro.persistence.repository.candidatesurveytoken;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.CandidateSurveyToken;
import centauri.academy.cerepro.persistence.entity.Survey;
import centauri.academy.cerepro.persistence.entity.custom.CandidateSurveyTokenCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
/**
 * CandidateSurveyTokenRepositoryImpl
 * 
 * This class provides implementation for CandidateSurveyTokenRepositoryCustom methods
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class CandidateSurveyTokenRepositoryImpl implements CandidateSurveyTokenRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyToken() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
			rootTable.get("id"),
			rootTable.get("candidateId"), 
			joinCandidateTable.get("firstname"),
			joinCandidateTable.get("lastname"),
			joinCandidateTable.get("email"),
			rootTable.get("surveyId"),
			joinSurveyTable.get("label"),
			rootTable.get("expirationDateTime"),
			rootTable.get("generatedToken"),
			rootTable.get("expired")
		));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	}
	
	/********** PAGEABLE  -> START */
	public Page<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredPaginated(Pageable info, Boolean situation) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), situation));

//		criteria.add(cb.equal(joinTableUser.get("role"), Role.JAVA_COURSE_CANDIDATE_LEVEL));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<CandidateSurveyTokenCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("candidateId"), 
				joinCandidateTable.get("firstname"),
				joinCandidateTable.get("lastname"),
				joinCandidateTable.get("email"),
				rootTable.get("surveyId"),
				joinSurveyTable.get("label"),
				rootTable.get("expirationDateTime"),
				rootTable.get("generatedToken"),
				rootTable.get("expired")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		int start=(int) info.getOffset();
		int end = (start + info.getPageSize()) > resultList .size() ? resultList .size() : (start + info.getPageSize());        
		int totalRows = resultList .size();
		Page<CandidateSurveyTokenCustom> pageToReturn = new PageImpl<CandidateSurveyTokenCustom>(resultList .subList(start, end), info, totalRows); 
		return pageToReturn;
	
	}
	
/*********** PAGEABLE  -> END */
}
