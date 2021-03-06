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
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String returnSurnameAndName() {
		return surname + " " + name;
	}
	
}
