package com.modianli.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

  public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
	IHelloService iHelloService = (IHelloService) Naming.lookup("rmi://localhost:9999/hello");
	System.out.println(iHelloService.say("Eason"));
  }
}
