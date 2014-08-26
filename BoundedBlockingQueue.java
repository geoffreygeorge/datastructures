package com.example.helloworld;

public class BoundedBlockingQueue<T> {

	private Queue queue;
	private int maxSize;

	private static final int DEFAULT_SIZE = 10;

	public BoundedBlockingQueue() {
		this(DEFAULT_SIZE);
	}

	public BoundedBlockingQueue(int maxSize) {

		this.maxSize = maxSize;
		queue = new Queue();
	}

	public synchronized T dequeue() {

		while (true) {
			if (queue.count() > 0) {
				notifyAll();
				return (T) queue.dequeue();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void enqueue(T in) {

		while (true) {
			if (queue.count() < this.maxSize) {
				// We do not need to notify in other conditions
				if (queue.count() == 1) {
					notifyAll();
				}
				queue.enqueue(in);
				return;
			} else {
				queue.enqueue(in);
				return;
			}
		}
	}

	public int count() {
		return queue.count();
	}
}
