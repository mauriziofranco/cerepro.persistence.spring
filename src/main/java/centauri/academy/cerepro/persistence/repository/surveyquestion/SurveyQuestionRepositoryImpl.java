package centauri.academy.cerepro.persistence.repository.surveyquestion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.Question;
import centauri.academy.cerepro.persistence.entity.Survey;
import centauri.academy.cerepro.persistence.entity.SurveyQuestion;
import centauri.academy.cerepro.persistence.entity.custom.SurveyQuestionCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
/**
 * SurveyQuestionRepositoryImpl
 * 
 * This class provides implementation for SurveyQuestionRepositoryCustom methods
 * 
 * @author joffre
 *
 */
@Repository
public class SurveyQuestionRepositoryImpl implements SurveyQuestionRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<SurveyQuestionCustom> getAllCustomSurveyQuestion() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SurveyQuestionCustom> query = null;
		query = cb.createQuery(SurveyQuestionCustom.class);
		Root<SurveyQuestion> rootTable = query.from(SurveyQuestion.class);
		Root<Survey> joinSurveyTable = query.from(Survey.class);
		Root<Question> joinQuestionTable = query.from(Question.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("surveyId"), joinSurveyTable.get("id")));
		criteria.add(cb.equal(rootTable.get("questionId"), joinQuestionTable.get("id")));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		query.orderBy(cb.desc(rootTable.get("id")));
		TypedQuery<SurveyQuestionCustom> q = em.createQuery(query.multiselect(
			rootTable.get("id"),
			rootTable.get("surveyId"),
			rootTable.get("questionId"),
			rootTable.get("position"),
			joinSurveyTable.get("label"),
			joinQuestionTable.get("label")
		));
		List<SurveyQuestionCustom> resultList = q.getResultList();
		return resultList ;
	}
	

}