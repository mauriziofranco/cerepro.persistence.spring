package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * The persistent class for the roles database table.
 *	@author joffre
 */
@Entity
@Table( name = "roles" )
public class Role extends CeReProAbstractEntity{
	
	public static final int JAVA_COURSE_CANDIDATE_LEVEL = 90 ;
	public static final int ITCONSULTANT_LEVEL = 50 ;
	
	@Id //specifies that this field is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull(message = "error.survey.label.null")
	@NotEmpty(message = "error.survey.label.empty")
	@Column(name = "label")
	private String label;
		
	
	@Length(max = 100, message = "error.survey.description.length")
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "error.role.level.empty")
	@Column(name = "level")
	private int level;

	
	
	public Role () {}
	
	public Role (String label, String description, int level) {
		this.label = label;
		this.description = description;
		this.level=level;
	}
	
	public Role (Long id, String label, String description, int level) {
		this.id = id;
		this.label = label;
		this.description = description;
		this.level=level;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Provides a full debug of the entity
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" level: ").append(level);
		sb.append("\n");

		return sb.toString();
	}
}
