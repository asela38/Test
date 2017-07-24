package com.asela;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadClassFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\aillayapparachchi\\Test.class");
		FileInputStream in = new FileInputStream(file);
		
		int i = 0;
		while( (i = in.read()) != -1) {
			System.out.print(Integer.toHexString(i).toUpperCase());
		}
	}
}
