package pl.spring.demo.service;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.search.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
    List<BookEntity> findBooksBySearchCriteria(BookSearchCriteria searchCriteria);

    BookTo saveBook(BookTo book);
    BookTo removeBook(BookTo book);
}
