package br.com.bcp.integration;

public class PersonDirectoryService {

	public Person findNewPeople() {
		System.out.println("Inbound adapter has polled this service");
		return new Person("Bruno", "Proenca");
	}
}
