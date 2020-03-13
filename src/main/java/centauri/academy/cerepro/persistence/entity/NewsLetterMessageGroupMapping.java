package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * 
 * The persistent class for the news_letter_message_group_mapping database table.
 *	@author Jefersson Serrano
 */
@Entity
@Table( name = "news_letter_message_group_mapping" )
public class NewsLetterMessageGroupMapping extends CeReProAbstractEntity{
	
	@Id //specifies that this field is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="it_consultant_group_id")
	@NotNull(message = "error.newsLetterMessageGroupMapping.consultantGroupId.empty")
	@NotEmpty(message = "error.newsLetterMessageGroupMapping.consultantGroupId.empty")
	private long consultantGroupId;
	
	@Column(name="news_letter_message_id")
	@NotNull(message = "error.newsLetterMessageGroupMapping.newsLetterMessageId.empty")
	@NotEmpty(message = "error.newsLetterMessageGroupMapping.newsLetterMessageId.empty")
	private long newsLetterMessageId;

	/**
	 * 
	 */
	public NewsLetterMessageGroupMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param consultantGroupId
	 * @param newsLetterMessageId
	 */
	public NewsLetterMessageGroupMapping(Long id,
			@NotNull(message = "error.newsLetterMessageGroupMapping.consultantGroupId.empty") @NotEmpty(message = "error.newsLetterMessageGroupMapping.consultantGroupId.empty") long consultantGroupId,
			@NotNull(message = "error.newsLetterMessageGroupMapping.newsLetterMessageId.empty") @NotEmpty(message = "error.newsLetterMessageGroupMapping.newsLetterMessageId.empty") long newsLetterMessageId) {
		super();
		this.id = id;
		this.consultantGroupId = consultantGroupId;
		this.newsLetterMessageId = newsLetterMessageId;
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
	 * @return the consultantGroupId
	 */
	public long getConsultantGroupId() {
		return consultantGroupId;
	}

	/**
	 * @param consultantGroupId the consultantGroupId to set
	 */
	public void setConsultantGroupId(long consultantGroupId) {
		this.consultantGroupId = consultantGroupId;
	}

	/**
	 * @return the newsLetterMessageId
	 */
	public long getNewsLetterMessageId() {
		return newsLetterMessageId;
	}

	/**
	 * @param newsLetterMessageId the newsLetterMessageId to set
	 */
	public void setNewsLetterMessageId(long newsLetterMessageId) {
		this.newsLetterMessageId = newsLetterMessageId;
	}

	@Override
	public String toString() {
		return "NewsLetterMessageGroupMapping [id=" + id + ", consultantGroupId=" + consultantGroupId
				+ ", newsLetterMessageId=" + newsLetterMessageId + "]";
	}
	
	
	
}
