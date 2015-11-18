package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {
	
	@Autowired
	private LibraryRepository libRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testShouldRemoveAllBooksWhichAreInLibrary() {
		// given
		
		// when
		libRepository.delete((long) 1);
		// then
		Assert.assertEquals(bookRepository.count(), 0);
	}
	
	@Test
	public void testShouldFindLibraryByName() {
		// given
		final String libraryName = "Med";
		// when
		List<LibraryEntity> libEntity = libRepository.findLibraryByName(libraryName);
		// then
		assertNotNull(libEntity);
		assertFalse(libEntity.isEmpty());
		assertEquals("Mediateka", libEntity.get(0).getName());
	}
}

/*// given
final String bookTitle = "T";
// when
List<BookEntity> booksEntity = bookRepository.findBookByTitle(bookTitle);
// then
assertNotNull(booksEntity);
assertFalse(booksEntity.isEmpty());
assertEquals("The lord of the rings", booksEntity.get(0).getTitle());*/
