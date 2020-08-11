package com.revature.exceptions;

import java.io.Serializable;
import java.util.Objects;

// We'll follow a design pattern called POJO: Plain Old Java Object
// Generally, we will create all private fields
// We'll create a no-argument constructor and an all argument constructor
// 		More constructors are acceptable if needed
// We'll create getters and setters
// We will implement the Serializable interface (note that this interface has no methods to implement)
// We will override the hashcode, equals, and toString methods

// Commonly used for simple objects that really just need to store data
public class Duck implements Serializable {

	private static final long serialVersionUID = 7701529042128729411L;
	private int numberOfEggs;

	public Duck() {
		super();
	}

	public Duck(int numberOfEggs) {
		super();
		setNumberOfEggs(numberOfEggs);
	}

	public int getNumberOfEggs() {
		try {
			int x = 1 / 0;
		} catch(ArithmeticException e) {
			throw new NegativeEggsException("Ducks cannot have negative eggs!", e);
		}
		return numberOfEggs;
	}

	public void setNumberOfEggs(int numberOfEggs) {
		if(numberOfEggs < 0) {
			throw new NegativeEggsException("Ducks cannot have negative eggs!");
		}
		this.numberOfEggs = numberOfEggs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfEggs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Duck)) {
			return false;
		}
		Duck other = (Duck) obj;
		return numberOfEggs == other.numberOfEggs;
	}

	@Override
	public String toString() {
		return "Duck [numberOfEggs=" + numberOfEggs + "]";
	}
}
