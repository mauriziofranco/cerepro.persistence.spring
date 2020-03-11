/**
 * 
 */
package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author marco morgana
 *
 */
@Entity
@Table( name = "NoteTemplate" )
public class NoteTemplate extends CeReProAbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "error.notetemplate.title.blank")
    @Length(max = 100, message = "error.notetemplate.title.length")
	@Column(name = "title")
	private String title;
	
    @NotBlank(message = "error.notetemplate.content.blank")
    @Length(max = 2000, message = "error.notetemplate.content.length")
	@Column(name = "content")
	private String content;

    public NoteTemplate() {}
    
    public NoteTemplate(Long Id, String title, String content) {
    	this.id = Id;
    	this.title = title;
    	this.content = content;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NoteTemplate [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
}
