package com.modianli.pattern.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyTest {

  public static void main(String[] args) {
	System.out.println("====================JDK Proxy(字节码重组)");
    Meipo meipo = new Meipo();
	Person person = (Person) meipo.getPerson(new Zhangsan());
	System.out.println(person.getClass());
	person.findLove();

//	Person person2 = (Person) meipo.getPerson(person);
//	System.out.println(person2.getClass());
//	person2.findLove();


	System.out.println("====================CGLIB Proxy");
	Meipo2 meipo2 = new Meipo2();
	Person p = (Person) meipo2.getPerson(new Zhangsan());
	System.out.println(p.getClass());
	p.findLove();


	System.out.println("====================字节码重组");
	byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0.class", new Class[]{Person.class});

	try (FileOutputStream f = new FileOutputStream("$Proxy0.class")) {
	  f.write(bytes);
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }
}



