package com.asela.rmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RmiClient {
	
	static public void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		String serverAddress = "172.22.229.169";
		String serverPort = "3232";
	//	System.out.print("Text You Want to Send : ");
	//	String text = scanner.nextLine();
		
	//	System.out.printf("sending %s to %s:%s ", text, serverAddress, serverPort);
		
		try {
			Registry registry = LocateRegistry.getRegistry(serverAddress, Integer.parseInt(serverPort));
			
		//	userMessage(text, registry);			
		//	userCalculator(registry);
			
			Remote userDetailRemote = registry.lookup("userDetails");
			UserDetails userDetails = (UserDetails) userDetailRemote;
			
			System.out.println(userDetails.getUser("123"));
			//userDetails.addUser("124", "Test");
			System.out.println(userDetails.getUser("124"));
			
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
	}

	private static void userCalculator(Registry registry)
			throws RemoteException, NotBoundException, AccessException {
		Remote remote = registry.lookup("rmiCalculator");
		CalculatorInterface rmiCalculator = (CalculatorInterface) remote;
		int result = rmiCalculator.add(12,13);			
		System.out.println(result);
	}

	private static void userMessage(String text, Registry registry)
			throws RemoteException, NotBoundException, AccessException {
		ReceiveMessageInterface rmiServer = (ReceiveMessageInterface) (registry.lookup("rmiServer"));
		rmiServer.receiveMessage(text);
	}
}