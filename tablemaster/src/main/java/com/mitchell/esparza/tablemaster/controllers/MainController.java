package com.mitchell.esparza.tablemaster.controllers;

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

import com.mitchell.esparza.tablemaster.models.UserTable;
import com.mitchell.esparza.tablemaster.models.User;
import com.mitchell.esparza.tablemaster.services.UserService;
import com.mitchell.esparza.tablemaster.services.TableService;

@Controller
public class MainController{
    @Autowired
    private UserService userServ;
    @Autowired
    private TableService tableServ; 

    @GetMapping("/home/yourTables")
    public String home (Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //allows us to use user in jsp like: ${user.firstName}
        //adding all tables that belong to the logged in user to the model to display on the home page
        List<UserTable> userTables = tableServ.getAllTablesByUser(user);
        model.addAttribute("userTables", userTables);
        return "userTables.jsp";
    }

    @GetMapping("/addTable")
    public String addTable(@ModelAttribute("table") UserTable table, HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            System.out.println("User is not logged in");
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); //allows us to use user in jsp like: ${user.firstName}
        return "newTable.jsp";
    }
    @PostMapping("/addTable/new")
    public String createTable(@Valid @ModelAttribute("table") UserTable table, BindingResult result, HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); 
        //if there are errors with the table form, return to the newTable page
        if(result.hasErrors()){ 
            System.out.println( "ERROR WITH NEW TABLE:" + result);
            return "newTable.jsp";
        }
        table.setUser(user); //set the uploader of the table to the user who is logged in
        tableServ.createTable(table); //create the table in the db
        System.out.println("Table " + table.getId() + ", Created by: " + user.getUserName());
        return "redirect:/home/yourTables";
    }

    @GetMapping("/allTables") //this leads to a table page of all tables in the db
    public String showtable(@ModelAttribute("table") UserTable table, HttpSession session, Model model){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, get user from db and add them to the model
        User user = userServ.findUserById(userId);
        model.addAttribute("user", user); 
        //adding all tables to the model to display on the home page
        List<UserTable> allTables = tableServ.getAllTables();
        model.addAttribute("allTables", allTables); //allows us to use allTables in jsp like: ${allTables.guestName}
        return "allTables.jsp";
    }


    @GetMapping("/table/{id}/edit")
    public String editTable(@ModelAttribute("table") UserTable table, HttpSession session, Model model, @PathVariable("id") Long id){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //grabbing table to be edited from db and adding it to the model
        UserTable tableToEdit = tableServ.getOneTable(id);
        //if they are logged in, get user from db and add them to the model
        model.addAttribute("table", tableToEdit); //allows us to use table in jsp like: ${table.numberOfGuests}
        model.addAttribute("user", userServ.findUserById(userId)); // allows us to use the logged in user in jsp like: ${user.firstName}
        return "editTable.jsp";
    }

    @PostMapping("/table/{id}/edit")
    public String processEdit(@Valid @ModelAttribute("table") UserTable table, BindingResult result, HttpSession session, Model model, @PathVariable("id") Long id){
        //checking table form validations
        if(result.hasErrors()){ //if there are errors with the table form, return to the editTable page
            System.out.println( "ERROR WITH EDIT TABLE:" + result);
            return "editTable.jsp";
        }
        //else, grab table to be edited from db and update fields
        UserTable tableToEdit = tableServ.getOneTable(id);
        tableToEdit.setNumOfGuests(table.getNumOfGuests());
        tableToEdit.setGuestName(table.getGuestName());
        tableToEdit.setNotes(table.getNotes());
        tableServ.updateTable(tableToEdit); //update the table in the db
        System.out.println("table updated:" + id + ", by: " + tableToEdit.getUser().getUserName());
        return "redirect:/home/yourTables"; //redirect to the user's list of tables
    }

    @GetMapping("/table/{id}/delete")
    public String deleteTable(@PathVariable("id") Long id, HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        //if user is not logged in, redirect to login page
        if(userId == null){
            return "redirect:/home";
        }
        //if they are logged in, delete the table from the db
        tableServ.deleteTable(id);
        return "redirect:/home/yourTables"; //redirect to the user's list of tables
    }
}
