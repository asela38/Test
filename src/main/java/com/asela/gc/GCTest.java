package com.asela.gc;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class GCTest implements GCTestMBean {
	
	private  String base = "0123456789";
	private  int count = 100;
	private  String object = "";
	private  int index = 0;
	
	private GCTest() {
		for(int i = 0; i < count; i++) {
			object += base;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

		try {
			ObjectName name = new ObjectName("com.asela.jmx:type=GCTest1");
			GCTestMBean mbean = new GCTest();
			mbs.registerMBean(mbean, name);
			mbean.run();
		} catch (MalformedObjectNameException |InstanceAlreadyExistsException | MBeanRegistrationException
				| NotCompliantMBeanException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.asela.gc.GCTestInterface#run()
	 */
	@Override
	public void run() {
		List<StringBuilder> list = new ArrayList<>();

		for(; getIndex() < 100000 ; increment()) {
			
			System.out.printf("%d starts \n", getIndex());
			list.add(new StringBuilder(object));
			
			if(getIndex() % 15000 == 0) {
				list = new ArrayList<>();	 
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%d Done \n", getIndex());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.asela.gc.GCTestInterface#getIndex()
	 */
	@Override
	public int getIndex() {
		return index;
	}
	
	/* (non-Javadoc)
	 * @see com.asela.gc.GCTestInterface#increment()
	 */
	@Override
	public void increment() {
		index++;
	}

}
