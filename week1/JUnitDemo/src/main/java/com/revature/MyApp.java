package com.revature;

import java.math.BigDecimal;

public class MyApp {
	
	private Number[] arr;

//	public static void main(String[] args) {
//
//	}
	
	public MyApp(Number[] arr) {
		super();
		this.arr = arr;
	}
	
	public Number[] getArr() {
		return arr;
	}

	public void setArr(Number[] arr) {
		this.arr = arr;
	}

	public Number[] addValueToArray(Number n) {
		Number[] copy = new Number[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		
		for(int i = 0; i < copy.length; i++) {
			copy[i] = new BigDecimal(copy[i].toString()).add(new BigDecimal(n.toString()));
			// Will convert the types of the inputs into BigDecimals
		}
		
		return copy;
	}
}
