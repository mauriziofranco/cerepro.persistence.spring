package centauri.academy.cerepro.persistence.repository.itconsultant;

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
import org.springframework.stereotype.Repository;

import centauri.academy.cerepro.persistence.entity.ItConsultant;
import centauri.academy.cerepro.persistence.entity.Role;
import centauri.academy.cerepro.persistence.entity.User;
import centauri.academy.cerepro.persistence.entity.custom.ItConsultantCustom;

/**
 * ItConsultantRepositoryImpl
 * 
 * This class provides implementation for ItConsultantRepositoryCustom methods
 *  @author m.franco
 * @author joffre
 * @author daniele
 * @author giacomo
 *
 */
@Repository
public class ItConsultantRepositoryImpl implements ItConsultantRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ItConsultantCustom> getAllCustomItConsultants() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ItConsultantCustom> query = null;
		query = cb.createQuery(ItConsultantCustom.class);
		Root<ItConsultant> rootTable = query.from(ItConsultant.class);
		Root<User> joinTable = query.from(User.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
		criteria.add(cb.equal(joinTable.get("role"), Role.ITCONSULTANT_LEVEL));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<ItConsultantCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("userId"), 
				rootTable.get("domicileCity"),
				rootTable.get("domicileStreetName"),
				rootTable.get("domicileHouseNumber"), 
				rootTable.get("studyQualification"),
				rootTable.get("graduate"), 
				rootTable.get("highGraduate"),
				rootTable.get("stillHighStudy"),
				rootTable.get("mobile"),
				rootTable.get("cvExternalPath"),
				joinTable.get("email"),
				joinTable.get("firstname"),
				joinTable.get("lastname"),
				joinTable.get("dateOfBirth"),
				joinTable.get("imgpath")
				));
		List<ItConsultantCustom> resultList = q.getResultList();
		return resultList ;
	}

	
/********** PAGEABLE  -> START */
	
	public Page<ItConsultantCustom> getAllCustomItConsultantsPaginated(Pageable info) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ItConsultantCustom> query = null;
		query = cb.createQuery(ItConsultantCustom.class);
		Root<ItConsultant> rootTable = query.from(ItConsultant.class);
		Root<User> joinTable = query.from(User.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
		criteria.add(cb.equal(joinTable.get("role"), Role.ITCONSULTANT_LEVEL));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<ItConsultantCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("userId"), 
				rootTable.get("domicileCity"),
				rootTable.get("domicileStreetName"),
				rootTable.get("domicileHouseNumber"), 
				rootTable.get("studyQualification"),
				rootTable.get("graduate"), 
				rootTable.get("highGraduate"),
				rootTable.get("stillHighStudy"),
				rootTable.get("mobile"),
				rootTable.get("cvExternalPath"),
				joinTable.get("email"),
				joinTable.get("firstname"),
				joinTable.get("lastname"),
				joinTable.get("dateOfBirth"),
				joinTable.get("imgpath")
		));
		List<ItConsultantCustom> resultList = q.getResultList();
		int start=(int) info.getOffset();
		int end = (start + info.getPageSize()) > resultList.size() ? resultList.size() : (start + info.getPageSize());        
		int totalRows = resultList.size();

		Page<ItConsultantCustom> pageToReturn = new PageImpl<ItConsultantCustom>(resultList.subList(start, end), info, totalRows); 
		return pageToReturn;
	
	}
	
/*********** PAGEABLE  -> END */
	
	
	
	
	@Override
	public ItConsultantCustom getSingleCustomItConsultant(Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ItConsultantCustom> query = null;
		query = cb.createQuery(ItConsultantCustom.class);
		Root<ItConsultant> rootTable = query.from(ItConsultant.class);
		Root<User> joinTable = query.from(User.class);
		List<Predicate> criteria = new ArrayList<Predicate>();
		criteria.add(cb.equal(rootTable.get("userId"), joinTable.get("id")));
		criteria.add(cb.equal(joinTable.get("role"), Role.ITCONSULTANT_LEVEL));
		criteria.add(cb.equal(rootTable.get("id"), id));
		
		query.where(criteria.toArray(new Predicate[criteria.size()]));
		TypedQuery<ItConsultantCustom> q = em.createQuery(query.multiselect(
				rootTable.get("id"),
				rootTable.get("userId"), 
				rootTable.get("domicileCity"),
				rootTable.get("domicileStreetName"),
				rootTable.get("domicileHouseNumber"), 
				rootTable.get("studyQualification"),
				rootTable.get("graduate"), 
				rootTable.get("highGraduate"),
				rootTable.get("stillHighStudy"),
				rootTable.get("mobile"),
				rootTable.get("cvExternalPath"),
				joinTable.get("email"),
				joinTable.get("firstname"),
				joinTable.get("lastname"),
				joinTable.get("dateOfBirth"),
				joinTable.get("imgpath")
				));
		
		
		q.setMaxResults(1);
		ItConsultantCustom returnValue = q.getSingleResult();
		return returnValue ;
	}
}
