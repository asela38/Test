package com.asela.annotation;

import java.lang.reflect.Field;

public class DefaultUtil {

	
	public static <T> T  defaultNulls(Class<T> tcalss, T t) {
	
		Field[] declaredFields = tcalss.getDeclaredFields();
		for (Field field : declaredFields) {
			if(field.isAnnotationPresent(Default.class)){
				field.setAccessible(true);
				Class<?> type = field.getType();
				if(type.isAssignableFrom(String.class)) {
					try {
						if ( field.get(t) == null) {
						 field.set(t, "Empty<" + field.getName() +">");
						}
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return t;
	}
}
