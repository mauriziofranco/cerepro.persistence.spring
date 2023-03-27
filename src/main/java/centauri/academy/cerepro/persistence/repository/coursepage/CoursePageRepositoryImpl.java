package centauri.academy.cerepro.persistence.repository.coursepage;

import java.time.LocalDateTime;
import java.util.ArrayList;
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


	
//	public List<CoursePageCustom> findAllCustom () {
//		logger.info("findAllCustom - START");
//		@SuppressWarnings("unchecked")
//		List<CoursePageCustom> results = em
//				  .createQuery(
//						  "select "
//						  + "    coursepage0_.id as col_0_0_, coursepage0_.bodyText as col_1_0_, coursepage0_.fileName as col_2_0_, coursepage0_.title as col_3_0_, coursepage0_.title as col_4_0_, user2_.id as col_5_0_, user2_.firstname as col_6_0_, user2_.lastname as col_7_0_ \n"
//						  + "    from CoursePage coursepage0_ \n"
//						  + "        left join PositionUserOwner positionus1_ on coursepage0_.id=positionus1_.coursePageId\n"
//						  + "        left join User user2_                   on user2_.id=positionus1_.userId")
//				  .getResultList();
//
//		return results ;
//				
//	}
	
	public List<CoursePageCustom> findAllCustom () {
		logger.info("findAllCustom - START");
		@SuppressWarnings("unchecked")
		List<Object[]> objResults = em
				  .createQuery(
						  "select "
						  + "    coursepage0_.id as col_0_0_, coursepage0_.bodyText as col_1_0_, coursepage0_.fileName as col_2_0_, coursepage0_.title as col_3_0_, coursepage0_.code as col_4_0_,coursepage0_.opened_by as col_5_0_,coursepage0_.created_datetime as col_6_0_, user2_.id as col_7_0_, user2_.firstname as col_8_0_, user2_.lastname as col_9_0_,user3_.firstname as col_10_0_, user3_.lastname as col_11_0_ \n"
						  + "    from CoursePage coursepage0_ \n"
						  + "        left join PositionUserOwner positionus1_ on coursepage0_.id=positionus1_.coursePageId\n"
						  + "        left join User user2_                   on user2_.id=positionus1_.userId\n"
						  + " 		 left join User user3_  on user3_.id=coursepage0_.opened_by"
						  + "		 order by coursepage0_.created_datetime desc")
				  .getResultList();

		List<CoursePageCustom> results = new ArrayList<CoursePageCustom> () ;
		for (Object[] currentObj : objResults) {
			CoursePageCustom item = new CoursePageCustom () ;
			logger.info("findAllCustom - DEBUG - currentObj.toString():{} ", currentObj.length);
			logger.info("findAllCustom - DEBUG - currentObj[0]:{} ", currentObj[0]);
			item.setId(Long.parseLong(""+currentObj[0]));
			logger.info("findAllCustom - DEBUG - currentObj[1]:{} ", currentObj[1]);
			item.setBodyText(""+currentObj[1]);			
			logger.info("findAllCustom - DEBUG - currentObj[2]:{} ", currentObj[2]);
			item.setFileName(""+currentObj[2]);
			logger.info("findAllCustom - DEBUG - currentObj[3]:{} ", currentObj[3]);
			item.setTitle(""+currentObj[3]);
			logger.info("findAllCustom - DEBUG - currentObj[4]:{} ", currentObj[4]);
			item.setCode(""+currentObj[4]);
			if (currentObj[5]!=null) {
                try {
                    item.setOpened_by(Long.parseLong(""+currentObj[5]));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
            logger.info("findAllCustom - DEBUG - currentObj[6]:{} ", currentObj[6]);
            if (currentObj[6]!=null) {
                try {
                    item.setCreated_datetime(LocalDateTime.parse(""+currentObj[6]));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
            logger.info("findAllCustom - DEBUG - currentObj[7]:{} ", currentObj[7]);
            if (currentObj[7]!=null) {
                try {
                    item.setUserId(Long.parseLong(""+currentObj[7]));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
			logger.info("findAllCustom - DEBUG - currentObj[8]:{} ", currentObj[8]);
			item.setCoursePageOwnerFirstname(""+currentObj[8]);
			logger.info("findAllCustom - DEBUG - currentObj[9]:{} ", currentObj[9]);
			item.setCoursePageOwnerLastname(""+currentObj[9]);
			logger.info("findAllCustom - DEBUG - currentObj[10]:{} ", currentObj[10]);
			item.setCoursePageFirstNameOpenedBy(""+currentObj[10]);
			logger.info("findAllCustom - DEBUG - currentObj[11]:{} ", currentObj[11]);
			item.setCoursePageLastNameOpenedBy(""+currentObj[11]);
			
			results.add(item);
		}
		
		return results ;
				
	}
	
}
