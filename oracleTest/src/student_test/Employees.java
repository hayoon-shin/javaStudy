package student_test;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class Employees implements Serializable {
	private int employeeId;    
	private String firstName; 
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;       
	private String jobID;
	private double salary;
	private double comissionPct;
	private int managerId;
	private int departmentId;
	
	
	// 생성자 오버로딩
	public Employees(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
			String jobID, double salary, double comissionPct, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobID = jobID;
		this.salary = salary;
		this.comissionPct = comissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}

	public Employees(int employeeId, String firstName, double salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}
	
	// getter,setter
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComissionPct() {
		return comissionPct;
	}

	public void setComissionPct(double comissionPct) {
		this.comissionPct = comissionPct;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	// 객체비교
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		Employees e = null;
		if(!(obj instanceof Employees)) {
			return false;
		}
		e = (Employees)obj;
		return this.employeeId == e.employeeId;
	}
	//toString

	@Override
	public String toString() {
		return "[employeeId=" + employeeId + ", firstName=" + firstName + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
}
