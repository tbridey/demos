package com.revature.threads;

import java.util.Queue;

public class Producer extends Thread {
	
	private Queue<Integer> buffer;
	
	public void setBuffer(Queue<Integer> buffer) {
		this.buffer = buffer;
	}

	public static int value = 0;
	
	@Override
	public void run() {
		try {
			while(true) {
				synchronized (buffer) {
					while(!buffer.offer(value)) {
						System.out.println("Producer " + getName() + " is falling asleep!");
						buffer.wait();
					}
					
					System.out.println("Added value: " + value++);
					// The ++ operator is the increment operator, however there are 2 kinds
					// x++ vs ++x
					// x++ is called post-increment
					// This means, the "x++" syntax will evaluate to the original value
					// and THEN be incremented behind the scenes
					
					// ++x is called pre-increment
					// This means the "++x" syntax will evaluate to the new value
					
					buffer.notifyAll();
					// Wake up any other Threads that were waiting on the buffer
					// This will wake up both Consumers and other Producers
					
					Thread.sleep(100);
					// This is here to slow down the Producers, so it isn't so fast
				}
			}
		} catch(InterruptedException e) { }
	}

}
