package com.asela.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        @SuppressWarnings("rawtypes")
        Map map = (Map) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[] { Map.class },
                new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if("get".equals(method.getName())) {
					if(args.length == 1) {
						if(args[0].toString().equals("name")){
							return "Test";
						}
						return "XXXXX";
					}
				}
				return null;
			}
		});
		
		System.out.println(map.get("name1"));		

	}
}
