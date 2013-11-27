package com.asela.rmi;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;


public class UserDetailsImpl implements UserDetails {


	private Map<String, String> userdetails = new HashMap<>();
	
	
	public void addUser(String id, String name) throws RemoteException {
		userdetails.put(id, name);
	}

	@Override
	public String getUser(String id) throws RemoteException {
		return userdetails.get(id);
	}
}
