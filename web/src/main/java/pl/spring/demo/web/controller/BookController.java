package pl.spring.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spring.demo.service.BookService;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.BookTo;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
	
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String bookList(Map<String, Object> params) {
        final List<BookTo> allBooks = bookService.findAllBooks();
        params.put("books", allBooks);
        return "bookList"; 
    }
    
    @RequestMapping(value = "/BookController/oJaNieMoge/{id}", method = RequestMethod.GET) 
    public String oJaNieMoge(@ModelAttribute(value = "id") Long id, Map<String, Object> params) {
    	List<BookTo> allBooks = bookService.findAllBooks();
    	BookTo book = null;
    	for(BookTo bookTo : allBooks) {
    		if(bookTo.getId() == id) {
    			book = bookTo;
    			break;
    		}
    	}
    	bookService.removeBook(book);
    	allBooks = bookService.findAllBooks();
    	params.put("books", allBooks);
    	return "redirect:/kotLeon";
    }
    
    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public BookTo addBook(@ModelAttribute(value = "newBook") BookTo newBook, Map<String, Object> params) {
    	List<BookTo> allBooks = bookService.findAllBooks();
    	bookService.saveBook(newBook);
    	allBooks = bookService.findAllBooks();
    	params.put("books", allBooks);
    	return newBook;
    }
}

/*(@ModelAttribute(value = "id") Long id*/
