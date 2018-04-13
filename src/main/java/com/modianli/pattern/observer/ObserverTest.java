package com.modianli.pattern.observer;

import com.modianli.pattern.observer.core.RoleEvent;

import java.lang.reflect.Method;

public class ObserverTest {

  public static void main(String[] args) throws NoSuchMethodException {
	/**
	 * var input = document.getElementById('test');
	 *
	 * input.addListener('click', function(e){...});
	 */

	MouseCallback mouseCallback = new MouseCallback();
	Method method = MouseCallback.class.getMethod("onClick", null);

	Mouse mouse = new Mouse();
	mouse.addListener(RoleEvent.ON_CLICK, mouseCallback, method);
	mouse.onClick();
  }
}
