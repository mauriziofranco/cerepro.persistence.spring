package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Question
 * 
 * This is the entity that maps table questions.
 * 
 * @author daniele piccinni
 *
 */

@Entity //specifies that class Question is an Hibernate entity
@Table( name = "questions" ) //connect this entity with database table which have name "questions"
//senza la riga @table lui cerca una tabella con il nome che coincide con il nome della classe
//controlla inoltre che gli attributi coincidano con le colonne della tabella
public class Question extends CeReProAbstractEntity {

//	attributi
	@Id //specifies that this field is a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //specifies that this field is auto increment by db's language
	private long id;
	
	@NotNull(message="error.question.label.notnull")
	@Length(min=3, max=500, message="error.question.label.length")
	private String label;
	
	@Length(max=3000, message="error.question.description.length")
	private String description;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansa;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansb;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansc;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansd;
	
	@Length(max=250, message="error.question.answer.length")
	private String anse;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansf;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansg;
	
	@Length(max=250, message="error.question.answer.length")
	private String ansh;
	
	private Boolean cansa;
	private Boolean cansb;
	private Boolean cansc;
	private Boolean cansd;
	private Boolean canse;
	private Boolean cansf;
	private Boolean cansg;
	private Boolean cansh;
	
	@Length(max=3000, message="error.question.fullanswer.length")
	@Column(name="full_answer")
	private String fullAnswer;

//	costruttori
	public Question(long id, String label, String description, String ansa, Boolean cansa) {
		this();
		this.id = id;
		this.label = label;
		this.description = description;
		this.ansa = ansa;
		this.cansa = cansa;
	}
	
	public Question(long id, String label, String description) {
		this();
		this.id = id;
		this.label = label;
		this.description = description;
	}
	
	public Question(long id, String label) {
		this();
		this.id = id;
		this.label = label;
	}
	
	public Question(String label) {
		this();
		this.label = label;
	}

	public Question() {
		
	}

	// getters and setters
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the ansa
	 */
	public String getAnsa() {
		return ansa;
	}

	/**
	 * @param ansa the ansa to set
	 */
	public void setAnsa(String ansa) {
		this.ansa = ansa;
	}

	/**
	 * @return the ansb
	 */
	public String getAnsb() {
		return ansb;
	}

	/**
	 * @param ansb the ansb to set
	 */
	public void setAnsb(String ansb) {
		this.ansb = ansb;
	}

	/**
	 * @return the ansc
	 */
	public String getAnsc() {
		return ansc;
	}

	/**
	 * @param ansc the ansc to set
	 */
	public void setAnsc(String ansc) {
		this.ansc = ansc;
	}

	/**
	 * @return the ansd
	 */
	public String getAnsd() {
		return ansd;
	}

	/**
	 * @param ansd the ansd to set
	 */
	public void setAnsd(String ansd) {
		this.ansd = ansd;
	}

	/**
	 * @return the anse
	 */
	public String getAnse() {
		return anse;
	}

	/**
	 * @param anse the anse to set
	 */
	public void setAnse(String anse) {
		this.anse = anse;
	}

	/**
	 * @return the ansf
	 */
	public String getAnsf() {
		return ansf;
	}

	/**
	 * @param ansf the ansf to set
	 */
	public void setAnsf(String ansf) {
		this.ansf = ansf;
	}

	/**
	 * @return the ansg
	 */
	public String getAnsg() {
		return ansg;
	}

	/**
	 * @param ansg the ansg to set
	 */
	public void setAnsg(String ansg) {
		this.ansg = ansg;
	}

	/**
	 * @return the ansh
	 */
	public String getAnsh() {
		return ansh;
	}

	/**
	 * @param ansh the ansh to set
	 */
	public void setAnsh(String ansh) {
		this.ansh = ansh;
	}

	/**
	 * @return the cansa
	 */
	public Boolean getCansa() {
		return cansa;
	}

	/**
	 * @param cansa the cansa to set
	 */
	public void setCansa(Boolean cansa) {
		this.cansa = cansa;
	}

	/**
	 * @return the cansb
	 */
	public Boolean getCansb() {
		return cansb;
	}

	/**
	 * @param cansb the cansb to set
	 */
	public void setCansb(Boolean cansb) {
		this.cansb = cansb;
	}

	/**
	 * @return the cansc
	 */
	public Boolean getCansc() {
		return cansc;
	}

	/**
	 * @param cansc the cansc to set
	 */
	public void setCansc(Boolean cansc) {
		this.cansc = cansc;
	}

	/**
	 * @return the cansd
	 */
	public Boolean getCansd() {
		return cansd;
	}

	/**
	 * @param cansd the cansd to set
	 */
	public void setCansd(Boolean cansd) {
		this.cansd = cansd;
	}

	/**
	 * @return the canse
	 */
	public Boolean getCanse() {
		return canse;
	}

	/**
	 * @param canse the canse to set
	 */
	public void setCanse(Boolean canse) {
		this.canse = canse;
	}

	/**
	 * @return the cansf
	 */
	public Boolean getCansf() {
		return cansf;
	}

	/**
	 * @param cansf the cansf to set
	 */
	public void setCansf(Boolean cansf) {
		this.cansf = cansf;
	}

	/**
	 * @return the cansg
	 */
	public Boolean getCansg() {
		return cansg;
	}

	/**
	 * @param cansg the cansg to set
	 */
	public void setCansg(Boolean cansg) {
		this.cansg = cansg;
	}

	/**
	 * @return the cansh
	 */
	public Boolean getCansh() {
		return cansh;
	}

	/**
	 * @param cansh the cansh to set
	 */
	public void setCansh(Boolean cansh) {
		this.cansh = cansh;
	}

	/**
	 * @return the fullAnswer
	 */
	public String getFullAnswer() {
		return fullAnswer;
	}

	/**
	 * @param fullAnswer the fullAnswer to set
	 */
	public void setFullAnswer(String fullAnswer) {
		this.fullAnswer = fullAnswer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ").append(id);
		sb.append(" - label: ").append(label);
		sb.append(" - description: ").append(description);
		sb.append(" - ansa: ").append(ansa);
		sb.append(" - ansb: ").append(ansb);
		sb.append(" - ansc: ").append(ansc);
		sb.append(" - ansd: ").append(ansd);
		sb.append(" - anse: ").append(anse);
		sb.append(" - ansf: ").append(ansf);
		sb.append(" - ansg: ").append(ansg);
		sb.append(" - ansh: ").append(ansh);
		sb.append(" - cansa: ").append(cansa);
		sb.append(" - cansb: ").append(cansb);
		sb.append(" - cansc: ").append(cansc);
		sb.append(" - cansd: ").append(cansd);
		sb.append(" - canse: ").append(canse);
		sb.append(" - cansf: ").append(cansf);
		sb.append(" - cansg: ").append(cansg);
		sb.append(" - cansh: ").append(cansh);
		sb.append(" - fullAnswer: ").append(fullAnswer);
		return sb.toString();
	}

	
}
