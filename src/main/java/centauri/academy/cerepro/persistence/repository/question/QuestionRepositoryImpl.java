package centauri.academy.cerepro.persistence.repository.question;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Question;
import centauri.academy.cerepro.persistence.entity.SurveyQuestion;
import centauri.academy.cerepro.persistence.entity.custom.QuestionCustom;
/**
 * 
 * 
 * 
 * @author maurizio.franco@ymail.com
 *
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * extract questions form question table more position field from surveyquestions table and fit into a QuestionCustom Object
	 * @param surveyId
	 * @return
	 */
	@Override
	public List<QuestionCustom> findBySurveyId(long surveyId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<QuestionCustom> query = cb.createQuery(QuestionCustom.class);
		Root<SurveyQuestion> rootTable= query.from(SurveyQuestion.class);
		Root<Question> joinTable  = query.from(Question.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(joinTable.get("id"), rootTable.get("questionId")));
		criteria.add(cb.equal(rootTable.get("surveyId"), surveyId));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("position")));
		
		TypedQuery<QuestionCustom> q = em.createQuery(query.multiselect(
			joinTable.get("id"),
			joinTable.get("label"),
			joinTable.get("description"),
			joinTable.get("ansa"),
			joinTable.get("ansb"),
			joinTable.get("ansc"),
			joinTable.get("ansd"),
			joinTable.get("anse"),
			joinTable.get("ansf"),
			joinTable.get("ansg"),
			joinTable.get("ansh"),
			joinTable.get("cansa"),
			joinTable.get("cansb"),
			joinTable.get("cansc"),
			joinTable.get("cansd"),
			joinTable.get("canse"),
			joinTable.get("cansf"),
			joinTable.get("cansg"),
			joinTable.get("cansh"),			
			joinTable.get("fullAnswer"),			
			rootTable.get("position")
		));
		List<QuestionCustom> resultList = q.getResultList();
		return resultList ;
	}
	

}