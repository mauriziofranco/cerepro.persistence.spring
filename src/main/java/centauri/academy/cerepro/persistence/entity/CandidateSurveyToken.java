package centauri.academy.cerepro.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * The persistence entity class for the candidatesurveytokens database table
 * 
 * 
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
