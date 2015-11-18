package pl.spring.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {
	
    @Autowired
    private LibraryDao libDao;

	@Test
	public void testShouldFindLibraryByName() {
	    // given
	    final String libName = "med";
	    // when
	    List<LibraryEntity> libEntity = libDao.findLibraryByName(libName);
	    // then
	    assertNotNull(libEntity);
	    //assertFalse(libEntity.isEmpty());
	    //assertEquals("Mediateka", libEntity.get(0).getName());
	}

}