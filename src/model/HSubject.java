package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_SUBJECT database table.
 * 
 */
@Entity
@Table(name="H_SUBJECT", schema="TESTDB")
@NamedQuery(name="HSubject.findAll", query="SELECT h FROM HSubject h")
public class HSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUBJECT_ID")
	private long subjectId;

	@Column(name="SUBJECT_CODE")
	private String subjectCode;

	//bi-directional many-to-one association to HCourse
	@OneToMany(mappedBy="HSubject")
	private List<HCourse> HCourses;

	public HSubject() {
	}

	public long getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public List<HCourse> getHCourses() {
		return this.HCourses;
	}

	public void setHCourses(List<HCourse> HCourses) {
		this.HCourses = HCourses;
	}

	public HCourse addHCours(HCourse HCours) {
		getHCourses().add(HCours);
		HCours.setHSubject(this);

		return HCours;
	}

	public HCourse removeHCours(HCourse HCours) {
		getHCourses().remove(HCours);
		HCours.setHSubject(null);

		return HCours;
	}

}