package centauri.academy.cerepro.persistence.entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author TraianC - Milano Centauri Academy III
 * @author giacomo
 * 
 */

@Entity
@Table(name ="coursepage")

public class CoursePage extends CeReProAbstractEntity {
	
	public final static String GENERIC_CANDIDATURE_CODE = "MIGEN01" ;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
	@Length(max = 1000, message = "error.coursepage.title.length")
	@Column(name ="title")
	private String title;
	
	@NotEmpty(message = "error.coursepage.bodyText.empty")
	@Length(max = 50000, message = "error.coursepage.bodyText.length")
	@Column(name ="body_text")
	private String bodyText;
	
	@Length(max = 300, message = "error.coursepage.fileName.length")
	@Column(name ="file_name")
	private String fileName;
	
	@Length(max = 50, message = "error.coursepage.code.length")
	@Column(name ="code")
	private String code;

	public CoursePage(Long id, String bodyText, String fileName, String title) {
		this.id = id;
		this.bodyText = bodyText;
		this.title=title;
		this.fileName = fileName;
	}
	
	public CoursePage(String bodyText, String fileName, String title) {
		this.bodyText = bodyText;
		this.fileName = fileName;
		this.title=title;
	}

	public CoursePage() {
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
	 * @return the bodyText
	 */
	public String getBodyText() {
		return bodyText;
	}

	/**
	 * @param bodyText the bodyText to set
	 */
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" - bodyText: ").append(bodyText);
		sb.append(" - fileName: ").append(fileName);	
		return sb.toString();
		
	}
}
