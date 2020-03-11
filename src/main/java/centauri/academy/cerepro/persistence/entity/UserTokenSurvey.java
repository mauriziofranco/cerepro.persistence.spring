package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistence class for the usersurveytoken database table
 * @author Traian Cojocariu
 * @author Marco Fulgosi
 *
 */
@Entity
@Table( name = "usersurveytoken" )

public class UserTokenSurvey extends CeReProAbstractEntity {
	
	@Id //not null
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement in questo caso
	private Long id;
	@Column(name="userid")
	private Long userId ;
	@Column(name="surveyid")
	private Long surveyId ;
	private String generatedtoken ;
	private LocalDateTime expirationdate ;
	private boolean expired;
	
	public UserTokenSurvey(Long id, Long userid, Long surveyid, String generatedtoken,
			LocalDateTime expirationdate, boolean expired) {
		super();
		this.id = id;
		this.userId = userid;
		this.surveyId = surveyid;
		this.generatedtoken = generatedtoken;
		this.expirationdate = expirationdate;		
		this.expired = expired;
	}
	
	public UserTokenSurvey(Long userid) {
		this.userId=userid;
	}
	public UserTokenSurvey() {}
	
	
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
	 * @return the userid
	 */
	public Long getUserid() {
		return userId;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userId = userid;
	}

	/**
	 * @return the surveyid
	 */
	public Long getSurveyid() {
		return surveyId;
	}

	/**
	 * @param surveyid the surveyid to set
	 */
	public void setSurveyid(Long surveyid) {
		this.surveyId = surveyid;
	}

	/**
	 * @return the generatedtoken
	 */
	public String getGeneratedtoken() {
		return generatedtoken;
	}

	/**
	 * @param generatedtoken the generatedtoken to set
	 */
	public void setGeneratedtoken(String generatedtoken) {
		this.generatedtoken = generatedtoken;
	}

	/**
	 * @return the expirationdate
	 */
	public LocalDateTime getExpirationdate() {
		return expirationdate;
	}

	/**
	 * @param expirationdate the expirationdate to set
	 */
	public void setExpirationdate(LocalDateTime expirationdate) {
		this.expirationdate = expirationdate;
	}
	
	

	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/** provides a full debug of the UST entity*/
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append("userid: ").append(userId);
		sb.append("surveyid: ").append(surveyId);
		sb.append("generatedtoken: ").append(generatedtoken);
		sb.append("expirationdate: ").append(expirationdate);
		sb.append("expired: ").append(expired);

		return sb.toString();
		
	}


}
