package pl.spring.demo;

import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {
	String name;
	String surname;
	
	public PersonalData(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	// for hibernate
	public PersonalData() {
	}
	
	
}
