package com.revature;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import com.revature.threads.Consumer;
import com.revature.threads.Producer;

public class ProducerConsumerProblem {
	
	public static final int NUM_OF_PRODS = 2;
	public static final int NUM_OF_CONS = 2;
	
	public static final int BUFFER_SIZE = 2;

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName());
		
		Queue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);
		
		for(int i = 0; i < BUFFER_SIZE / 2; i++) {
			buffer.add(-(i + 1));
		}
		
		Set<Producer> producers = new HashSet<>();
		
		for(int i = 0; i < NUM_OF_PRODS; i++) {
			Producer p = new Producer();
			p.setBuffer(buffer);
			producers.add(p);
		}
		
		Set<Consumer> consumers = new HashSet<>();
		
		for(int i = 0; i < NUM_OF_CONS; i++) {
			Consumer c = new Consumer();
			c.setBuffer(buffer);
			consumers.add(c);
		}
		
		for(Producer p : producers) {
			p.start();
		}
		
		Thread.sleep(2);
		
		for(Consumer c : consumers) {
			c.start();
		}
		
		System.out.println(Thread.activeCount());
		
//		consumers.iterator().next().join();
		// Grabbing a random Consumer Thread and joining it with the main Thread
		// This will cause the main Thread to wait until this Consumer Thread ends
		
		System.out.println(Thread.activeCount());
	}
	
	/*
	 * Lifecycle of a Thread
	 * 
	 * 1. New: Newly created Threads that have not started (not called the start() method)
	 * 2. Runnable: Either currently running or waiting for resource allocation
	 * 3. Blocked: Waiting to acquire a lock to enter a synchronized block/method
	 * 4. Waiting: Waiting for some other Thread to perform an action without any time limit
	 * 5. Timed_Waiting: Same as Waiting, except with a specified time period
	 * 6. Terminated: Thread has completed its execution
	 */
}
