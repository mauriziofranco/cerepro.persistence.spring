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
import javax.validation.constraints.NotNull;

/**
 * @author Fabio Li Greci
 *
 */
@Entity 
@Table(name = "surveyinterviews") 
public class SurveyInterview extends CeReProAbstractEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column (name="survey_id") 
	@NotNull(message = "error.surveyId.empty")
	private Long surveyId;
	
	@Column (name="interview_id") 
	@NotNull(message = "error.interviewId.empty")
	private Long interviewId;
	
	private int position;
	
	
	

	

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
	 * @return the surveyId
	 */
	public Long getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the interviewId
	 */
	public Long getInterviewId() {
		return interviewId;
	}

	/**
	 * @param interviewId the interviewId to set
	 */
	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SurveyInterview [id=" + id + ", surveyId=" + surveyId + ", interviewId=" + interviewId + ", position="
				+ position + "]";
	}
	
	

}
