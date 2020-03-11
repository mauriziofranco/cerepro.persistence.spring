package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author m.franco
 *
 */

@Entity
@Table( name = "itconsultants" ) 
public class ItConsultant extends CeReProAbstractEntity {

	@Id   // specifies that id is a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //specifies that field id is auto incremented
	private Long id;
	
	@Column(name="user_id")
	@NotNull(message = "error.itconsultant.userId.empty")
	private Long userId;
	
	@Column(name="domicile_city")
	@Length(max = 100, message = "error.itconsultant.domicile_city.length")
	private String domicileCity;
	
	@Column(name="domicile_street_name")
	@Length(max = 100, message = "error.itconsultant.domicile_street_name.length")
	private String domicileStreetName;
	
	@Column(name="domicile_house_number")
	@Length(max = 100, message = "error.itconsultant.domicile_house_number.length")
	private String domicileHouseNumber;
	
	@Column(name="study_qualification")
	@Length(max = 300, message = "error.itconsultant.study_qualification.length")
	private String studyQualification;
	
	private Boolean graduate;
	
	@Column(name="high_graduate")
	private Boolean highGraduate;
	
	@Column(name="still_high_study")
	private Boolean stillHighStudy;
	
	@Length(max = 20, message = "error.itconsultant.mobile.length")
	private String mobile;
	
	@Column(name="cv_external_path")
	@Length(max = 1000, message = "error.itconsultant.cv_external_path.length")
	private String cvExternalPath;
	
	public ItConsultant(Long userId) {
		this.userId=userId;
	}
	public ItConsultant() {
		
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the user_id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the domicile_city
	 */
	public String getDomicileCity() {
		return domicileCity;
	}
	/**
	 * @param domicile_city the domicile_city to set
	 */
	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}
	/**
	 * @return the domicile_street_name
	 */
	public String getDomicileStreetName() {
		return domicileStreetName;
	}
	/**
	 * @param domicile_street_name the domicile_street_name to set
	 */
	public void setDomicileStreetName(String domicileStreetName) {
		this.domicileStreetName = domicileStreetName;
	}
	/**
	 * @return the domicile_house_number
	 */
	public String getDomicileHouseNumber() {
		return domicileHouseNumber;
	}
	/**
	 * @param domicile_house_number the domicile_house_number to set
	 */
	public void setDomicileHouseNumber(String domicileHouseNumber) {
		this.domicileHouseNumber = domicileHouseNumber;
	}
	/**
	 * @return the study_qualification
	 */
	public String getStudyQualification() {
		return studyQualification;
	}
	/**
	 * @param study_qualification the study_qualification to set
	 */
	public void setStudyQualification(String studyQualification) {
		this.studyQualification = studyQualification;
	}
	/**
	 * @return the graduate
	 */
	public Boolean getGraduate() {
		return graduate;
	}
	/**
	 * @param graduate the graduate to set
	 */
	public void setGraduate(Boolean graduate) {
		this.graduate = graduate;
	}
	/**
	 * @return the high_graduate
	 */
	public Boolean getHighGraduate() {
		return highGraduate;
	}
	/**
	 * @param high_graduate the high_graduate to set
	 */
	public void setHighGraduate(Boolean highGraduate) {
		this.highGraduate = highGraduate;
	}
	/**
	 * @return the still_high_study
	 */
	public Boolean getStillHighStudy() {
		return stillHighStudy;
	}
	/**
	 * @param still_high_study the still_high_study to set
	 */
	public void setStillHighStudy(Boolean stillHighStudy) {
		this.stillHighStudy = stillHighStudy;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the cv_external_path
	 */
	public String getCvExternalPath() {
		return cvExternalPath;
	}
	/**
	 * @param cv_external_path the cv_external_path to set
	 */
	public void setCvExternalPath(String cvExternalPath) {
		this.cvExternalPath = cvExternalPath;
	}
	/**
	 * Provides a full debug of the entity
	 * @return a string representation of the entity
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" -- userId: ").append(userId);
		sb.append(" -- domicile_city: ").append(domicileCity);
		sb.append(" -- domicile_street_name: ").append(domicileStreetName);
		sb.append(" -- domicile_house_number: ").append(domicileHouseNumber);
		sb.append(" -- study_qualification: ").append(studyQualification);
		sb.append(" -- graduate: ").append(graduate);
		sb.append(" -- high_graduate: ").append(highGraduate);
		sb.append(" -- still_high_study: ").append(stillHighStudy);
		sb.append(" -- mobile: ").append(mobile);
		sb.append(" -- cv_external_path: ").append(cvExternalPath);
		return sb.toString();
	}
	
}
