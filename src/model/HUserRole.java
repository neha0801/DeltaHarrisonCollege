package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the H_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="H_USER_ROLE")
@NamedQuery(name="HUserRole.findAll", query="SELECT h FROM HUserRole h")
public class HUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ROLE_ID")
	private long userRoleId;

	
	@Column(name="ROLE_STATUS")
	private String roleStatus;
	

	//bi-directional many-to-one association to HRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private HRole HRole;

	//bi-directional many-to-one association to HUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private HUser HUser;
	
	
	
	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public HRole getHRole() {
		return HRole;
	}

	public void setHRole(HRole hRole) {
		HRole = hRole;
	}

	public HUser getHUser() {
		return HUser;
	}

	public void setHUser(HUser hUser) {
		HUser = hUser;
	}

	public HUserRole() {
	}

	public long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}





}