package centauri.academy.cerepro.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
/**
 * 
 * @author Fabio Li Greci
 */
@Entity 
@Table(name = "interviews") 
public class Interview extends CeReProAbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column (name="question_text") 
	@Length(max = 250)
	private String questionText;

	@Length(max = 250)
	private String ansa;

	@Length(max = 250)
	private String ansb;

	@Length(max = 250)
	private String ansc;

	@Length(max = 250)
	private String ansd;

	@Length(max = 250)
	private String anse;

	@Length(max = 250)
	private String ansf;

	@Length(max = 250)
	private String ansg;

	@Length(max = 250)
	private String ansh;

	@Length(max = 250)
	private String ansi;
	
	@Length(max = 250)
	private String ansj;

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
	 * @return the ansi
	 */
	public String getAnsi() {
		return ansi;
	}

	/**
	 * @param ansi the ansi to set
	 */
	public void setAnsi(String ansi) {
		this.ansi = ansi;
	}

	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * @return the ansj
	 */
	public String getAnsj() {
		return ansj;
	}

	/**
	 * @param ansj the ansj to set
	 */
	public void setAnsj(String ansj) {
		this.ansj = ansj;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Interview [id=" + id + ", questionText=" + questionText + ", ansa=" + ansa + ", ansb=" + ansb
				+ ", ansc=" + ansc + ", ansd=" + ansd + ", anse=" + anse + ", ansf=" + ansf + ", ansg=" + ansg
				+ ", ansh=" + ansh + ", ansi=" + ansi + ", ansj=" + ansj + "]";
	}

	
	

}
