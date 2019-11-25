package com.company;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String firstName, lastName;
	private String jobTitle;
	private int salary;
	private LocalDate hireDate;
	private String departmentName;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String country;
	
	Employee(int id, String firstName, String lastName, String jobTitle, int salary, LocalDate hireDate,
			 String departmentName, String streetAddress, String postalCode, String city, String country) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.salary = salary;
		this.hireDate = hireDate;
		this.departmentName = departmentName;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jobTitle=" + jobTitle
				+ ", salary=" + salary + ", hireDate=" + hireDate + ", departmentName=" + departmentName
				+ ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", city=" + city + ", country="
				+ country + "]";
	}

	
	
}
