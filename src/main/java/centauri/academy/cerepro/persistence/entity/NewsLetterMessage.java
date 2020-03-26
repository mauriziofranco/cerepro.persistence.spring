package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * 
 * The persistent class for the news_letter_message database table.
 *	@author Jefersson Serrano - Milan Centauri Academy 5th
 */
@Entity
@Table( name = "news_letter_message" )
public class NewsLetterMessage extends CeReProAbstractEntity{
	
	@Id //specifies that this field is a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@NotBlank(message = "error.newsLetterMessage.subject.blank")
    @Length(max = 250, message = "error.newsLetterMessage.subject.length")
	@Column(name = "message_subject")
	private String subject;
	
    @NotBlank(message = "error.newsLetterMessage.message.blank")
    @Length(max = 2000, message = "error.newsLetterMessage.message.length")
	@Column(name = "message_text")
	private String message;

	/**
	 * NewLetterMessageRepository
	 */
	public NewsLetterMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param subject
	 * @param message
	 */
	public NewsLetterMessage(Long id,String subject,String message) {
		this.id = id;
		this.subject = subject;
		this.message = message;
	}
	
	public NewsLetterMessage(String subject,String message) {
		this.subject = subject;
		this.message = message;
	}
	
	public NewsLetterMessage(String subject) {
		this.subject = subject;
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "NewsLetterMessage [id=" + id + ", subject=" + subject + ", message=" + message + "]";
	}




}
