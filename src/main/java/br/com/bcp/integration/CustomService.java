package br.com.bcp.integration;

public class CustomService {

	public String getPhoneNumber(Person person) {
		if ("bruno".equalsIgnoreCase(person.getFirstName())) {
			return "1111";
		} else {
			return "2222";
		}
	}
}
