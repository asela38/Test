package com.asela.casting;

import java.util.HashMap;
import java.util.Map;

public class CastingExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String, CharSequence> map = getNameMap();		
		
		StringBuffer nameb = (StringBuffer) map.get("name1");
		nameb.append("a");
		
		CharSequence charSequence = map.get("name1");
		String s = (String)charSequence;
		
		s = s + "a";
		s = s.concat("a");
		

	}

	private static Map<String, CharSequence> getNameMap() {
		Map<String, CharSequence> map = new HashMap<>();
		
		map.put("name", "Asela");
		map.put("name1", new StringBuffer("Asela"));
		return map;
	}

}
