package com.studentmanagement.bean;

public class Student {

	private int id;
	private String fname, lname, dob, age, phone, address, gender, grade, email, admission;

	public Student(String fname, String lname, String dob, String age, String phone, String address, String gender,
			String grade, String email, String admission) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.grade = grade;
		this.email = email;
		this.admission = admission;
	}

	public Student(int id, String fname, String lname, String dob, String age, String phone, String address,
			String gender, String grade, String email, String admission) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.grade = grade;
		this.email = email;
		this.admission = admission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

}
