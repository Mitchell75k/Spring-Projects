package com.mitchell.esparza.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.mitchell.esparza.authentication.models.LoginUser;
import com.mitchell.esparza.authentication.models.User;
import com.mitchell.esparza.authentication.services.UserService;


@Controller
public class MainController {
    
    //Add once service is implemented:
    @Autowired
    private UserService userServ;
    
    @GetMapping("/home")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            System.out.println( "ERROR WITH LOGIN USER:" + result.toString());
            return "index.jsp";
        }
        // if no errors:
        session.setAttribute("userId", newUser.getId());
        //then redirect them to the user page
        return "redirect:/user/loggedIn";
    
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            System.out.println( "ERROR WITH LOGIN USER:" + result.toString());
            return "index.jsp";
        }
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
        return "redirect:/user/loggedIn";
    }

    //page to show that the user is logged in
    @GetMapping("/user/loggedIn")
    public String loggedIn(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId"); //this gets the user object from the session and stores it in a variable, allowing us to pass it to the jsp
        if (userId == null) {
            return "redirect:/home";
        }
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //this allows us to pass the user object to the jsp and display it like: {{user.userName}}
        return "userPage.jsp";
    }

    //logout route
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    
}
