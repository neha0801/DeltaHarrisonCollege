package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the H_SEMESTER database table.
 * 
 */
@Entity
@Table(name="H_SEMESTER", schema="TESTDB")
@NamedQuery(name="HSemester.findAll", query="SELECT h FROM HSemester h")
public class HSemester implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEMESTER_ID")
	private long semesterId;

	private String season;

	@Column(name="\"YEAR\"")
	private int year;

	//bi-directional many-to-one association to HClass
	@OneToMany(mappedBy="HSemester")
	private List<HClass> HClasses;

	public HSemester() {
	}

	public long getSemesterId() {
		return this.semesterId;
	}

	public void setSemesterId(long semesterId) {
		this.semesterId = semesterId;
	}

	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<HClass> getHClasses() {
		return this.HClasses;
	}

	public void setHClasses(List<HClass> HClasses) {
		this.HClasses = HClasses;
	}

	public HClass addHClass(HClass HClass) {
		getHClasses().add(HClass);
		HClass.setHSemester(this);

		return HClass;
	}

	public HClass removeHClass(HClass HClass) {
		getHClasses().remove(HClass);
		HClass.setHSemester(null);

		return HClass;
	}

	public String getSemester(){
		String semesterStr = "";

		semesterStr = this.season + "  " + this.year;

		return semesterStr;
	}
}