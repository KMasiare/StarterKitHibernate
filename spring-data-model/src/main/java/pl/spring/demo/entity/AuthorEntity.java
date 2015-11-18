package pl.spring.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.spring.demo.PersonalData;

@Entity
@Table(name = "AUTHOR")
public class AuthorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "name", column = @Column(name = "NAME", nullable = false)),
		@AttributeOverride(name = "surname", column = @Column(name = "SURNAME", nullable = false))
	})
	private PersonalData personalData;
	
	// for hibernate
	public AuthorEntity() {
		
	}
	
	public AuthorEntity(PersonalData ps) {
		this.personalData = ps;
	}
	
	public PersonalData getPersonalData() {
		return personalData;
	}
}
