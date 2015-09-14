package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="H_DEPARTMENT", schema="TESTDB")
@NamedQuery(name="HDepartment.findAll", query="SELECT h FROM HDepartment h")
public class HDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	private String name;

	private String status;

	//bi-directional many-to-one association to HMajor
	@OneToMany(mappedBy="HDepartment")
	private List<HMajor> HMajors;

	//bi-directional many-to-one association to HStaffDetail
	@OneToMany(mappedBy="HDepartment")
	private List<HStaffDetail> HStaffDetails;

	public HDepartment() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<HMajor> getHMajors() {
		return this.HMajors;
	}

	public void setHMajors(List<HMajor> HMajors) {
		this.HMajors = HMajors;
	}

	public HMajor addHMajor(HMajor HMajor) {
		getHMajors().add(HMajor);
		HMajor.setHDepartment(this);

		return HMajor;
	}

	public HMajor removeHMajor(HMajor HMajor) {
		getHMajors().remove(HMajor);
		HMajor.setHDepartment(null);

		return HMajor;
	}

	public List<HStaffDetail> getHStaffDetails() {
		return this.HStaffDetails;
	}

	public void setHStaffDetails(List<HStaffDetail> HStaffDetails) {
		this.HStaffDetails = HStaffDetails;
	}

	public HStaffDetail addHStaffDetail(HStaffDetail HStaffDetail) {
		getHStaffDetails().add(HStaffDetail);
		HStaffDetail.setHDepartment(this);

		return HStaffDetail;
	}

	public HStaffDetail removeHStaffDetail(HStaffDetail HStaffDetail) {
		getHStaffDetails().remove(HStaffDetail);
		HStaffDetail.setHDepartment(null);

		return HStaffDetail;
	}

}