package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the H_STAFF_DETAIL database table.
 * 
 */
@Entity
@Table(name="H_STAFF_DETAIL", schema="TESTDB")
@NamedQuery(name="HStaffDetail.findAll", query="SELECT h FROM HStaffDetail h")
public class HStaffDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	@Column(name="EMPLOYEE_NUMBER")
	private String employeeNumber;

	@Column(name="OFFICE_NUMBER")
	private String officeNumber;

	//bi-directional many-to-one association to HClass
	@OneToMany(mappedBy="HStaffDetail")
	private List<HClass> HClasses;

	//bi-directional many-to-one association to HDepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private HDepartment HDepartment;

	
	//bi-directional one-to-one association to HUser
	@OneToOne
	@JoinColumn(name="USER_ID" ,  insertable=false, updatable=false)
	private HUser HUser;
	
	public HStaffDetail() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmployeeNumber() {
		return this.employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getOfficeNumber() {
		return this.officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	


	public HUser getHUser() {
		return this.HUser;
	}

	public void setHUser(HUser HUser) {
		this.HUser = HUser;
	}
	
	public List<HClass> getHClasses() {
		return this.HClasses;
	}

	public void setHClasses(List<HClass> HClasses) {
		this.HClasses = HClasses;
	}

	public HClass addHClass(HClass HClass) {
		getHClasses().add(HClass);
		HClass.setHStaffDetail(this);

		return HClass;
	}

	public HClass removeHClass(HClass HClass) {
		getHClasses().remove(HClass);
		HClass.setHStaffDetail(null);

		return HClass;
	}

	public HDepartment getHDepartment() {
		return this.HDepartment;
	}

	public void setHDepartment(HDepartment HDepartment) {
		this.HDepartment = HDepartment;
	}

}