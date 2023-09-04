package com.mitchell.esparza.book_club.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.mitchell.esparza.book_club.models.Book;
import com.mitchell.esparza.book_club.models.LoginUser;
import com.mitchell.esparza.book_club.models.User;
import com.mitchell.esparza.book_club.services.UserService;
import com.mitchell.esparza.book_club.services.BookService;

@Controller
public class MainController{
    @Autowired
    private UserService userServ;
    @Autowired
    private BookService bookServ;

    @GetMapping("/home/bookclub")
    public String home (Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //allows us to use user in jsp like: ${user.firstName}
        //adding all books to the model to display on the home page
        List<Book> allBooks = bookServ.getAllBooks();
        model.addAttribute("allBooks", allBooks);
        return "books.jsp";
    }

    @GetMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            System.out.println("User is not logged in");
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //allows us to use user in jsp like: ${user.firstName}
        return "addBook.jsp";
    }
    @PostMapping("/addBook/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); 
        //if there are errors with the book form, return to the addBook page
        if(result.hasErrors()){ 
            return "addBook.jsp";
        }
        book.setUser(user); //set the uploader of the book to the user who is logged in
        bookServ.createBook(book); //create the book in the db
        System.out.println("Book created by: " + user.getUserName());
        return "redirect:/home/bookclub";
    }

    @GetMapping("/book/{id}")
    public String showBook(@ModelAttribute("book") Book book, HttpSession session, Model model, @PathVariable("id") Long id){
        Long userId = (Long) session.getAttribute("userId");
        User postedUser = bookServ.getOneBook(id).getUser(); //get the user who posted the book
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        Book shownBook = bookServ.getOneBook(id);
        model.addAttribute("book", shownBook); //allows us to use book in jsp like: ${book.title}
        model.addAttribute("user", userServ.findUserById(userId)); // allows us to use the logged in user in jsp like: ${user.firstName}
        //add the user who posted the book to the model so we can display them
        model.addAttribute("bookReviewer", postedUser);
        return "showBook.jsp";
    }

    @GetMapping("/book/{id}/edit")
    public String editBook(@ModelAttribute("book") Book book, HttpSession session, Model model, @PathVariable("id") Long id){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //grabbing book to be edited from db and adding it to the model
        Book bookToEdit = bookServ.getOneBook(id);
        //checking if the user who is logged in is the uploader of the book
        if(bookToEdit.getUser().getId() != userId){
            return "redirect:/home/bookclub"; //if not, redirect to home page
        }
        //if they are logged in, get user from db and add them to the model
        model.addAttribute("book", bookToEdit); //allows us to use book in jsp like: ${book.title}
        model.addAttribute("user", userServ.findUserById(userId));
        return "editBook.jsp";
    }

    @PostMapping("/book/{id}/edit")
    public String processEdit(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model, @PathVariable("id") Long id){
        //checking book form validations
        if(result.hasErrors()){ //if there are errors with the book form, return to the editBook page
            return "editBook.jsp";
        }
        //else, grab book to be edited from db and update fields
        Book bookToEdit = bookServ.getOneBook(id);
        bookToEdit.setTitle(book.getTitle());
        bookToEdit.setAuthor(book.getAuthor());
        bookToEdit.setThoughts(book.getThoughts());
        bookServ.updateBook(bookToEdit); //update the book in the db
        System.out.println("Book updated");
        return "redirect:/book/" + id; //redirect to the show page for the newly edited book
    }

    @GetMapping("/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //grabbing book to be deleted from db
        Book bookToDelete = bookServ.getOneBook(id);
        //checking if the user who is logged in is the uploader of the book
        if(bookToDelete.getUser().getId() != userId){
            return "redirect:/home/bookclub"; //if not, redirect to home page
        }
        //if they are logged in, delete the book from the db
        bookServ.deleteBook(id);
        return "redirect:/home/bookclub";
    }


}