package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "trainee")
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Length(max = 100, message = "error.user.email.length")
	@NotEmpty(message = "error.user.email.empty")
	@Email(message = "error.user.email.email")
	@Column(name = "email")
	private String email;
	
	@Length(max = 100, message = "error.user.password.length")
	@Column(name = "password")
	private String password;

	@Length(max = 50, message = "error.user.firstname.length")
	@Column(name = "firstname")
	private String firstname;

	@Length(max = 50, message = "error.user.firstname.length")
	@Column(name = "lastname")
	private String lastname;

	@Column(name = "coursepage_id")
	private Long coursepageid;

	@Column(name = "enabled")
	private int enabled;

	@Column(name = "haspassword")
	private int haspassword;

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
	 * @return the coursepageid
	 */
	public Long getCoursepageid() {
		return coursepageid;
	}

	/**
	 * @param coursepageid the coursepageid to set
	 */
	public void setCoursepageid(Long coursepageid) {
		this.coursepageid = coursepageid;
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
	 * @return the enabled
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the haspassword
	 */
	public int getHaspassword() {
		return haspassword;
	}

	/**
	 * @param haspassword the haspassword to set
	 */
	public void setHaspassword(int haspassword) {
		this.haspassword = haspassword;
	}

	/**
	 * 
	 */
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param coursepageid
	 * @param enabled
	 * @param haspassword
	 */
	public Trainee(Long id,
			@Length(max = 100, message = "error.user.email.length") @NotEmpty(message = "error.user.email.empty") @Email(message = "error.user.email.email") String email,
			@Length(max = 100, message = "error.user.password.length") String password,
			@Length(max = 50, message = "error.user.firstname.length") String firstname,
			@Length(max = 50, message = "error.user.firstname.length") String lastname, Long coursepageid, int enabled,
			int haspassword) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.coursepageid = coursepageid;
		this.enabled = enabled;
		this.haspassword = haspassword;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", coursepageid=" + coursepageid + ", enabled=" + enabled
				+ ", haspassword=" + haspassword + "]";
	}

	

}
