package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the H_ENROLLMENT database table.
 * 
 */
@Entity
@Table(name="H_ENROLLMENT", schema="TESTDB")
@NamedQuery(name="HEnrollment.findAll", query="SELECT h FROM HEnrollment h")
public class HEnrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENROLLMENT_ID")
	private long enrollmentId;

	private String grade;

	private String status;

	//bi-directional many-to-one association to HClass
	@ManyToOne
	@JoinColumn(name="CLASS_ID")
	private HClass HClass;

	//bi-directional many-to-one association to HStudentDetail
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private HStudentDetail HStudentDetail;

	public HEnrollment() {
	}

	public long getEnrollmentId() {
		return this.enrollmentId;
	}

	public void setEnrollmentId(long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HClass getHClass() {
		return this.HClass;
	}

	public void setHClass(HClass HClass) {
		this.HClass = HClass;
	}

	public HStudentDetail getHStudentDetail() {
		return this.HStudentDetail;
	}

	public void setHStudentDetail(HStudentDetail HStudentDetail) {
		this.HStudentDetail = HStudentDetail;
	}

}