package com.fdaindia.hrms.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Employee(Long id, String username, String under, String dateOfJoining, String employeeNumber,
			String function, String location, String somedate, Date dob, String bloodGroup, String fatherName,
			String motherName, String address, String contactNumber, String email, String bankName, String branch,
			String bankAccountNumber, String pancardNumber, Long totalSalary, String password, String otp,
			Date otpExpiry, String role, Department department, Designation designation) {
		super();
		this.id = id;
		this.username = username;
		this.under = under;
		this.dateOfJoining = dateOfJoining;
		this.employeeNumber = employeeNumber;
		this.function = function;
		this.location = location;
		this.somedate = somedate;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.email = email;
		this.bankName = bankName;
		this.branch = branch;
		this.bankAccountNumber = bankAccountNumber;
		this.pancardNumber = pancardNumber;
		this.totalSalary = totalSalary;
		this.password = password;
		this.otp = otp;
		this.otpExpiry = otpExpiry;
		this.role = role;
		this.department = department;
		this.designation = designation;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getOtpExpiry() {
		return otpExpiry;
	}

	public void setOtpExpiry(Date otpExpiry) {
		this.otpExpiry = otpExpiry;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUnder() {
		return under;
	}

	public void setUnder(String under) {
		this.under = under;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSomedate() {
		return somedate;
	}

	public void setSomedate(String somedate) {
		this.somedate = somedate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

	public Long getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(Long totalSalary) {
		this.totalSalary = totalSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Column(name = "username")
	private String username;

	@Column(name = "under")
	private String under;

	@Column(name = "date_of_joining")
	private String dateOfJoining;

	@Column(name = "employee_number")
	private String employeeNumber;

	@Column(name = "`function`") // Escaping reserved keyword
	private String function;

	@Column(name = "location")
	private String location;

	@Column(name = "somedate")
	private String somedate;

	@Column(name = "date_ofbirth")
	private Date dob;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "branch")
	private String branch;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "pancar_number")
	private String pancardNumber;

	@Column(name = "total_salary")
	private Long totalSalary;
	@Column(name = "password")
    private String password;
	@Column(name = "otp")
    private String otp;
	@Column(name = "otpExpiry")
    private Date otpExpiry;
	@Column(name = "role")
    private String role;


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id", insertable = true, updatable = false)
	private Department department;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designation_id", insertable = true, updatable = false)
	private Designation designation;
}