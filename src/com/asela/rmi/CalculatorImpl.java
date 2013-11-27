package com.asela.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInterface {

	protected CalculatorImpl() throws RemoteException {
		super();
	}

	@Override
	public int add(int i, int j) throws RemoteException {
		return (i + j);
	}

	@Override
	public int substract(int i, int j) throws RemoteException {
		return (i - j);
	}


}
