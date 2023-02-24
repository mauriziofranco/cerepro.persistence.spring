package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistence class for the candidatesurveytokens database table
 * @author maurizio.franco@ymail.com
 *
 */
@Entity
@Table( name = "candidatesurveytokens" )
@Getter @Setter @NoArgsConstructor @ToString
public class CandidateSurveyToken extends CeReProAbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "error.candidatesurveytokens.candidateId.empty")	
	private Long candidateId ;
	
	@NotNull(message = "error.candidatesurveytokens.candidateId.empty")
	private Long surveyId ;
	
	@Size(max = 50)
	private String generatedToken ;
	
	private LocalDateTime expirationDateTime ;
	
	private boolean expired;

	/**
	 * @param id
	 * @param candidateId
	 * @param surveyId
	 * @param generatedToken
	 * @param expirationDateTime
	 * @param expired
	 */
	public CandidateSurveyToken(Long id,
			@NotNull(message = "error.candidatesurveytokens.candidateId.empty") Long candidateId,
			@NotNull(message = "error.candidatesurveytokens.candidateId.empty") Long surveyId,
			@Size(max = 50) String generatedToken, LocalDateTime expirationDateTime, boolean expired) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.surveyId = surveyId;
		this.generatedToken = generatedToken;
		this.expirationDateTime = expirationDateTime;
		this.expired = expired;
	}
	
}
