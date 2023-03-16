package centauri.academy.cerepro.persistence.repository.candidatesurveytoken;

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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Candidate;
import centauri.academy.cerepro.persistence.entity.CandidateSurveyToken;
import centauri.academy.cerepro.persistence.entity.Survey;
import centauri.academy.cerepro.persistence.entity.SurveyReply;
import centauri.academy.cerepro.persistence.entity.custom.CandidateSurveyTokenCustom;
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
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
		
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
			rootTable.get("expired"),
			joinSurveyReplyTable.get("id"),
			joinSurveyReplyTable.get("pdffilename")
			
			
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
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), situation));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));

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
				rootTable.get("expired"),
				joinSurveyReplyTable.get("id"),
				joinSurveyReplyTable.get("pdffilename")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		int start=(int) info.getOffset();
		int end = (start + info.getPageSize()) > resultList .size() ? resultList .size() : (start + info.getPageSize());        
		int totalRows = resultList .size();
		Page<CandidateSurveyTokenCustom> pageToReturn = new PageImpl<CandidateSurveyTokenCustom>(resultList .subList(start, end), info, totalRows); 
		return pageToReturn;
	
	}
	
/*********** PAGEABLE  -> END */
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenActive() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), false));
		
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
		return resultList ;
	
	}
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExecuted() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), true));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), joinSurveyReplyTable.get("generated_token")));
		
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
				rootTable.get("expired"),
				joinSurveyReplyTable.get("id"),
				joinSurveyReplyTable.get("pdffilename")
				));
		List<CandidateSurveyTokenCustom> resultList = q.getResultList();
		return resultList ;
	
	}
	
	public List<CandidateSurveyTokenCustom> getAllCustomCandidateSurveyTokenExpiredAndNotExecuted() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CandidateSurveyTokenCustom> query = null;
		query = cb.createQuery(CandidateSurveyTokenCustom.class);
		Root<CandidateSurveyToken> rootTable = query.from(CandidateSurveyToken.class);
		Root<Candidate> joinCandidateTable = query.from(Candidate.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
//		Root<SurveyReply> joinSurveyReplyTable = query.from(SurveyReply.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("candidateId"), joinCandidateTable.get("id")));
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("expired"), true));
		
		criteria.add(cb.equal(rootTable.get("generatedToken"), null));
		
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
		return resultList ;
	
	}
	
}
