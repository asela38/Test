package com.asela.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserDetails extends Remote {

	void addUser(String id, String name) throws RemoteException;
	String getUser(String id) throws RemoteException;
	
}
