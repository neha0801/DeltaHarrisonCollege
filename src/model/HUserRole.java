package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the H_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="H_USER_ROLE", schema="TESTDB")
@NamedQuery(name="HUserRole.findAll", query="SELECT h FROM HUserRole h")
public class HUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ROLE_ID")
	private long userRoleId;

	@Column(name="STATUS")
	private String status;
	
	//bi-directional many-to-one association to HRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private HRole HRole;

	//bi-directional many-to-one association to HUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private HUser HUser;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HUserRole() {
	}

	public long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}
	
	

	public HRole getHRole() {
		return this.HRole;
	}

	public void setHRole(HRole HRole) {
		this.HRole = HRole;
	}

	public HUser getHUser() {
		return this.HUser;
	}

	public void setHUser(HUser HUser) {
		this.HUser = HUser;
	}
	
	

}