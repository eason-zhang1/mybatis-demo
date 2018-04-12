package com.modianli.mybatis.demo;

import java.util.HashMap;

public class Test1 {


  volatile static boolean requirement = true;

  public static void main(String[] args) {

	/*Thread thread = new Thread(() -> {
	  while (requirement) {
		//System.out.println("tttt");
	  }
	});

	thread.start();

	try {
	  Thread.sleep(2000);
	} catch (InterruptedException e) {
	  e.printStackTrace();
	}
	requirement = false;
	System.out.println("test....");*/


	int i = (1 << 20) - 1 ;
	System.out.println(i);
	System.out.println(i  ^ (i >>> 16));


	System.out.println(13 ^ 12);
	System.out.println(100 | 12);
	System.out.println(4&9);////(n - 1) & hash === hash%n    n = 5
	System.out.println(5%3);

	System.out.println("1");

	HashMap<Integer, String> test = new HashMap<>();
	test.put(1, "1");

	int n = 16;
	int hash = 48;
	System.out.println((n - 1) & hash);
  }
}
