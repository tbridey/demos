package com.revature.nonaccessmods;

public class Circle extends Shape implements Calculable {

	private double radius;
		
	public Circle() {
		super();
	}

	public Circle(double radius) {
		this();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius < 0) {
			// Throw an exception
			return; // Ignore the value
		}
		this.radius = radius;
	}

	// This statement below is called an annotation
	// They generally provide some metadata regarding whatever is being annotated
	// In this particular case, we have the @Override annotation on our inherited area method
	// This annotation will indicate to the compiler that this method must override a method from
	// the parent class
	// If it isn't, there will be a compiler error
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	// When overriding a method, you are allowed to change the return type
	// However, this is only allowed if the original return type was an object of some sort
	// This allows us to change the return type to be a subclass of the original return type
	@Override
	public Object test() {
		return "Hello Larry!";
	}
}
