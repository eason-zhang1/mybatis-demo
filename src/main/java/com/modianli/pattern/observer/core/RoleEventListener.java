package com.modianli.pattern.observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RoleEventListener {

  private Map<Enum, RoleCallback> events = new HashMap<>();

  public void addListener(RoleEvent type, Object target, Method method){
    RoleCallback callback = new RoleCallback();
    callback.target = target;
	callback.callback = method;
	callback.roleEvent = type;

    events.put(type, callback);
  }

  public void trigger(RoleEvent roleEvent){
    if(events.containsKey(roleEvent)){
      RoleCallback callback = events.get(roleEvent);

	  try {
		callback.callback.invoke(callback.target, null);
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	}
  }
}
