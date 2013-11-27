package com.asela.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Logger logger = getLogger();
		
		logger.log("Started");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.log("End.");
		
	}
	
	public static Logger getLogger() {
		return new  TimerStampWrapperLogger(new ConsoleLogger());
	}
	
	interface Logger {
		void log(String string);
	}
	
	public static class TimerStampWrapperLogger implements Logger {

		private Logger logger;
		
		public TimerStampWrapperLogger(Logger logger) {
			this.logger = logger;
		}
		
		@Override
		public void log(String string) {
			logger.log(new Date(System.currentTimeMillis()) + " :: " + string);
		}
		
	}
	
	public static class ConsoleLogger implements Logger{
		
		public void log(String string) {
			System.out.println(string);
		}
		
		public void logError(String string) {
			System.err.println(string);
		}
		
	}
	
	public static class FileLogger implements Logger{
		
		PrintWriter writer = null;
		
		public FileLogger() {
			File file = new File("c:\\Asela\\Log.log");
			if(file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				writer = new PrintWriter(fileOutputStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					writer.close();
					System.out.print("writer Closed.");
				}
			});
		}
		
		public void log(String log) {
			writer.write(log + "\n");
			writer.flush();
		}
	}
}
