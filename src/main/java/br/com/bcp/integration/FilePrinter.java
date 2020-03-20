package br.com.bcp.integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter {

	public void print (String file) {
		System.out.println("Invoking the print method with a STRING");
		System.out.println(file);
	}
	
	public void print(File file) {
		System.out.println("Invoking the print method with a FILE");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
