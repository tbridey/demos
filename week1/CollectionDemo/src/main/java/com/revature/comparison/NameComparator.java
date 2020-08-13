package com.revature.comparison;

import java.util.Comparator;

/*
 * The Comparator interface is another generic interface that has a single abstract method
 * called compare, that accepts 2 parameters, of the type of objects to be compared
 * 
 * The implementation of this method follows the same rules as the compareTo method
 */
public class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int result = o1.getName().compareTo(o2.getName());
		
		// The ternary operator
		// Referred the conditional operator
		// It will first the check the condition that is before the ? mark
		// If it is true, the operator will evaluate the 1st value
		// otherwise, it will evaluate to the 2nd value
		// The 2 values are separated by a colon
		// (condition) ? trueResult : falseResult
		return (result != 0) ? result : (o1.getAge() - o2.getAge());
	}
}
