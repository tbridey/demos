package com.revature;

public class HistoryStudent extends Student {

	private String favoriteEra;

	public HistoryStudent() {
		super();
	}

	public HistoryStudent(int age, String name, String major, String favoriteEra) {
		super(age, name, major);
		this.favoriteEra = favoriteEra;
	}

	public String getFavoriteEra() {
		return favoriteEra;
	}

	public void setFavoriteEra(String favoriteEra) {
		this.favoriteEra = favoriteEra;
	}

	@Override
	public String toString() {
		return "HistoryStudent [favoriteEra=" + favoriteEra + ", getMajor()=" + getMajor() + ", getAge()=" + getAge()
				+ ", getName()=" + getName() + "]";
	}
}
