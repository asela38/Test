package com.asela.rmi;

import java.rmi.RemoteException;
import java.rmi.server.*;

public class ReceiveMessageImpl extends UnicastRemoteObject implements ReceiveMessageInterface {

	protected ReceiveMessageImpl() throws RemoteException {
		super();
	}

	public void receiveMessage(String x) throws RemoteException {
		System.out.println(x);
	}

}
