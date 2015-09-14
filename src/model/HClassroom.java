package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the H_CLASSROOM database table.
 * 
 */
@Entity
@Table(name="H_CLASSROOM", schema="TESTDB")
@NamedQuery(name="HClassroom.findAll", query="SELECT h FROM HClassroom h")
public class HClassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLASSROOM_ID")
	private long classroomId;

	@Column(name="BUILDING_NAME")
	private String buildingName;

	@Column(name="MAX_CAPACITY")
	private int maxCapacity;

	@Column(name="ROOM_NUMBER")
	private String roomNumber;

	private String status;

	//bi-directional many-to-one association to HClass
	@OneToMany(mappedBy="HClassroom")
	private List<HClass> HClasses;

	public HClassroom() {
	}

	public long getClassroomId() {
		return this.classroomId;
	}

	public void setClassroomId(long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
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
		HClass.setHClassroom(this);

		return HClass;
	}

	public HClass removeHClass(HClass HClass) {
		getHClasses().remove(HClass);
		HClass.setHClassroom(null);

		return HClass;
	}

}