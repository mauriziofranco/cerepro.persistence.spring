package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author giacomo
 * @author m.franco@proximanetwork.it
 *
 */

@Entity
@Table(name = "candidates")
public class Candidate extends CeReProAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	@NotNull(message = "error.candidate.userId.empty")
	private long userId;

	@Column(name = "domicile_city")
	@Length(max = 100, message = "error.candidate.domicile_city.length")
	private String domicileCity;

//	@Column(name="domicile_street_name")
//	@Length(max = 100, message = "error.candidate.domicile_street_name.length")
//	private String domicileStreetName;
//	
//	@Column(name="domicile_house_number")
//	@Length(max = 100, message = "error.candidate.domicile_house_number.length")
//	private String domicileHouseNumber;

	@Column(name = "study_qualification")
	@Length(max = 300, message = "error.candidate.study_qualification.length")
	private String studyQualification;

	private Boolean graduate;

	@Column(name = "high_graduate")
	private Boolean highGraduate;

	@Column(name = "still_high_study")
	private Boolean stillHighStudy;

	@Length(max = 20, message = "error.candidate.mobile.length")
	private String mobile;

	@Column(name = "cv_external_path")
	@Length(max = 1000, message = "error.candidate.cv_external_path.length")
	private String cvExternalPath;

	@NotNull(message = "error.????.coursecode.empty")
	@Column(name = "course_code")
	@Length(max = 100)
	private String courseCode;

	@NotNull(message = "error.???.candidacy.date.time.notnull")
	@Column(name = "candidacy_date_time")
	private LocalDateTime candidacyDateTime;

	@Column(name = "label")
	@Length(max = 100)
	private String label;

	@Column(name = "candidate_states_id")
	@NotNull(message = "error.candidate.candidateStatesId.empty")
	private long candidateStatesId;

	// TODO..... for the above fill with the beans validation annotation

//	@Email(message = "error.user.email.email")
	@NotEmpty(message = "error.user.email.empty")
//	@NotNull(message = "????")
//	@Length(max = 100, message = "error.user.email.length")
	@Column(name = "email")
	private String email;
	@NotNull(message = "error.user.firstname.empty")
//	@Length(max = 50, message = "error.user.firstname.length")
	@Column(name = "firstname")
	private String firstname;
	@NotNull(message = "error.user.lastname.empty")
//	@Length(max = 50, message = "error.user.lastname.length")
	@Column(name = "lastname")
	private String lastname;
//	@NotNull(message = "error.user.dateofbirth.empty")
	@Column(name = "dateofbirth")
	private LocalDate dateOfBirth;
	@Column(name = "regdate")
	private LocalDateTime regdate;
//	@Length(max = 200, message = "error.user.imgpath.length")
	@Column(name = "imgpath")
	private String imgpath;
//    @Length(max = 2000, message = "error.user.note.length" )
	@Column(name = "technical_note")
	private String technicalNote;
	@Column(name = "hr_note")
	private String hrNote;
	@NotNull(message = "?error.user.email.empty")
	@Column(name = "inserted_by")
	private long insertedBy;

//	public Candidate(Long userId, String courseCode,Long candidateStatesId) {
//		this.userId=userId;
//		this.courseCode=courseCode;
//		this.candidateStatesId=candidateStatesId;
//	}
//	
//	

	/**
	 * @param userId
	 * @param candidateStatesId
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param regdate
	 * @param insertedBy
	 */
	public Candidate(@NotNull(message = "error.candidate.userId.empty") long userId,
			@NotNull(message = "error.????.coursecode.empty") String courseCode,
			@NotNull(message = "error.candidate.candidateStatesId.empty") long candidateStatesId,
			@NotEmpty(message = "error.user.email.empty") String email,
			@NotNull(message = "error.user.firstname.empty") String firstname,
			@NotNull(message = "error.user.lastname.empty") String lastname, LocalDateTime regdate,
			@NotNull(message = "?error.user.email.empty") long insertedBy,
			@NotNull(message = "error.???.candidacy.date.time.notnull") LocalDateTime candidacyDateTime) {
		super();
		this.userId = userId;
		this.courseCode = courseCode;
		this.candidateStatesId = candidateStatesId;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.regdate = regdate;
		this.insertedBy = insertedBy;
		this.candidacyDateTime = candidacyDateTime;
	}

	/**
	 * 
	 */
	public Candidate() {
		super();
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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the domicileCity
	 */
	public String getDomicileCity() {
		return domicileCity;
	}

	/**
	 * @param domicileCity the domicileCity to set
	 */
	public void setDomicileCity(String domicileCity) {
		this.domicileCity = domicileCity;
	}

	/**
	 * @return the studyQualification
	 */
	public String getStudyQualification() {
		return studyQualification;
	}

	/**
	 * @param studyQualification the studyQualification to set
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
	 * @return the highGraduate
	 */
	public Boolean getHighGraduate() {
		return highGraduate;
	}

	/**
	 * @param highGraduate the highGraduate to set
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
	 * @param stillHighStudy the stillHighStudy to set
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
	 * @return the cvExternalPath
	 */
	public String getCvExternalPath() {
		return cvExternalPath;
	}

	/**
	 * @param cvExternalPath the cvExternalPath to set
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
	public long getCandidateStatesId() {
		return candidateStatesId;
	}

	/**
	 * @param candidateStatesId the candidateStatesId to set
	 */
	public void setCandidateStatesId(long candidateStatesId) {
		this.candidateStatesId = candidateStatesId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
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
	 * @param firstname the firstname to set
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
	 * @param lastname the lastname to set
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
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the regdate
	 */
	public LocalDateTime getRegdate() {
		return regdate;
	}

	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	/**
	 * @return the imgpath
	 */
	public String getImgpath() {
		return imgpath;
	}

	/**
	 * @param imgpath the imgpath to set
	 */
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	/**
	 * @return the technicalNote
	 */
	public String getTechnicalNote() {
		return technicalNote;
	}

	/**
	 * @param technicalNote the technicalNote to set
	 */
	public void setTechnicalNote(String technicalNote) {
		this.technicalNote = technicalNote;
	}

	/**
	 * @return the hrNote
	 */
	public String getHrNote() {
		return hrNote;
	}

	/**
	 * @param hrNote the hrNote to set
	 */
	public void setHrNote(String hrNote) {
		this.hrNote = hrNote;
	}

	/**
	 * @return the insertedBy
	 */
	public long getInsertedBy() {
		return insertedBy;
	}

	/**
	 * @param insertedBy the insertedBy to set
	 */
	public void setInsertedBy(long insertedBy) {
		this.insertedBy = insertedBy;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", userId=" + userId + ", domicileCity=" + domicileCity + ", studyQualification="
				+ studyQualification + ", graduate=" + graduate + ", highGraduate=" + highGraduate + ", stillHighStudy="
				+ stillHighStudy + ", mobile=" + mobile + ", cvExternalPath=" + cvExternalPath + ", courseCode="
				+ courseCode + ", candidacyDateTime=" + candidacyDateTime + ", label=" + label + ", candidateStatesId="
				+ candidateStatesId + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateOfBirth=" + dateOfBirth + ", regdate=" + regdate + ", imgpath=" + imgpath + ", technicalNote="
				+ technicalNote + ", hrNote=" + hrNote + ", insertedBy=" + insertedBy + ", getId()=" + getId()
				+ ", getUserId()=" + getUserId() + ", getDomicileCity()=" + getDomicileCity()
				+ ", getStudyQualification()=" + getStudyQualification() + ", getGraduate()=" + getGraduate()
				+ ", getHighGraduate()=" + getHighGraduate() + ", getStillHighStudy()=" + getStillHighStudy()
				+ ", getMobile()=" + getMobile() + ", getCvExternalPath()=" + getCvExternalPath() + ", getCourseCode()="
				+ getCourseCode() + ", getCandidacyDateTime()=" + getCandidacyDateTime() + ", getLabel()=" + getLabel()
				+ ", getCandidateStatesId()=" + getCandidateStatesId() + ", getEmail()=" + getEmail()
				+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getDateOfBirth()="
				+ getDateOfBirth() + ", getRegdate()=" + getRegdate() + ", getImgpath()=" + getImgpath()
				+ ", getTechnicalNote()=" + getTechnicalNote() + ", getHrNote()=" + getHrNote() + ", getInsertedBy()="
				+ getInsertedBy() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
