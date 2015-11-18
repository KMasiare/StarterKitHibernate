package pl.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.LibraryEntity;

public class LibraryDaoImpl extends AbstractDao<LibraryEntity, Long> implements LibraryDao{

	@Override
	public List<LibraryEntity> findLibraryByName(String name) {
		TypedQuery<LibraryEntity> query = entityManager.createQuery(
				"select library from LibraryEntity library where upper(library.name) like concat(upper(:name), '%')", 
				LibraryEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

}

/*public List<BookEntity> findBookByTitle(String title) {
    TypedQuery<BookEntity> query = entityManager.createQuery(
            "select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')", BookEntity.class);
    query.setParameter("title", title);
    return query.getResultList();
}*/