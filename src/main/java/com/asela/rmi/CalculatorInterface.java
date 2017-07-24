package com.asela.rmi;

import java.rmi.*;

public interface CalculatorInterface extends Remote {

		int add(int i, int j) throws RemoteException;
		int substract(int i, int j) throws RemoteException;

}