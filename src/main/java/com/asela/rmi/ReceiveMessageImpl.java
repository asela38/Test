package com.asela.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReceiveMessageImpl extends UnicastRemoteObject implements ReceiveMessageInterface {

    private static final long serialVersionUID = -3369230626181836452L;

    protected ReceiveMessageImpl() throws RemoteException {
        super();
    }

    public void receiveMessage(String x) throws RemoteException {
        System.out.println(x);
    }

}
