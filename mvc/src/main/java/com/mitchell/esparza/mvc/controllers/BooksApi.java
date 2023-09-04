package com.mitchell.esparza.mvc.controllers;

// ..
import java.util.List;
import com.mitchell.esparza.mvc.models.Book;
import com.mitchell.esparza.mvc.services.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

//this file is the controller file that will be used to create a controller that will be used to route the requests to the appropriate methods in the service file
//the controller will be used to handle the requests and the service will be used to query the database
//we are using an api controller instead of a regular controller because we will be returning json responses instead of rendering templates

//we are using Postman api development tool to test our api, which we connect by running the server and then going to http://localhost:8080/api/books in the browser and then using Postman to send requests to the api
//api's are not usually implemented in the browser, they are implemented in the backend and are used to send data to the frontend
//but we are using the browser to test our api because it is easier to see the json responses in the browser than in Postman

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){ //this constructor will be used to create an instance of the BooksApi class that will be used to route the requests to the appropriate methods in the service file
        this.bookService = bookService;
    }
    @RequestMapping("/api/books") // @RequestMapping annotation tells Spring that this method will be used to handle GET requests sent to the /api/books route
    public List<Book> index() {
        return bookService.allBooks(); //this method will be used to retrieve all the books from the database
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST) // @RequestMapping annotation tells Spring that this method will be used to handle POST requests sent to the /api/books route
    public Book create(
        @RequestParam(value="title") String title, 
        @RequestParam(value="description") String desc, 
        @RequestParam(value="language") String lang, 
        @RequestParam(value="pages") Integer numOfPages) {
            Book book = new Book(title, desc, lang, numOfPages);
            return bookService.createBook(book); //this method will be used to create a book in the database
        }
    
    @RequestMapping("/api/books/{id}") // @RequestMapping annotation tells Spring that this method will be used to handle GET requests sent to the /api/books/{id} route
    public Book show(@PathVariable("id") Long id) { 
        return bookService.findBook(id); //this method will be used to retrieve a book from the database by its id
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT) //
    public Book update(
        @PathVariable("id") Long id,    // @PathVariable annotation tells Spring that this method will be used to handle PUT requests sent to the /api/books/{id} route
        @RequestParam(value="title") String title, 
        @RequestParam(value="description") String desc, 
        @RequestParam(value="language") String lang,
        @RequestParam(value="pages") Integer numOfPages) {
            Book book = new Book(title, desc, lang, numOfPages);
            book.setId(id);                       //.setId() will be used to set the id of the book object that we are creating to the id that we are passing in as a parameter
            return bookService.updateBook(book); //this method will be used to update a book in the database
        }
    
        @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
        public void destroy(@PathVariable("id") Long id) {
            bookService.deleteBook(id);
        }
    }