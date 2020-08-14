package com.revature;

public class College {
	
	private static College instance = null;
	
	private College() {
		super();
	}

	public static College getCollege() {
		if(instance != null) {
			return instance;
		}
		
		instance = new College();
		return instance;
	}
	
	public Student getStudent(String type, String name, int age) {
		if(type == null) {
			return null;
		}
		
		switch(type.toLowerCase()) {
		case "math":
			return new MathStudent(age, name, "Math", "Algebra");
		case "english":
			return new EnglishStudent(age, name, "English", "Wuthering Heights");
		case "history":
			return new HistoryStudent(age, name, "History", "Post-War");
		default:
			return new Student(age, name, "Liberal Arts");
		}
	}
}
