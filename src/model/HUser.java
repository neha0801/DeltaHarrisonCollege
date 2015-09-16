package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the H_USER database table.
 * 
 */
@Entity
@Table(name="H_USER", schema="TESTDB")
@NamedQuery(name="HUser.findAll", query="SELECT h FROM HUser h")
public class HUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private long userId;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional one-to-one association to HStudentDetail
	@OneToOne(mappedBy="HUser")
	private HStudentDetail HStudentDetail;

	//bi-directional many-to-one association to HUserRole
	@OneToMany(mappedBy="HUser")
	private List<HUserRole> HUserRoles;

	public HUser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public HStudentDetail getHStudentDetail() {
		return this.HStudentDetail;
	}

	public void setHStudentDetail(HStudentDetail HStudentDetail) {
		this.HStudentDetail = HStudentDetail;
	}

	public List<HUserRole> getHUserRoles() {
		return this.HUserRoles;
	}

	public void setHUserRoles(List<HUserRole> HUserRoles) {
		this.HUserRoles = HUserRoles;
	}

	public HUserRole addHUserRole(HUserRole HUserRole) {
		getHUserRoles().add(HUserRole);
		HUserRole.setHUser(this);

		return HUserRole;
	}

	public HUserRole removeHUserRole(HUserRole HUserRole) {
		getHUserRoles().remove(HUserRole);
		HUserRole.setHUser(null);

		return HUserRole;
	}
	
	public boolean isTimeOk(HClass newClass )
	{
		boolean isOk = false;
		
		List<HEnrollment> enrollments = this.getHStudentDetail().getHEnrollments();
		
		for(HEnrollment enrollment : enrollments)
		{
			
		}
		
		return isOk;
	}
	

	public String getFullName(){
		String nameStr = "";
		nameStr=this.firstName + " " + this.lastName;
		return nameStr;
	}

	public boolean isAdmin()
	{
		boolean isAdmin = false;
		List<HUserRole> roles = this.getHUserRoles();
		
		for(HUserRole role : roles)
		{
			if(role.getHRole().getName().equalsIgnoreCase("admin"))
			{
				isAdmin = true;
				break;
			}
		}
		return isAdmin;
	}
	
	public boolean isStudent()
	{
		boolean isStudent = false;
		List<HUserRole> roles = this.getHUserRoles();
		
		for(HUserRole role : roles)
		{
			if(role.getHRole().getName().equalsIgnoreCase("student"))
			{
				isStudent = true;
				break;
			}
		}
		return isStudent;
	}
	
	public boolean isAdvisor()
	{
		boolean isAdvisor = false;
		List<HUserRole> roles = this.getHUserRoles();
		
		for(HUserRole role : roles)
		{
			if(role.getHRole().getName().equalsIgnoreCase("advisor"))
			{
				isAdvisor = true;
				break;
			}
		}
		return isAdvisor;
	}
	
	public boolean isInstructor()
	{
		boolean isInstructor = false;
		List<HUserRole> roles = this.getHUserRoles();
		
		for(HUserRole role : roles)
		{
			if(role.getHRole().getName().equalsIgnoreCase("instructor"))
			{
				isInstructor = true;
				break;
			}
		}
		return isInstructor;
	}

}