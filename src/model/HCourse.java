package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the H_COURSE database table.
 * 
 */
@Entity
@Table(name="H_COURSE", schema="TESTDB")
@NamedQuery(name="HCourse.findAll", query="SELECT h FROM HCourse h")
public class HCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COURSE_ID")
	private long courseId;

	@Column(name="COURSE_NUMBER")
	private String courseNumber;

	private int credits;

	private String description;

	private String name;

	private String status;

	//bi-directional many-to-one association to HClass
	@OneToMany(mappedBy="HCourse")
	private List<HClass> HClasses;

	//bi-directional many-to-one association to HMajor
	@ManyToOne
	@JoinColumn(name="MAJOR_ID")
	private HMajor HMajor;

	//bi-directional many-to-one association to HSubject
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private HSubject HSubject;

	public HCourse() {
	}

	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseNumber() {
		return this.courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<HClass> getHClasses() {
		return this.HClasses;
	}

	public void setHClasses(List<HClass> HClasses) {
		this.HClasses = HClasses;
	}

	public HClass addHClass(HClass HClass) {
		getHClasses().add(HClass);
		HClass.setHCourse(this);

		return HClass;
	}

	public HClass removeHClass(HClass HClass) {
		getHClasses().remove(HClass);
		HClass.setHCourse(null);

		return HClass;
	}

	public HMajor getHMajor() {
		return this.HMajor;
	}

	public void setHMajor(HMajor HMajor) {
		this.HMajor = HMajor;
	}

	public HSubject getHSubject() {
		return this.HSubject;
	}

	public void setHSubject(HSubject HSubject) {
		this.HSubject = HSubject;
	}

}