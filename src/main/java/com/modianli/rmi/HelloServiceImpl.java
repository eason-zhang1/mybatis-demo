package com.modianli.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

  protected HelloServiceImpl() throws RemoteException {
  }

  @Override
  public String say(String name) throws RemoteException {
	return "Hello, " + name;
  }
}
