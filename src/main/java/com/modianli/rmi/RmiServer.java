package com.modianli.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiServer {

  public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
	IHelloService helloService = new HelloServiceImpl();

	LocateRegistry.createRegistry(9999);

	Naming.bind("rmi://localhost:9999/hello", helloService);
  }
}
