package com.asela.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {

		try (Socket client = new Socket(InetAddress.getLocalHost(), 44431)) {
			PrintWriter writer = new PrintWriter(client.getOutputStream());
			for (int j = 0; j < 10000; j++) {
				for (int i = 0; i < 10000; i++) {
					writer.write("123456789");
				}
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
