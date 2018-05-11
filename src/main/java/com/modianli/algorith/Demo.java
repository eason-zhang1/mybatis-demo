package com.modianli.algorith;

import java.util.Arrays;

public class Demo {

  private String test;

  public static void main(String[] args) {
	//System.out.println("求和结果: " + abP(10, -20));
	//System.out.println(trailingZeros(10014848));

	//System.out.println(digitCounts(1, 12));

	System.out.println("===========================");

	//synchronized 修饰的静态方法时， 等同于 synchronized(XX.class){}
	//修饰非静态方法时, 等同于 synchronized(this){}
	Demo demo = new Demo();
	//new Thread(() -> testSynchronized1()).start();
	//new Thread(() -> testSynchronized2()).start();

	//testSynchronized1();

	//System.out.println("丑数:" + nthUglyNumber(9));
	//System.out.println(reverseInteger(897));
	System.out.println(Arrays.toString(mergeSortedArray(new int[]{1, 5}, new int[]{2, 3})));
  }

  public static int[] mergeSortedArray(int[] A, int[] B) {
	int[] newArr = new int[A.length + B.length];
	//int newInd = 0;
	//int i = 0, j = 0;
	/*for (; i < A.length; i++) {
	  for (; j < B.length; j++) {
		if (A[i] > B[j]) {
		  newArr[newInd++] = B[j];
		} else {
		  newArr[newInd++] = A[i];
		  break;
		}
	  }

	  if(j == B.length){
	    break;
	  }
	}

	if (i < A.length) {
	  for (; i < A.length; i++) {
		newArr[newInd++] = A[i];
	  }
	}
	if (j < B.length) {
	  for (; j < B.length; j++) {
		newArr[newInd++] = B[j];
	  }
	}*/

	int newInd = newArr.length - 1;
	int i = A.length -1, j = B.length - 1;
	while(i >= 0 && j >= 0){
	  if(A[i] > B[j]){
		newArr[newInd--] = A[i--];
	  }else {
		newArr[newInd--] = B[j--];
	  }
	}

	if(i >= 0){
	  while(i >= 0){
	    newArr[newInd --] = A[i--];
	  }
	}
	if(j >= 0){
	  while(j >= 0){
		newArr[newInd --] = B[j--];
	  }
	}




	return newArr;
  }

  public static int reverseInteger(int number) {
	if (number < 100 || number >= 1000) {
	  throw new IllegalArgumentException("number 范围不对");
	}

	//1.
	/*int reverseNum = 0;
	for (; ; ) {
	  if (number < 10) {
		reverseNum = reverseNum * 10 + number;
		break;
	  }
	  int digit = number % 10;
	  reverseNum = reverseNum * 10 + digit;
	  number /= 10;
	}

	return reverseNum;*/
	return (number % 10) * 100 + ((number / 10) % 10) * 10 + (number / 100) % 10;
  }

  /**
   * a + b 问题
   */
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

  /**
   * 阶乘尾数0的个数
   */
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

  /**
   * 数字统计
   */
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

  /**
   * 丑数
   */
  public static int nthUglyNumber(int n) {
	if (n < 1) {
	  return 0;
	}

	int[] uglyArr = new int[n];
	uglyArr[0] = 1;
	int index2 = 0, index3 = 0, index5 = 0;
	for (int i = 1; i < n; i++) {
	  uglyArr[i] = min(uglyArr[index2] * 2, min(uglyArr[index3] * 3, uglyArr[index5] * 5));
	  if (uglyArr[i] == uglyArr[index2] * 2) {
		index2++;
	  }
	  if (uglyArr[i] == uglyArr[index3] * 3) {
		index3++;
	  }
	  if (uglyArr[i] == uglyArr[index5] * 5) {
		index5++;
	  }
	}

	System.out.println(Arrays.toString(uglyArr));
	return uglyArr[n - 1];
  }

  private static int min(int i, int j) {
	return i > j ? j : i;
  }
}
