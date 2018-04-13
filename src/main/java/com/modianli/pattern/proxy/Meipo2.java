package com.modianli.pattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo2 implements MethodInterceptor {

  private Person person;

  public Object getPerson(Person person) {
	this.person = person;

	Enhancer enhancer = new Enhancer();
	enhancer.setSuperclass(this.person.getClass());
	enhancer.setCallback(this);
	return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

	System.out.println("代理ing2");
	methodProxy.invokeSuper(o, objects);
	System.out.println("代理完成2");
    return null;
  }
}
