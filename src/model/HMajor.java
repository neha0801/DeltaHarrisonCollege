package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_MAJOR database table.
 * 
 */
@Entity
@Table(name="H_MAJOR", schema="TESTDB")
@NamedQuery(name="HMajor.findAll", query="SELECT h FROM HMajor h")
public class HMajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAJOR_ID")
	private long majorId;

	private String name;

	private String status;

	//bi-directional many-to-one association to HCourse
	@OneToMany(mappedBy="HMajor")
	private List<HCourse> HCourses;

	//bi-directional many-to-one association to HDepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private HDepartment HDepartment;

	//bi-directional many-to-one association to HStudentDetail
	@OneToMany(mappedBy="HMajor")
	private List<HStudentDetail> HStudentDetails;

	public HMajor() {
	}

	public long getMajorId() {
		return this.majorId;
	}

	public void setMajorId(long majorId) {
		this.majorId = majorId;
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

	public List<HCourse> getHCourses() {
		return this.HCourses;
	}

	public void setHCourses(List<HCourse> HCourses) {
		this.HCourses = HCourses;
	}

	public HCourse addHCours(HCourse HCours) {
		getHCourses().add(HCours);
		HCours.setHMajor(this);

		return HCours;
	}

	public HCourse removeHCours(HCourse HCours) {
		getHCourses().remove(HCours);
		HCours.setHMajor(null);

		return HCours;
	}

	public HDepartment getHDepartment() {
		return this.HDepartment;
	}

	public void setHDepartment(HDepartment HDepartment) {
		this.HDepartment = HDepartment;
	}

	public List<HStudentDetail> getHStudentDetails() {
		return this.HStudentDetails;
	}

	public void setHStudentDetails(List<HStudentDetail> HStudentDetails) {
		this.HStudentDetails = HStudentDetails;
	}

	public HStudentDetail addHStudentDetail(HStudentDetail HStudentDetail) {
		getHStudentDetails().add(HStudentDetail);
		HStudentDetail.setHMajor(this);

		return HStudentDetail;
	}

	public HStudentDetail removeHStudentDetail(HStudentDetail HStudentDetail) {
		getHStudentDetails().remove(HStudentDetail);
		HStudentDetail.setHMajor(null);

		return HStudentDetail;
	}

}