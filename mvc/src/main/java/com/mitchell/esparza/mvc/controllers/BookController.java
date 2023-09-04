package com.mitchell.esparza.mvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitchell.esparza.mvc.models.Book;
import com.mitchell.esparza.mvc.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
    // adding the book service as a dependency by using the @Autowired annotation
	@Autowired              // @Autowired annotation tells Spring to inject an instance of the BookService class into the BookController class
	BookService bookService;//this will allow us to use the bookService methods to query the database, and not have to create an instance of the BookService class in the BookController class
	
	@GetMapping("/")
	public String home() {
		return "redirect:/api/books";
	}

    //------This is the old way of adding the book service as a dependency without using the @Autowired annotation------
    // adding the book service as a dependency
    // private BookService bookService;
    
    // constructor for creating an instance of the BookController class so we can use the bookService methods to query the database
    // public BookController(BookService bookService){ 
    //     this.bookService = bookService; 
    // }

    @GetMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks(); //this method will be used to retrieve all the books from the database
        model.addAttribute("books", books); 
        return "/books/index.jsp";
    }

    @GetMapping("/books/{id}")
    public String show(
        @PathVariable("id") Long id, 
        Model model) {
            Book book = bookService.findBook(id);           //creating a book object that will be used to store the book that we retrieve from the database
            model.addAttribute("book", book); //adding the book object to the model so that we can access it in the show.jsp file like ${book.title} and ${book.description}
            model.addAttribute("id", id); //adding the id of the book to the model so that we can access it in the show.jsp file like ${id}
            return "/book/show.jsp";
        }

        @GetMapping("/books/new")
        public String newBook(@ModelAttribute("book") Book book) { //creating a book object that'll store created books from our form 
            return "/book/new.jsp";                               //this will then get passed to our /books/create route to be saved in the database
        }

        @PostMapping("/books/create")
        public String createBook(
        //This does the same as lines 72-77, but is more efficient
        @Valid @ModelAttribute("book") Book book,    //the @Valid annotation validates the book object based on the validations set in the Book class
        BindingResult result ) {                    //BindingResult object will check if there are any errors in the form
            if (result.hasErrors()) {              //if there are any errors in the form, then return the new.jsp file
                return "/book/new.jsp";
            }
            else {
                bookService.createBook(book);          //creates a book in the database if there are no errors in the form
                return "redirect:/books";
            }
        }
    }


            // @RequestParam("title") String title,
            // @RequestParam("description") String desc,
            // @RequestParam("language") String lang,
            // @RequestParam("numberOfPages") int pages) {
            //     Book book = new Book(title, desc, lang, pages); //creating a book object that will be used to store the book that we create
            //     bookService.createBook(book); //this method will be used to create a book in the database

