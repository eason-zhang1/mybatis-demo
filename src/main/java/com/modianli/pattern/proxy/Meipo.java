package com.modianli.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo implements InvocationHandler {

  private Person person;

  public Object getPerson(Person person) {
	this.person = person;

	Class<?> clazz = this.person.getClass();
	return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	System.out.println("代理Ing");
	method.invoke(this.person, args);
	System.out.println("代理完成");
	return null;
  }

}