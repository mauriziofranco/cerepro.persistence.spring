/**
 * 
 */
package centauri.academy.cerepro.persistence.entity.custom;

import centauri.academy.cerepro.persistence.entity.CoursePage;

/**
 * @author m.peruzza@proximanetwork.it
 *
 */

public class CoursePageCustom extends CoursePage {
	
	private Long userId ;
	
	private String coursePageOwnerFirstname ;
	
	private String coursePageOwnerLastname ;
		
	public CoursePageCustom() {
		super();
	}
	
	public CoursePageCustom(Long id, String bodyText, String fileName, String title, String code) {
		super(id, bodyText, fileName, title, code);
	}

	public CoursePageCustom(Long id, String bodyText, String fileName, String title, String code, Long userId,
			String coursePageOwnerFirstname, String coursePageOwnerLastname) {
		super(id, bodyText, fileName, title, code);
		this.userId = userId;
		this.coursePageOwnerFirstname = coursePageOwnerFirstname;
		this.coursePageOwnerLastname = coursePageOwnerLastname;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the coursePageOwnerFirstname
	 */
	public String getCoursePageOwnerFirstname() {
		return coursePageOwnerFirstname;
	}

	/**
	 * @param coursePageOwnerFirstname the coursePageOwnerFirstname to set
	 */
	public void setCoursePageOwnerFirstname(String coursePageOwnerFirstname) {
		this.coursePageOwnerFirstname = coursePageOwnerFirstname;
	}

	/**
	 * @return the coursePageOwnerLastname
	 */
	public String getCoursePageOwnerLastname() {
		return coursePageOwnerLastname;
	}

	/**
	 * @param coursePageOwnerLastname the coursePageOwnerLastname to set
	 */
	public void setCoursePageOwnerLastname(String coursePageOwnerLastname) {
		this.coursePageOwnerLastname = coursePageOwnerLastname;
	}

	
	 

}
