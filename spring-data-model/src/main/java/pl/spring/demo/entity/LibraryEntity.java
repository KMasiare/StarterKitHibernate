package pl.spring.demo.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=50, nullable = false)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "library_id")
	private Collection<BookEntity> books;
	
	// for hibernate
	public LibraryEntity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Collection<BookEntity> books) {
		this.books = books;
	}

}
