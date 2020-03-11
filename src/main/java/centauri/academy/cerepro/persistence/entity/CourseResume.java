package centauri.academy.cerepro.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="course_resume")
public class CourseResume extends CeReProAbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String code;
	@NotNull(message = "error.courseresume.content.empty")
	private String content;
	@NotNull(message = "error.courseresume.title.empty")
	private String title;
		
	public CourseResume() {
	}
	
	public CourseResume (String code, String content, String title) {
		this.code = code;
		this.content = content;
		this.title = title;
	}
	
	public CourseResume (Long id, String code, String content, String title) {
		this.id = id;
		this.code = code;
		this.content = content;
		this.title = title;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}