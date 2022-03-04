package com.soonee.study.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Chopstick {
	private Lock lock;

	public Chopstick(Lock lock) {
		this.lock = new ReentrantLock();
	}

	public void pickUp() {
		lock.lock();
	}
	public void putDown() {
		lock.unlock();
	}
}

class Philosopher extends Thread {
	private int bites = 10;
	private Chopstick left, right;

	public Philosopher(int bites, Chopstick left, Chopstick right) {
		this.bites = bites;
		this.left = left;
		this.right = right;
	}

	public void eat() {
	}
	public void pickUp() {
	}
	public void chew() {}
	public void putDown() {
	}
	public void run() {
	}
}

public class Case3 {
}
