package com.modianli.pattern.observer;

import com.modianli.pattern.observer.core.RoleEvent;
import com.modianli.pattern.observer.core.RoleEventListener;

public class Mouse extends RoleEventListener {

  public void onClick(){
	System.out.println("click....");
	trigger(RoleEvent.ON_CLICK);
  }
}
