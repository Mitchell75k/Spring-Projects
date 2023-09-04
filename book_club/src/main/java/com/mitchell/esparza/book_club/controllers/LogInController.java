package com.mitchell.esparza.book_club.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.mitchell.esparza.book_club.models.Book;
import com.mitchell.esparza.book_club.models.LoginUser;
import com.mitchell.esparza.book_club.models.User;
import com.mitchell.esparza.book_club.services.UserService;
import com.mitchell.esparza.book_club.services.BookService;

@Controller
public class LogInController{
    @Autowired
    private UserService userServ;
    @Autowired
    private BookService bookServ;

        //LOGIN ROUTES-----------------------------------------------------------------------------------------------
        @GetMapping("/home")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "homePage.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
        BindingResult result, Model model, HttpSession session) {
            userServ.register(newUser, result);
            if(result.hasErrors()) {
                model.addAttribute("newLogin", new LoginUser());
                System.out.println( "ERROR WITH LOGIN USER:" + result.toString());
                return "homePage.jsp";
            }
            // if no errors:
            session.setAttribute("userId", newUser.getId());
            System.out.println("User created:" + newUser.getUserName());
            return "redirect:/user/loggedIn";
        }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
            User user = userServ.login(newLogin, result);
            if(result.hasErrors()) {
                model.addAttribute("newUser", new User()); //this is so the user can see the registration form again
                System.out.println( "ERROR WITH LOGIN USER:" + result.toString());
                return "homePage.jsp";
            }
        // No errors! 
        session.setAttribute("userId", user.getId());
        //UPDATE- change this to redirect them to the new route that displays all books in the database
        return "redirect:/home/bookclub";
    }

    @GetMapping("/user/loggedIn")
    public String loggedIn(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId"); //this gets the user object from the session and stores it in a variable, allowing us to pass it to the jsp
        if (userId == null) {
            return "redirect:/home";
        }
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //this allows us to pass the user object to the jsp and display it like: {{user.userName}}
        return "books.jsp";
    }

    //logout route
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    


}