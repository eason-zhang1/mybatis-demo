package com.modianli.algorith;

public class Demo {

  public static void main(String[] args) {
	System.out.println("求和结果: " + abP(10, -20));
	System.out.println("最大值: " + max(100, 125));

	binaryStr(120);
	System.out.println(trailingZeros(100));
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

  private static int max(int a, int b) {
	return a ^ b;
  }

  private static void binaryStr(int a) {
	System.out.println(Integer.toBinaryString(a));
  }

  public static long trailingZeros(long n) {
	// write your code here, try to do it without arithmetic operators.
	Long count5 = 0L;
	for (long i = 5; n/i > 0; i *= 5) {
	  count5 += n/i;
	}

	return count5;
  }
}
