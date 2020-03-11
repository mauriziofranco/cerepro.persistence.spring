package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

/**
 * @author m.franco
 *
 */
public class CandidateCustom extends CeReProAbstractEntity {

	private Long id;
	private Long userId;
	private String domicileCity;
	private String studyQualification;
	private Boolean graduate;
	private Boolean highGraduate;
	private Boolean stillHighStudy;
	private String mobile;
	private String cvExternalPath;
	private String email;
	private String firstname;
	private String lastname;
	private LocalDate dateOfBirth;
	private String imgpath;
	private String courseCode;
	private String note;
	private String label;
	private Long candidateStatesId;
	private String candidateStatusColor;
	private String candidateSatusLabel;

	public CandidateCustom() {

	}

	public CandidateCustom(Long id, 
			               Long userId, 
			               String domicileCity, 
			               String studyQualification,
			               Boolean graduate, 
			               Boolean highGraduate,
			               Boolean stillHighStudy, 
			               String mobile, 
			               String cvExternalPath, 
			               String email, 
			               String firstname,
			               String lastname, 
			               LocalDate dateOfBirth, 
			               String imgpath, 
			               String courseCode, 
			               String note,
			               String label,
			               Long candidateStatesId,
			               String candidateStatusColor,
			               String candidateSatusLabel) {
		this.id = id;
		this.userId = userId;
		this.domicileCity = domicileCity;
		this.studyQualification = studyQualification;
		this.graduate = graduate;
		this.highGraduate = highGraduate;
		this.stillHighStudy = stillHighStudy;
		this.mobile = mobile;
		this.cvExternalPath = cvExternalPath;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.imgpath = imgpath;
		this.courseCode = courseCode;
		this.note = note;
		this.label = label;
		this.candidateStatesId=candidateStatesId;
		this.candidateStatusColor=candidateStatusColor;
		this.candidateSatusLabel=candidateSatusLabel;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the domicileCity
	 */
	public String getDomicileCity() {
		return domicileCity;
	}

	/**
	 * @param domicileCity
	 *            the domicileCity to set
	 */
	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}

//	/**
//	 * @return the domicileStreetName
//	 */
//	public String getDomicileStreetName() {
//		return domicileStreetName;
//	}

//	/**
//	 * @param domicileStreetName
//	 *            the domicileStreetName to set
//	 */
//	public void setDomicileStreetName(String domicileStreetName) {
//		this.domicileStreetName = domicileStreetName;
//	}
//
//	/**
//	 * @return the domicileHouseNumber
//	 */
//	public String getDomicileHouseNumber() {
//		return domicileHouseNumber;
//	}
//
//	/**
//	 * @param domicileHouseNumber
//	 *            the domicileHouseNumber to set
//	 */
//	public void setDomicileHouseNumber(String domicileHouseNumber) {
//		this.domicileHouseNumber = domicileHouseNumber;
//	}

	/**
	 * @return the studyQualification
	 */
	public String getStudyQualification() {
		return studyQualification;
	}

	/**
	 * @param studyQualification
	 *            the studyQualification to set
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
	 * @param graduate
	 *            the graduate to set
	 */
	public void setGraduate(Boolean graduate) {
		this.graduate = graduate;
	}

	/**
	 * @return the highGraduate
	 */
	public Boolean getHighGraduate() {
		return highGraduate;
	}

	/**
	 * @param highGraduate
	 *            the highGraduate to set
	 */
	public void setHighGraduate(Boolean highGraduate) {
		this.highGraduate = highGraduate;
	}

	/**
	 * @return the stillHighStudy
	 */
	public Boolean getStillHighStudy() {
		return stillHighStudy;
	}

	/**
	 * @param stillHighStudy
	 *            the stillHighStudy to set
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
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the cvExternalPath
	 */
	public String getCvExternalPath() {
		return cvExternalPath;
	}

	/**
	 * @param cvExternalPath
	 *            the cvExternalPath to set
	 */
	public void setCvExternalPath(String cvExternalPath) {
		this.cvExternalPath = cvExternalPath;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * @param imgpath
	 *            the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
	 * @return the candidateStatesId
	 */
	public Long getCandidateStatesId() {
		return candidateStatesId;
	}

	/**
	 * @param candidateStatesId the candidateStatesId to set
	 */
	public void setCandidateStatesId(Long candidateStatesId) {
		this.candidateStatesId = candidateStatesId;
	}

	/**
	 * @return the candidateStatusColor
	 */
	public String getCandidateStatusColor() {
		return candidateStatusColor;
	}

	/**
	 * @param candidateStatusColor the candidateStatusColor to set
	 */
	public void setCandidateStatusColor(String candidateStatusColor) {
		this.candidateStatusColor = candidateStatusColor;
	}
	
	 

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	
	

	public String getCandidateSatusLabel() {
		return candidateSatusLabel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	public void setCandidateSatusLabel(String candidateSatusLabel) {
		this.candidateSatusLabel = candidateSatusLabel;
	}
	
	@Override
	public String toString() {
		return "CandidateCustom [id=" + id + ", userId=" + userId + ", domicileCity=" + domicileCity
				+ ", studyQualification=" + studyQualification + ", graduate=" + graduate + ", highGraduate="
				+ highGraduate + ", stillHighStudy=" + stillHighStudy + ", mobile=" + mobile + ", cvExternalPath="
				+ cvExternalPath + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateOfBirth=" + dateOfBirth + ", imgpath=" + imgpath + ", courseCode=" + courseCode + ", note="
				+ note + ", label=" + label + ", candidateStatesId=" + candidateStatesId + ", candidateStatusColor="
				+ candidateStatusColor + ", candidateSatusLabel=" + candidateSatusLabel + "]";
	}
	

	
}
