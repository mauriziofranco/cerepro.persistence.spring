package centauri.academy.cerepro.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="origin_sites")
public class OriginSite extends CeReProAbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String imgpath;
	@NotBlank
	private String label;

	public OriginSite() {
	}
	
	public OriginSite(Long id, String description, String imgpath, String label) {
		this.id=id;
		this.description=description;
		this.imgpath=imgpath;
		this.label=label;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgpath() {
		return this.imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OriginSite [id=" + id + ", description=" + description + ", imgpath=" + imgpath + ", label=" + label
				+ "]";
	}
	
	

}