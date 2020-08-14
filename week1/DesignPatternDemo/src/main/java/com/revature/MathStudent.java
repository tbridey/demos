package com.revature;

public class MathStudent extends Student {

	private String favoriteSubject;

	public MathStudent() {
		super();
	}

	public MathStudent(int age, String name, String major, String favoriteSubject) {
		super(age, name, major);
		this.favoriteSubject = favoriteSubject;
	}

	public String getFavoriteSubject() {
		return favoriteSubject;
	}

	public void setFavoriteSubject(String favoriteSubject) {
		this.favoriteSubject = favoriteSubject;
	}

	@Override
	public String toString() {
		return "MathStudent [favoriteSubject=" + favoriteSubject + ", getMajor()=" + getMajor() + ", getAge()="
				+ getAge() + ", getName()=" + getName() + "]";
	}
}
