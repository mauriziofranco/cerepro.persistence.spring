package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author giacomo
 * @author m.franco@proximainformatica.com  
 *
 */

@Entity
@Table( name = "candidates" ) 
public class Candidate extends CeReProAbstractEntity {

	@Id   // specifies that id is a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //specifies that field id is auto incremented
	private Long id;
	
	@Column(name="user_id")
	@NotNull(message = "error.candidate.userId.empty")
	private Long userId;
	
	@Column(name="domicile_city")
	@Length(max = 100, message = "error.candidate.domicile_city.length")
	private String domicileCity;
	
//	@Column(name="domicile_street_name")
//	@Length(max = 100, message = "error.candidate.domicile_street_name.length")
//	private String domicileStreetName;
//	
//	@Column(name="domicile_house_number")
//	@Length(max = 100, message = "error.candidate.domicile_house_number.length")
//	private String domicileHouseNumber;
	
	@Column(name="study_qualification")
	@Length(max = 300, message = "error.candidate.study_qualification.length")
	private String studyQualification;
	
	private Boolean graduate;
	
	@Column(name="high_graduate")
	private Boolean highGraduate;
	
	@Column(name="still_high_study")
	private Boolean stillHighStudy;
	
	@Length(max = 20, message = "error.candidate.mobile.length")
	private String mobile;
	
	@Column(name="cv_external_path")
	@Length(max = 1000, message = "error.candidate.cv_external_path.length")
	private String cvExternalPath;
	
	@Column(name="course_code")
	@Length(max = 100)
	private String courseCode;
	
	@Column(name="candidacy_date_time")
	private LocalDateTime candidacyDateTime;
	
	@Column(name="label")
	@Length(max = 100)
	private String label;
	
	@Column(name="candidate_states_id")
	@NotNull(message = "error.candidate.candidateStatesId.empty")
	private Long candidateStatesId;
	
	public Candidate(Long userId, String courseCode,Long candidateStatesId) {
		this.userId=userId;
		this.courseCode=courseCode;
		this.candidateStatesId=candidateStatesId;
	}
	public Candidate() {
		
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
//	/**
//	 * @return the domicile_street_name
//	 */
//	public String getDomicileStreetName() {
//		return domicileStreetName;
//	}
//	/**
//	 * @param domicile_street_name the domicile_street_name to set
//	 */
//	public void setDomicileStreetName(String domicileStreetName) {
//		this.domicileStreetName = domicileStreetName;
//	}
//	/**
//	 * @return the domicile_house_number
//	 */
//	public String getDomicileHouseNumber() {
//		return domicileHouseNumber;
//	}
//	/**
//	 * @param domicile_house_number the domicile_house_number to set
//	 */
//	public void setDomicileHouseNumber(String domicileHouseNumber) {
//		this.domicileHouseNumber = domicileHouseNumber;
//	}
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
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the candidacyDateTime
	 */
	public LocalDateTime getCandidacyDateTime() {
		return candidacyDateTime;
	}
	/**
	 * @param candidacyDateTime the candidacyDateTime to set
	 */
	public void setCandidacyDateTime(LocalDateTime candidacyDateTime) {
		this.candidacyDateTime = candidacyDateTime;
	}
	
	public Long getCandidateStatesId() {
		return candidateStatesId;
	}
	
	public void setCandidateStatesId(Long candidateStatesId) {
		this.candidateStatesId = candidateStatesId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", userId=" + userId + ", domicileCity=" + domicileCity + ", studyQualification="
				+ studyQualification + ", graduate=" + graduate + ", highGraduate=" + highGraduate + ", stillHighStudy="
				+ stillHighStudy + ", mobile=" + mobile + ", cvExternalPath=" + cvExternalPath + ", courseCode="
				+ courseCode + ", candidacyDateTime=" + candidacyDateTime + ", label=" + label + ", candidateStatesId="+candidateStatesId+"]";
	}
	

	
}
