package com.revature.threads;

import java.util.Queue;

public class Consumer extends Thread {

	private Queue<Integer> buffer;

	public void setBuffer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				synchronized (buffer) {
					while(buffer.isEmpty()) {
						System.out.println("Consumer " + getName() + " is falling asleep!");
						buffer.wait();
					}
					
					int val = buffer.remove();
					
					System.out.println("Consuming value: " + val);
					
					buffer.notifyAll();
					
					Thread.sleep(100);
				}
			}
		} catch(InterruptedException e) { }
	}
}
