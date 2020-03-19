package br.com.bcp.integration;

public class PersonRegistrationService {

	public void registerEmail (Person person) {
		System.out.println("Email created to: " + person.getFirstName());
	}
}
