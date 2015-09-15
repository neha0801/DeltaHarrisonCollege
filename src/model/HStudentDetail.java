package model;

import java.io.Serializable;

import javax.persistence.*;

import db.DBEnrollment;

import java.util.List;


/**
 * The persistent class for the H_STUDENT_DETAIL database table.
 * 
 */
@Entity
@Table(name="H_STUDENT_DETAIL", schema="TESTDB")
@NamedQuery(name="HStudentDetail.findAll", query="SELECT h FROM HStudentDetail h")
public class HStudentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	@Column(name="ENTRY_YEAR")
	private String entryYear;

	@Column(name="STUDENT_NUMBER")
	private String studentNumber;

	//bi-directional many-to-one association to HEnrollment
	@OneToMany(mappedBy="HStudentDetail")
	private List<HEnrollment> HEnrollments;

	//bi-directional many-to-one association to HMajor
	@ManyToOne
	@JoinColumn(name="MAJOR_ID")
	private HMajor HMajor;

	//bi-directional one-to-one association to HUser
	@OneToOne
	@JoinColumn(name="USER_ID" ,  insertable=false, updatable=false)
	private HUser HUser;

	public HStudentDetail() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEntryYear() {
		return this.entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public List<HEnrollment> getHEnrollments() {
		return this.HEnrollments;
	}

	public void setHEnrollments(List<HEnrollment> HEnrollments) {
		this.HEnrollments = HEnrollments;
	}

	public HEnrollment addHEnrollment(HEnrollment HEnrollment) {
		getHEnrollments().add(HEnrollment);
		HEnrollment.setHStudentDetail(this);

		return HEnrollment;
	}

	public HEnrollment removeHEnrollment(HEnrollment HEnrollment) {
		getHEnrollments().remove(HEnrollment);
		HEnrollment.setHStudentDetail(null);

		return HEnrollment;
	}

	public HMajor getHMajor() {
		return this.HMajor;
	}

	public void setHMajor(HMajor HMajor) {
		this.HMajor = HMajor;
	}

	public HUser getHUser() {
		return this.HUser;
	}

	public void setHUser(HUser HUser) {
		this.HUser = HUser;
	}
	
	
	public String getOverallGPA(){
		double sum=0.0;
		double gpa=0.0;
		int counter  = 0;
		for(HEnrollment e:HEnrollments){

			if (e.getGrade() == null)
			{
				continue;
			}
			else
			{
				sum+=DBEnrollment.getGrade(e.getGrade());
				counter++;
			}
		}
		gpa=sum/counter;
		return String.format("%.2f",gpa);
	}
	
	

}