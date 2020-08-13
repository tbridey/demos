package com.revature.comparison;

import java.io.Serializable;
import java.util.Objects;

/*
 * There are 2 commonly used interfaces when defining how your custom classes should be
 * compared to each other. Both interfaces are Generic interfaces
 * 
 * The first is the Comparable interface.
 * 
 * It defines a single abstract method (Note: referred to as a functional interface)
 *  compareTo
 *  
 *  The general idea of the method is to return an integer that represents whether
 *  the 2 objects are equal, whether the first object is less than the other, or
 *  whether the first object is greater than the other.
 *  
 *  If the first object (the invoking object) is less, then return a negative value
 *  If the 2 objects are equal, we should return zero
 *  If the first object is greater, then return a positive value
 *  
 *  Optionally, the magnitude of the positive/negative value can represent
 *  how much less/greater they are, but this is not required.
 *  
 *  You may just return -1, 0, and 1 if you want
 */

public class Person implements Comparable<Person>, Serializable {
	
	private static final long serialVersionUID = 8161412891162572933L;
	
	private int age;
	private String name;
	
	public Person() {
		super();
	}

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	// It is entirely up to the developer on how to implement this method
	// The results will determine the "natural ordering" of this class
	@Override
	public int compareTo(Person o) {
		if(age == o.age) {
			return name.compareTo(o.name);
		}
		
		return age - o.age;
	}
	
	// In general, we only want to return 0 if the two objects are entirely equal
	// Such as the result from the .equals method
}
