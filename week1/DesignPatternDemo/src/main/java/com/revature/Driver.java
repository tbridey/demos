package com.revature;

public class Driver {

	public static void main(String[] args) {
		SingletonClass obj = SingletonClass.getInstance();
		
		System.out.println(obj);
		// Note that I did not override the toString method
		// So this will show our memory location
		
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());
//		System.out.println(SingletonClass.getInstance());

		College myCollege = College.getCollege();
		
		Student s = myCollege.getStudent("math", "Sarah", 20);
		System.out.println(s);
		System.out.println(myCollege.getStudent("history", "Nancy", 18));
		System.out.println(myCollege.getStudent("english", "Tom Mark", 35));
		System.out.println(myCollege.getStudent("Some nonsense", "Geronimo", 77));
		
		if(s instanceof MathStudent) {
			MathStudent mathStudent = (MathStudent) s;
			
			System.out.println(mathStudent.getFavoriteSubject());
		}
	}
}
