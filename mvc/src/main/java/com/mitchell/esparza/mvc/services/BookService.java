package com.mitchell.esparza.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.mitchell.esparza.mvc.models.Book;
import com.mitchell.esparza.mvc.repositories.BookRepository; 

//this is a service file that will be used to create a service that will be used to query the database
//services are used to separate the logic of the application from the controller
//this will allow us to reuse the same service in multiple controllers without having to rewrite the same code
//this will also allow us to easily make changes to the database queries without having to change the code in multiple controllers

@Service // @Service annotation tells Spring that this is a service file
public class BookService {
     // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) { //this constructor will be used to create an instance of the BookService class that will be used to query the database
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {                                 //this method will be used to retrieve a book from the database by its id
        Optional<Book> optionalBook = bookRepository.findById(id); //the Optional class is a container object that may or may not contain a non-null value
        if(optionalBook.isPresent()) {                            //if the optionalBook object contains a non-null value, then return the book object
            return optionalBook.get();                           // .get() returns the value if it is present, otherwise throws NoSuchElementException
        } else {
            return null;                                       //if the optionalBook object does not contain a non-null value, then return null
        }
    }
    
    // deletes a book by its id
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // updates a book and takes in the id of the book to be updated and the new information for the book
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
