
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
 * Employee
 * 
 * This is the entity that maps table employee.
 * 
 * @author Dario
 * @author Marcov
 */
@Entity // declaring this as an entity
@Table( name = "employees" ) // specifying the name of the table to which this object refers, if the names coincide, it is not necessary

public class Employee extends CeReProAbstractEntity {

	/**
	 * @param args
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column(name="user_id")
	@NotNull(message = "error.employee.userId.empty")
	private Long userId;
	
	@Column(name="domicile_city")
	@Length(max = 100, message = "error.employee.domicileCity.length")
	private String domicileCity;
	
	@Column(name="domicile_street_name")
	@Length(max = 100, message = "error.employee.domicileStreetName.length")
	private String domicileStreetName;
	
	@Column(name="domicile_house_number")
	@Length(max = 100, message = "error.employee.domicileHouseNumber.length")
	private String domicileHouseNumber;
	
	@Column(name="mobile")
	@Length(max = 20, message = "error.employee.mobile.length")
	private String mobile;
	
	@Column(name="cv_external_path")
	@Length(max = 1000, message = "error.employee.cvExternalPath.length")
	private String cvExternalPath;
	
	public Employee(Long id, Long userId, String domicileCity, String domicileStreetName,
			String domicileHouseNumber, String mobile, String cvExternalPath) {
		super();
		this.id = id;
		this.userId = userId;
		this.domicileCity = domicileCity;
		this.domicileStreetName = domicileStreetName;
		this.domicileHouseNumber = domicileHouseNumber;
		this.mobile = mobile;
		this.cvExternalPath = cvExternalPath;
	}
	
	public Employee() {
		
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
	
}

