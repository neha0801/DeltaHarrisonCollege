package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the H_CREDIT_TUITION database table.
 * 
 */
@Entity
@Table(name="H_CREDIT_TUITION")
@NamedQuery(name="HCreditTuition.findAll", query="SELECT h FROM HCreditTuition h")
public class HCreditTuition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CREDIT_TUITION_ID")
	private long creditTuitionId;

	@Column(name="CREDIT_FEE")
	private double creditFee;
	
	//bi-directional many-to-one association to HClassSchedule
	@OneToMany(mappedBy="HCreditTuition")
	private List<HClass> HClasses;

	public HCreditTuition() {
	}

	public long getCreditTuitionId() {
		return this.creditTuitionId;
	}

	public void setCreditTuitionId(long creditTuitionId) {
		this.creditTuitionId = creditTuitionId;
	}

	public double getCreditFee() {
		return this.creditFee;
	}

	public void setCreditFee(double creditFee) {
		this.creditFee = creditFee;
	}

	public List<HClass> getHClasses() {
		return HClasses;
	}

	public void setHClasses(List<HClass> hClasses) {
		HClasses = hClasses;
	}

}