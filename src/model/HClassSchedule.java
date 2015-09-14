package model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the H_CLASS_SCHEDULE database table.
 * 
 */
@Entity
@Table(name="H_CLASS_SCHEDULE", schema="TESTDB")
@NamedQuery(name="HClassSchedule.findAll", query="SELECT h FROM HClassSchedule h")
public class HClassSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLASS_SCHEDULE_ID")
	private long classScheduleId;

	@Column(name="CLASS_TIME")
	private int classTime;

	//bi-directional many-to-one association to HClass
	@ManyToOne
	@JoinColumn(name="CLASS_ID")
	private HClass HClass;

	//bi-directional many-to-one association to HWeekday
	@ManyToOne
	@JoinColumn(name="WEEKDAY_ID")
	private HWeekday HWeekday;

	public HClassSchedule() {
	}

	public long getClassScheduleId() {
		return this.classScheduleId;
	}

	public void setClassScheduleId(long classScheduleId) {
		this.classScheduleId = classScheduleId;
	}

	public int getClassTime() {
		return this.classTime;
	}

	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}

	public HClass getHClass() {
		return this.HClass;
	}

	public void setHClass(HClass HClass) {
		this.HClass = HClass;
	}

	public HWeekday getHWeekday() {
		return this.HWeekday;
	}

	public void setHWeekday(HWeekday HWeekday) {
		this.HWeekday = HWeekday;
	}

}