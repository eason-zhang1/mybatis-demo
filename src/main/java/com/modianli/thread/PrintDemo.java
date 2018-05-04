package com.modianli.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintDemo {

  private final static ReentrantLock lock = new ReentrantLock();

  private final static Condition jCon = lock.newCondition();
  private final static Condition oCon = lock.newCondition();

  private final static Object object = new Object();

  private volatile boolean started = false;

  public static void main(String[] args) {

	//reentranLockPrint();

	PrintDemo demo = new PrintDemo();
	demo.basePrint();

//
//	new Thread(demo::testVolatile).start();
//
//	try {
//	  Thread.sleep(2000);
//	  demo.started = true;
//	} catch (InterruptedException e) {
//	  e.printStackTrace();
//	}
  }

  private void testVolatile() {
	while (!started) {
	  System.out.println("ttt");
	}

	System.out.println("==============end");
  }

  private void basePrint() {

	new Thread(() -> {

	  for (int i = 1; i < 100; i += 2) {
		synchronized (object) {
		  System.out.println(i);
		  object.notify();

		  try {
			object.wait();
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		}
	  }
	}).start();

	new Thread(() -> {
	  try {
		Thread.sleep(100);
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }

	  for (int i = 2; i <= 100; i += 2) {
		synchronized (object) {
		  System.out.println(i);
		  object.notify();

		  try {
			object.wait();
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		}
	  }
	}).start();
  }

  public static void reentranLockPrint() {
	new Thread(() -> {
	  for (int i = 1; i < 100; i += 2) {
		lock.lock();
		try {
		  System.out.println(i);
		  oCon.signal();
		  jCon.await();
		} catch (Exception e) {
		  e.printStackTrace();
		} finally {
		  lock.unlock();
		}
	  }
	}).start();

	new Thread(() -> {
	  for (int i = 2; i <= 100; i += 2) {
		lock.lock();
		try {
		  System.out.println(i);
		  jCon.signal();
		  oCon.await();
		} catch (Exception e) {
		  e.printStackTrace();
		} finally {
		  lock.unlock();
		}
	  }
	}).start();
  }

}
