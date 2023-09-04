package com.mitchell.esparza.tablemaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.mitchell.esparza.tablemaster.models.LoginUser;
import com.mitchell.esparza.tablemaster.models.User;
import com.mitchell.esparza.tablemaster.services.UserService;

@Controller
public class LoginController{
    @Autowired
    private UserService userServ;
        //LOGIN ROUTES-----------------------------------------------------------------------------------------------
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
            userServ.register(newUser, result);
            if(result.hasErrors()) {
                model.addAttribute("newLogin", new LoginUser());
                return "index.jsp";
            }
            // if no errors:
            session.setAttribute("userId", newUser.getId());
            System.out.println("User created:" + newUser.getUserName());
            return "redirect:/home/yourTables";
        }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
            User user = userServ.login(newLogin, result);
            if(result.hasErrors()) {
                model.addAttribute("newUser", new User()); //this is so the user can see the registration form again
                System.out.println( "ERROR WITH LOGIN USER:" + result.toString());
                return "index.jsp";
            }
        // No errors! 
        session.setAttribute("userId", user.getId());
        //UPDATE- change this to redirect them to the new route that displays all tables in the database
        return "redirect:/home/yourTables"; 
    }

    //logout route
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
    


}