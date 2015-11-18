package pl.spring.demo.entity;

import javax.persistence.*;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "BOOK_AUTHORS", 
    		joinColumns = {@JoinColumn(name = "book_id")},
    		inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<AuthorEntity> authors;

    // for hibernate
    protected BookEntity() {
}

    public BookEntity(Long id, String title, List<AuthorEntity> authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String returnAuthorsString() {
    	String allAuthors = null;
    	for (AuthorEntity author : authors) {
    		allAuthors = String.join(" ", allAuthors, author.getPersonalData().returnSurnameAndName());
    	}
    	return allAuthors;
    }

/*    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }*/
}
