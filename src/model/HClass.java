package model;

import java.io.Serializable;

import javax.persistence.*;

import db.DBUserDetail;

import java.util.List;


/**
 * The persistent class for the H_CLASS database table.
 * 
 */
@Entity
@Table(name="H_CLASS", schema="TESTDB")
@NamedQuery(name="HClass.findAll", query="SELECT h FROM HClass h")
public class HClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLASS_ID")
	private long classId;

	private String status;

	//bi-directional many-to-one association to HClassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOM_ID")
	private HClassroom HClassroom;

	//bi-directional many-to-one association to HCourse
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private HCourse HCourse;

	//bi-directional many-to-one association to HSemester
	@ManyToOne
	@JoinColumn(name="SEMESTER_ID")
	private HSemester HSemester;

	//bi-directional many-to-one association to HStaffDetail
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private HStaffDetail HStaffDetail;

	//bi-directional many-to-one association to HClassSchedule
	@OneToMany(mappedBy="HClass")
	private List<HClassSchedule> HClassSchedules;

	//bi-directional many-to-one association to HEnrollment
	@OneToMany(mappedBy="HClass")
	private List<HEnrollment> HEnrollments;

	public HClass() {
	}

	public long getClassId() {
		return this.classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HClassroom getHClassroom() {
		return this.HClassroom;
	}

	public void setHClassroom(HClassroom HClassroom) {
		this.HClassroom = HClassroom;
	}

	public HCourse getHCourse() {
		return this.HCourse;
	}

	public void setHCourse(HCourse HCourse) {
		this.HCourse = HCourse;
	}

	public HSemester getHSemester() {
		return this.HSemester;
	}

	public void setHSemester(HSemester HSemester) {
		this.HSemester = HSemester;
	}

	public HStaffDetail getHStaffDetail() {
		return this.HStaffDetail;
	}

	public void setHStaffDetail(HStaffDetail HStaffDetail) {
		this.HStaffDetail = HStaffDetail;
	}

	public List<HClassSchedule> getHClassSchedules() {
		return this.HClassSchedules;
	}

	public void setHClassSchedules(List<HClassSchedule> HClassSchedules) {
		this.HClassSchedules = HClassSchedules;
	}

	public HClassSchedule addHClassSchedule(HClassSchedule HClassSchedule) {
		getHClassSchedules().add(HClassSchedule);
		HClassSchedule.setHClass(this);

		return HClassSchedule;
	}

	public HClassSchedule removeHClassSchedule(HClassSchedule HClassSchedule) {
		getHClassSchedules().remove(HClassSchedule);
		HClassSchedule.setHClass(null);

		return HClassSchedule;
	}

	public List<HEnrollment> getHEnrollments() {
		return this.HEnrollments;
	}

	public void setHEnrollments(List<HEnrollment> HEnrollments) {
		this.HEnrollments = HEnrollments;
	}

	public HEnrollment addHEnrollment(HEnrollment HEnrollment) {
		getHEnrollments().add(HEnrollment);
		HEnrollment.setHClass(this);

		return HEnrollment;
	}

	public HEnrollment removeHEnrollment(HEnrollment HEnrollment) {
		getHEnrollments().remove(HEnrollment);
		HEnrollment.setHClass(null);

		return HEnrollment;
	}
	public int getCurrentAvailability(){
		return HClassroom.getMaxCapacity()-HEnrollments.size();
	}
	
	public String getClassSchedule()
	{
		List<HClassSchedule> schedules = this.getHClassSchedules();
		String scheduleStr = "";
		
		for (HClassSchedule schedule : schedules)
		{
			scheduleStr += schedule.getHWeekday().getName() + " at " + schedule.getClassTime() + ":00";
		}
		return scheduleStr;
	}
	
	public boolean hasEnrolled(long userId)
	{
		System.out.println("user id = " + userId);
		boolean hasEnrolled = false;
		HUser user = DBUserDetail.getUser(userId);
		
		List<HEnrollment> enrollments = user.getHStudentDetail().getHEnrollments();
		
		for(HEnrollment enrollment : enrollments )
		{
			if (this.getClassId() == enrollment.getHClass().getClassId())
			{
				hasEnrolled = true;
				break;
			}
		}
		return hasEnrolled;
	}
	public String getClassroom()
	{
		String classroomStr = "";
		System.out.println("building " + this.getHClassroom().getBuildingName());
		classroomStr = this.getHClassroom().getBuildingName() + " Room# " + this.getHClassroom().getRoomNumber();
		
		return classroomStr;
	}
}