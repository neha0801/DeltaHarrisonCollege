package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_WEEKDAY database table.
 * 
 */
@Entity
@Table(name="H_WEEKDAY", schema="TESTDB")
@NamedQuery(name="HWeekday.findAll", query="SELECT h FROM HWeekday h")
public class HWeekday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WEEKDAY_ID")
	private long weekdayId;

	private String name;

	//bi-directional many-to-one association to HClassSchedule
	@OneToMany(mappedBy="HWeekday")
	private List<HClassSchedule> HClassSchedules;

	public HWeekday() {
	}

	public long getWeekdayId() {
		return this.weekdayId;
	}

	public void setWeekdayId(long weekdayId) {
		this.weekdayId = weekdayId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<HClassSchedule> getHClassSchedules() {
		return this.HClassSchedules;
	}

	public void setHClassSchedules(List<HClassSchedule> HClassSchedules) {
		this.HClassSchedules = HClassSchedules;
	}

	public HClassSchedule addHClassSchedule(HClassSchedule HClassSchedule) {
		getHClassSchedules().add(HClassSchedule);
		HClassSchedule.setHWeekday(this);

		return HClassSchedule;
	}

	public HClassSchedule removeHClassSchedule(HClassSchedule HClassSchedule) {
		getHClassSchedules().remove(HClassSchedule);
		HClassSchedule.setHWeekday(null);

		return HClassSchedule;
	}

}