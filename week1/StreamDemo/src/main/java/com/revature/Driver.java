package com.revature;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();

		names.add("Micky Mouse");
		names.add("Klay");
		names.add("Mario Mario");
		names.add("Luigi Mario");
		names.add("Wario");
		names.add("Waluigi");
		names.add("Peach");
		names.add("Daisy");
		names.add("Maria Mario");
		names.add("Klaus");
		names.add("Kupa");
		names.add("Kimberly");
		
		List<Integer> lengths = names.stream()
			// The return statement is automatic
//			.map( (name) -> name.toUpperCase())
			.filter( (name) -> name.contains("K") || name.contains("k"))
			.map( (name) -> name.length())
			.filter( (length) -> length > 4)
			.collect(Collectors.toList());
		
		System.out.println(lengths);
//			.summaryStatistics();
//		
//		System.out.println(stats.getMin());
//		System.out.println(stats.getAverage());
//		System.out.println(stats.getMax());
	}
}
