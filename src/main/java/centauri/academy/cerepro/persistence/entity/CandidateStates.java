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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Sebastiano Varchetta
 *
 */

@Entity
@Table(name = "candidate_states")
public class CandidateStates extends CeReProAbstractEntity {
	
	public final static int DEFAULT_INSERTING_STATUS_CODE = 100 ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@NotNull(message="error.candidatestates.roleid.notnull")
	@Min(value=1, message="error.candidatestates.roleid.min")
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@NotNull(message="error.candidatestates.statuscode.notnull")
	@Column(name = "STATUS_CODE")
	private int statusCode;
	
	
	@Column(name = "STATUS_LABEL")
	@Length(max = 100, message = "error.statuslabel.length")
	private String statusLabel;
	
	@Column(name = "STATUS_DESCRIPTION")
	@Length(max = 300, message = "error.statusdescription.length")
	private String  statusDescription;
	
	@Column(name = "STATUS_COLOR")
	@Length(max = 7, message = "error.statuscolor.length")
	private String statusColor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "CandidateStates [id=" + id + ", roleId=" + roleId + ", statusCode=" + statusCode + ", statusLabel="
				+ statusLabel + ", statusDescription=" + statusDescription + ", statusColor=" + statusColor
				+ ", getId()=" + getId() + ", getRoleId()=" + getRoleId() + ", getStatusLabel()=" + getStatusLabel()
				+ ", getStatusDescription()=" + getStatusDescription() + ", getStatusColor()=" + getStatusColor()
				+ ", getStatusCode()=" + getStatusCode() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
