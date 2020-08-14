package com.revature;

public class Student extends Person {

	private String major;

	public Student() {
		super();
	}

	public Student(int age, String name, String major) {
		super(age, name);
		this.major = major;
	}

	public Student(String major) {
		super();
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
