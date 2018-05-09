package com.modianli.algorith;

public class Demo {

  public static void main(String[] args) {
	//System.out.println("求和结果: " + abP(10, -20));
	//System.out.println(trailingZeros(10014848));

	System.out.println(digitCounts(1, 12));

	System.out.println("===========================");

	//synchronized 修饰的静态方法时， 等同于 synchronized(XX.class){}
	//修饰非静态方法时, 等同于 synchronized(this){}
	Demo demo = new Demo();
	//new Thread(() -> testSynchronized1()).start();
	//new Thread(() -> testSynchronized2()).start();

	testSynchronized1();
  }

  private static int abP(int a, int b) {
	if (b == 0) {
	  return a;
	}
	//return abP(a ^ b, (a & b) << 1);

	int c, d;
	do {
	  c = a ^ b;
	  d = ((a & b) << 1);

	  a = c;
	  b = d;
	} while (b != 0);

	return c;
  }

  public static long trailingZeros(long n) {
	// write your code here, try to do it without arithmetic operators.
	Long count5 = 0L;
	/*for (long i = 2; i <= n; i++) {
			long c = i;
	        while(c % 5 == 0){
		        count5++;
	        	c /= 5;
	         }
	    }*/

	for (long i = 5; n / i > 0; i *= 5) {
	  count5 += n / i;
	}

	return count5;
  }

  public static int digitCounts(int k, int n) {
	if (k < 0 || k > 9) {
	  throw new IllegalArgumentException("K值不在允许(0 ~ 9)范围");
	}
	if (n < 0) {
	  throw new IllegalArgumentException("N值不在允许(N > 0)范围");
	}
	if (n < k) {
	  return 0;
	}

	int count = 1;
	for (int i = k + 1; i <= n; i++) {
	  int tmp = i;
	  while (tmp / 10 != 0) {
		if (tmp % 10 == k) {
		  count++;
		}

		tmp /= 10;
	  }

	  if (tmp == k) {
		count++;
	  }
	}

	return count;
  }

  public synchronized static void testSynchronized1() {
	for (int i = 0; i < 20; i += 2) {
	  System.out.println(i);
	}

	try {
	  Thread.sleep(3000);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}

	testSynchronized2();
  }

  public synchronized static void testSynchronized2() {
	for (int i = 1; i < 20; i += 2) {
	  System.out.println(i);
	}
  }
}
