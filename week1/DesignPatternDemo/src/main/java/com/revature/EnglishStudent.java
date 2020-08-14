package com.revature;

public class EnglishStudent extends Student {
	
	private String favoriteBook;

	public EnglishStudent() {
		super();
	}

	public EnglishStudent(int age, String name, String major, String favoriteBook) {
		super(age, name, major);
		this.favoriteBook = favoriteBook;
	}

	public String getFavoriteBook() {
		return favoriteBook;
	}

	public void setFavoriteBook(String favoriteBook) {
		this.favoriteBook = favoriteBook;
	}

	@Override
	public String toString() {
		return "EnglishStudent [favoriteBook=" + favoriteBook + ", getMajor()=" + getMajor() + ", getAge()=" + getAge()
				+ ", getName()=" + getName() + "]";
	}
}
