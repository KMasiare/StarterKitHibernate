package pl.spring.demo.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.search.BookSearchCriteria;
import pl.spring.demo.service.BookService;

//@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../CommonServiceTest-context.xml")
public class BookServiceImplTest {
	
	@Autowired
	BookService bookService;

	@Test
	public void testShouldFindBookWhenOnlyTitle() {
		// given
		BookSearchCriteria searchCriteria = new BookSearchCriteria();
		searchCriteria.setTitle("The lord of the rings");
		// when
		List<BookEntity> books = new ArrayList<BookEntity>();
		books = bookService.findBooksBySearchCriteria(searchCriteria);
		//then
		Assert.assertEquals(books.get(0).getTitle(), "The lord of the rings");
	}

	@Test
	public void testShouldFindBookWhenTitleAndAuthor() {
		// given
		BookSearchCriteria searchCriteria = new BookSearchCriteria();
		searchCriteria.setTitle("The lord of the rings");
		searchCriteria.setAuthor("Tolkien");
		// when
		List<BookEntity> books = new ArrayList<BookEntity>();
		books = bookService.findBooksBySearchCriteria(searchCriteria);
		//then
		assertNotNull(books);
		assertFalse(books.isEmpty());
		Assert.assertEquals(books.get(0).getTitle(), "The lord of the rings");
	}
	
	@Test
	public void testShouldFindBookWhenTitleAndAuthorAndLibrary() {
		// given
		BookSearchCriteria searchCriteria = new BookSearchCriteria();
		searchCriteria.setTitle("The lord of the rings");
		searchCriteria.setAuthor("Tolkien");
		searchCriteria.setLibraryName("Mediateka");
		// when
		List<BookEntity> books = new ArrayList<BookEntity>();
		books = bookService.findBooksBySearchCriteria(searchCriteria);
		//then
		assertNotNull(books);
		assertFalse(books.isEmpty());
		Assert.assertEquals(books.get(0).getTitle(), "The lord of the rings");
	}
}
