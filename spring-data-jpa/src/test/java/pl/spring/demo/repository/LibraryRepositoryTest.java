package pl.spring.demo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

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

}
