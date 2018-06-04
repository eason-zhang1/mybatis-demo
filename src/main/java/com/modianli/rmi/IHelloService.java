package com.modianli.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloService extends Remote {

  String say(String name) throws RemoteException;
}
