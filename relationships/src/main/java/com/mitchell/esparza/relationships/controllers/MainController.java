package com.mitchell.esparza.relationships.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitchell.esparza.relationships.models.License;
import com.mitchell.esparza.relationships.models.Person;
import com.mitchell.esparza.relationships.services.LicenseService;
import com.mitchell.esparza.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
public class MainController {
    @Autowired
    PersonService personService; //creating a person object that'll store created persons from our form
    LicenseService licenseService; //creating a license object that'll store created licenses from our form
    @GetMapping("/persons/{person_id}")
        public String showPerson(@PathVariable Long person_id, Model model) {
            Person somePerson = personService.findPerson(person_id);
            model.addAttribute("person", somePerson);
            return "showPerson.jsp";
            }        
        //we dont need to call the license service here or add it to our view model for it to render 
        //this is because the Person model has a license member variable
        //so we can fetch a license object through the person object (see showPerson.jsp) like so : ${person.license.number}

    @PostMapping("/licenses") //this route will process the creation of a license
public String licenses(@Valid @ModelAttribute("license") License license) {
    // error handling with binding result omitted    
    licenseService.createLicense(license); // Already has the person!
    return "redirect:/persons"; //redirecting to the person page to show the new license 
    }


    @GetMapping("/persons/new")
public String newPerson(@ModelAttribute("person") Person person, Model model) {
    return "newPerson.jsp";
    }
    @PostMapping("/persons/create") //this route will process the creation of a person
public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    if (result.hasErrors()) {
        return "newPerson.jsp";
    }
    personService.createPerson(person);
    return "redirect:/persons";
    }


    @GetMapping("/persons") //this route will display all the persons (home page)
    public String showPersons(Model model) {
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "index.jsp";
    }

    @GetMapping("/licenses/new")
public String newLicense(@ModelAttribute("license") License license, Model model) {
    return "newLicense.jsp";
    }
    
    @PostMapping("/licenses/create") //this route will process the creation of a license
    public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
    if (result.hasErrors()) {
        return "newLicense.jsp";
    }
    licenseService.createLicense(license); //Already has the person in the database because we created it in the createPerson method!
    return "redirect:/persons"; //redirecting to the person page to show the new license
    }
}




