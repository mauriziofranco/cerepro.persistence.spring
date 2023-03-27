package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author giammarco
 *
 */
@Entity
@Table(name = "surveyquestion_role")
public class SurveyQuestionRole extends CeReProAbstractEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "surveyquestion_id")
    private SurveyQuestion surveyQuestion;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

	public SurveyQuestionRole(Long id, SurveyQuestion surveyQuestion, Role role) {
		super();
		this.id = id;
		this.surveyQuestion = surveyQuestion;
		this.role = role;
	}

	public SurveyQuestionRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SurveyQuestion getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    
    
}
