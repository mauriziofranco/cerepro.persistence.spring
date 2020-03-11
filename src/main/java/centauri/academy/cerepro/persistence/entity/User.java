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
import org.springframework.data.jpa.repository.Query;

/**
 * @author ilaria
 * @author joffre
 * @author m.franco@proximainformatica.com     
 *
 */

@Entity
@Table(name = "users")
public class User extends CeReProAbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@Email(message = "error.user.email.email")
	@NotEmpty(message = "error.user.email.empty")
	@Length(max = 100, message = "error.user.email.length")
	@Column(name = "email")
	private String email;
	
//	@NotEmpty(message = "error.user.password.empty")
	@Length(max = 100, message = "error.user.password.length")
	@Column(name = "password")
	private String password;
	
	@NotNull(message = "error.user.firstname.empty")
	@Length(max = 50, message = "error.user.firstname.length")
	@Column(name = "firstname")
	private String firstname;
	
	@NotNull(message = "error.user.lastname.empty")
	@Length(max = 50, message = "error.user.lastname.length")
	@Column(name = "lastname")
	private String lastname; 
	
//	@NotNull(message = "error.user.dateofbirth.empty")
	@Column(name="dateofbirth")
	private LocalDate dateOfBirth;
	
//	@NotNull(message = "error.user.regdate.empty")
	@Column(name="regdate")
	private LocalDateTime regdate;
	
	//?????????????????????????????????????????????
	//@NotNull(message = "error.user.role.empty")
	//?????????????????????????????????????????????

//	@Length(max = 11, message = "error.user.role.length")
//	@Max(11)
	@Column(name="role")
	private int role;
	
//	@NotEmpty(message = "error.user.imgpath.empty")
	@Length(max = 200, message = "error.user.imgpath.length")
	@Column(name="imgpath")
	private String imgpath;
	
	
    @Length(max = 2000, message = "error.user.note.length" )
	@Column(name = "note")  	
	private String note;
    
    @Column(name = "enabled")  
    private boolean enabled;
	
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
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
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateOfBirth=" + dateOfBirth + ", regdate=" + regdate + ", role=" + role
				+ ", imgpath=" + imgpath + ", note=" + note + ", enabled=" + enabled + "]";
	}

	


	
}






