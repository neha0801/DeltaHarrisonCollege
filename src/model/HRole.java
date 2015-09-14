package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_ROLE database table.
 * 
 */
@Entity
@Table(name="H_ROLE", schema="TESTDB")
@NamedQuery(name="HRole.findAll", query="SELECT h FROM HRole h")
public class HRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID")
	private long roleId;

	private String name;

	//bi-directional many-to-one association to HUserRole
	@OneToMany(mappedBy="HRole")
	private List<HUserRole> HUserRoles;

	public HRole() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HUserRole> getHUserRoles() {
		return this.HUserRoles;
	}

	public void setHUserRoles(List<HUserRole> HUserRoles) {
		this.HUserRoles = HUserRoles;
	}

	public HUserRole addHUserRole(HUserRole HUserRole) {
		getHUserRoles().add(HUserRole);
		HUserRole.setHRole(this);

		return HUserRole;
	}

	public HUserRole removeHUserRole(HUserRole HUserRole) {
		getHUserRoles().remove(HUserRole);
		HUserRole.setHRole(null);

		return HUserRole;
	}

}