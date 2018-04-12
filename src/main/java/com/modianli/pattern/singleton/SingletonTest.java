package com.modianli.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by dell on 2018/4/12.
 */
public class SingletonTest {

  public static void main(String[] args) {
	//1
	System.out.println(Foo.getInstance());

	//2
	/*CountDownLatch latch = new CountDownLatch(1000);
    for(int i = 0; i < 1000; i++){
      new Thread(() -> {
        try {
          Thread.sleep(100);
          latch.await();

          System.out.println(Foo2.getInstance());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();

      latch.countDown();
    }*/

	System.out.println("==================================");
	/*CyclicBarrier barrier = new CyclicBarrier(1000);
	for (int i = 0; i < 1000; i++) {
	  new Thread(() -> {
		try {
		  barrier.await();

		  System.out.println(Foo2.getInstance());
		} catch (Exception e) {
		  e.printStackTrace();
		}
	  }).start();
	}*/


	SFoo sFoo1 = SFoo.getInstance();
	SFoo sFoo2 = null;

	try {
	  FileOutputStream fileOutputStream = new FileOutputStream("test");
	  ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
	  os.writeObject(sFoo1);
	  os.flush();
	  os.close();

	  ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test"));
	  sFoo2 = (SFoo) ois.readObject();
	  ois.close();

	  System.out.println(sFoo1);
	  System.out.println(sFoo2);
	  System.out.println(sFoo1 == sFoo2);
	} catch (Exception e) {
	  e.printStackTrace();
	}
  }

}

class Foo {

  private Foo foo;

  private static class SingletonHolder {

	private static final Foo INSTANCE = new Foo();
  }

  public static Foo getInstance() {
	return SingletonHolder.INSTANCE;
  }
}

class Foo2 {

  private static Foo2 foo2;

  public static Foo2 getInstance() {
	if (foo2 == null) {
	  foo2 = new Foo2();
	}
	return foo2;
  }
}

class SFoo extends Serializor {

  private static SFoo sFoo = new SFoo();

  public static SFoo getInstance() {
	return sFoo;
  }

  private Object readResolve() {
	return sFoo;
  }
}

abstract class Serializor implements Serializable {
}