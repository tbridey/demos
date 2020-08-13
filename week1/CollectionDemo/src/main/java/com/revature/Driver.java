package com.revature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import com.revature.comparison.NameComparator;
import com.revature.comparison.Person;

public class Driver {

	public static void main(String[] args) {
		
		List<String> myStringList = new ArrayList<>();
		
		myStringList.add("Apples");
		myStringList.add("Oranges");
		myStringList.add("Avocados");
		myStringList.add("Peaches");
		myStringList.add("Kiwis");
		myStringList.add("Plums");

		Iterator<String> iter = myStringList.iterator();
		
		// Iterators start BEFORE the first element
		// In order to obtain the first element, we must invoke the next() method
		
		String element;
		while(iter.hasNext()) {
			element = iter.next();
			System.out.println(element);
		}
		
		// Iterators only navigate 1 direction
		// Once you have completed iterating, you must obtain another Iterator
		
		// For Lists specifically, there is a ListIterator
		// These special iterators CAN move in both directions
		
		ListIterator<String> listIter = myStringList.listIterator();
		
		listIter.next();
		
		for(String fruit : myStringList) {
			System.out.println(fruit);
//			listIter.remove(); This statement would cause a ConcurrentModificationException
//			myStringList.remove(fruit); This statement would also cause a ConcurrentModificationException
		}
		
		// If you want the index, use a regular for-loop
		for(int i = 0; i < myStringList.size(); i++) {
			System.out.println(myStringList.get(i));
		}
		
		iter = myStringList.iterator();
		
		// Will completely empty a list
		while(iter.hasNext()) {
			iter.next();
			iter.remove();
		}
		
		// Alternatively
		myStringList.clear();
		
		System.out.println(myStringList);
		
		List<? super Number> myNumberList = new ArrayList<>();
		// Every element must meet the condition within the Generic
		// So every element must be either a Number or a subclass of Number
		
		myNumberList.add(15); // Integer
		myNumberList.add(15.5); // Double
		myNumberList.add(new BigDecimal(33)); // BigDecimal
		
		List<Number> otherReference = (List<Number>) myNumberList; // This casting works
		
		Set<String> mySet = new HashSet<>();
		
		mySet.add("Apples");
		mySet.add("Oranges");
		mySet.add("Avocados");
		mySet.add("Peaches");
		mySet.add("Kiwis");
		mySet.add("Plums");
		
		for(String fruit : mySet) {
			System.out.println(fruit);
		}
		
		System.out.println("============================");
		
		// TreeSets are ordered, based on the natural ordering of the elements
		// For Strings, this will be in lexicographical order
		Set<String> myTreeSet = new TreeSet<>();
		
		myTreeSet.add("Apples");
		myTreeSet.add("Oranges");
		myTreeSet.add("Avocados");
		myTreeSet.add("Peaches");
		myTreeSet.add("Kiwis");
		myTreeSet.add("Plums");
		
		for(String fruit : myTreeSet) {
			System.out.println(fruit);
		}
		
//		Queue<String> myQueue = new ArrayBlockingQueue<>(30);
		Queue<String> myQueue = new LinkedList<>();
		
		myQueue.add("Apples");
		myQueue.add("Oranges");
		myQueue.add("Avocados");
		myQueue.add("Peaches");
		myQueue.add("Kiwis");
		myQueue.add("Plums");
		
		// Repeat while the Queue is not empty
		while(!myQueue.isEmpty()) {
			element = myQueue.poll();
			
			System.out.println(element);
		}
		
		for(String fruit : myQueue) {
			System.out.println(fruit);
		}
		
		System.out.println("============================");
		
		Map<String, Integer> phoneBook = new HashMap<>();
		
		for(String e : phoneBook.keySet()) {
		}
		// Maps cannot be directly iterated through, since they are NOT part of the Collection API
		// However, they have keySet and entrySet methods, which do allow us to indirectly
		// iterate through Maps
		
		phoneBook.put("Larry", 8675309);
		phoneBook.put("Mom", 911);
		phoneBook.put("Sally", null); // Null values are allowed
		phoneBook.put(null, 90210); // Maps may have a single null key
		
		Integer number = phoneBook.get("Mom");
		
		System.out.println(number);
		
		for(Map.Entry<String, Integer> entry : phoneBook.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			System.out.println(key + " : " + value);
		}
		
		System.out.println("============================");
		
		// Many collections as well as maps support functional methods
		// These leverage anonymous functions (aka lambdas)
		phoneBook.forEach((key, val) -> System.out.println(key + " : " + val));
		
		myStringList.add("Apples");
		myStringList.add("Oranges");
		myStringList.add("Avocados");
		myStringList.add("Peaches");
		myStringList.add("Kiwis");
		myStringList.add("Plums");
		
		Collections.sort(myStringList);
		/*
		 * The Collections class is not part of the Collection(s) API
		 * It is simply a class with a ton of static methods to operate on Collection objects
		 * 
		 * There is a very similar Arrays class
		 */
		myStringList.forEach(fruit -> System.out.println(fruit));
		
		Integer[] basicArray = new Integer[0];
		
		List<Integer> convertedArray = Arrays.asList(basicArray);
		
		List<Integer> convertedVarArgs = Arrays.asList(1, 2, 3, 4, 5);
		
		convertedArray.forEach(System.out::println); // the println method will be invoked on every input
		convertedVarArgs.forEach(System.out::println);
		
		// Explore the Comparable & Comparator interfaces
		
		
		
		List<Person> people = new ArrayList<>();
		
		people.add(new Person(25, "Sam"));
		people.add(new Person(4, "Sally"));
		people.add(new Person(56, "Gertrude"));
		people.add(new Person(16, "Larry"));
		people.add(new Person(37, "Sally"));
		
		System.out.println(people);
		
		Collections.sort(people);
		
		System.out.println(people);
		
		Collections.sort(people, new NameComparator()); // You do have to instantiate the Comparator class
		
		System.out.println(people);
	}
}
