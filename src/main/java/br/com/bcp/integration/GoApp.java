package br.com.bcp.integration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class GoApp {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Runnable runnable = () -> { 
			System.out.println("oi"); 
		};
		Future future = service.submit(runnable);

	}

}
