package model;

import java.io.Serializable;

import javax.persistence.*;

import db.DBCreditTuition;
import db.DBSemester;

import java.text.DecimalFormat;
import java.util.List;


/**
 * The persistent class for the H_DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="H_DEPARTMENT", schema="TESTDB")
@NamedQuery(name="HDepartment.findAll", query="SELECT h FROM HDepartment h")
public class HDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	private String name;

	private String status;

	//bi-directional many-to-one association to HMajor
	@OneToMany(mappedBy="HDepartment")
	private List<HMajor> HMajors;

	//bi-directional many-to-one association to HStaffDetail
	@OneToMany(mappedBy="HDepartment")
	private List<HStaffDetail> HStaffDetails;

	public HDepartment() {
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
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

	public List<HMajor> getHMajors() {
		return this.HMajors;
	}

	public void setHMajors(List<HMajor> HMajors) {
		this.HMajors = HMajors;
	}

	public HMajor addHMajor(HMajor HMajor) {
		getHMajors().add(HMajor);
		HMajor.setHDepartment(this);

		return HMajor;
	}

	public HMajor removeHMajor(HMajor HMajor) {
		getHMajors().remove(HMajor);
		HMajor.setHDepartment(null);

		return HMajor;
	}

	public List<HStaffDetail> getHStaffDetails() {
		return this.HStaffDetails;
	}

	public void setHStaffDetails(List<HStaffDetail> HStaffDetails) {
		this.HStaffDetails = HStaffDetails;
	}

	public HStaffDetail addHStaffDetail(HStaffDetail HStaffDetail) {
		getHStaffDetails().add(HStaffDetail);
		HStaffDetail.setHDepartment(this);

		return HStaffDetail;
	}

	public HStaffDetail removeHStaffDetail(HStaffDetail HStaffDetail) {
		getHStaffDetails().remove(HStaffDetail);
		HStaffDetail.setHDepartment(null);

		return HStaffDetail;
	}
	
	public String getRevenue(String semesterIdStr){
		int credits =0;
		double revenue=0.0;
		HCreditTuition creditFee= null;
		if(semesterIdStr!=null){
			long semesterId = Long.parseLong(semesterIdStr);
			
			for(HMajor major : this.HMajors){			
				for(HCourse course : major.getHCourses())
				{
					for(HClass currentClass : course.getHClasses())
					{
						for(HEnrollment enrollment: currentClass.getHEnrollments())
						{
							long checkSemId = currentClass.getHSemester().getSemesterId();
							if(checkSemId==semesterId)
							{
								credits = course.getCredits();
								creditFee = DBCreditTuition.getCreditTuitionFee(currentClass.getHCreditTuition().getCreditTuitionId());
								revenue += credits*creditFee.getCreditFee();
							}
						}
					}
				}				
				
			}
		}
		System.out.println("revenue by department");
		String revenueStr = DecimalFormat.getCurrencyInstance().format(revenue);
		return revenueStr;
	}

}