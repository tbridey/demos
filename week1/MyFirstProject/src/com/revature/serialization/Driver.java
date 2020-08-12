package com.revature.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private List<Employee> employeeDB = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Driver d = new Driver();
		
//		d.employeeDB.add(new Employee(1, "Peter", "Fisher", Department.HR, LocalDateTime.now(), Role.TRAINEE));
//		
//		d.serialize();
		
		d.deserialize();
		
		for(Employee e: d.employeeDB) {
			System.out.println(e);
		}
	}

	// Convert from Java -> File
	public void serialize() {
		
		// This is called a try-with-resources block
		// It allows you to instantiate an object that implements the AutoClosable interface
		// This will cause the object to automatically be closed at the end of the block
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/employee.db"))) {
			
			oos.writeObject(employeeDB);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Convert from File -> Java
	public void deserialize() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/employee.db"))) {
			
			employeeDB = (List<Employee>) ois.readObject();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
