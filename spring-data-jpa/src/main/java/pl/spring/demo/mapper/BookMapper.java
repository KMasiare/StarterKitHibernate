package pl.spring.demo.mapper;

import pl.spring.demo.PersonalData;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookTo map(BookEntity bookEntity) {
        if (bookEntity != null) {
            return new BookTo(bookEntity.getId(), bookEntity.getTitle(), bookEntity.returnAuthorsString());
        }
        return null;
    }

    public static BookEntity map(BookTo bookTo) {
        if (bookTo != null) {
        	String[] authors = bookTo.getAuthors().split(" ");
        	List<AuthorEntity>authorsList = new ArrayList<AuthorEntity>();
        	for (int i = 0; i < authors.length - 1; i += 2) {
        		PersonalData ps = new PersonalData(authors[i], authors[i+1]);
        		authorsList.add(new AuthorEntity(ps));
        	}
        	
            return new BookEntity(bookTo.getId(), bookTo.getTitle(), authorsList);
        }
        return null;
    }

    public static List<BookTo> map2To(List<BookEntity> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }

    public static List<BookEntity> map2Entity(List<BookTo> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }
}
