package com.asela.rmi;

import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer   {

	public static void main(String args[]) {

		try {
			String thisAddress = (InetAddress.getLocalHost()).toString();
			int thisPort = 3232;

			System.out.printf("this address= %s, port=%s",thisAddress, thisPort);

			Registry registry = LocateRegistry.createRegistry(thisPort);
			registry.rebind("rmiServer", new ReceiveMessageImpl());
			registry.rebind("rmiCalculator", new CalculatorImpl());
			
			Remote exportObject = UnicastRemoteObject.exportObject(new UserDetailsImpl(), 0);
			registry.rebind("userDetails", exportObject);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}