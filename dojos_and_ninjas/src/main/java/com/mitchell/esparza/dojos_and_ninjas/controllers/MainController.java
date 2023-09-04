package com.mitchell.esparza.dojos_and_ninjas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitchell.esparza.dojos_and_ninjas.models.Dojo;
import com.mitchell.esparza.dojos_and_ninjas.models.Ninja;
import com.mitchell.esparza.dojos_and_ninjas.services.DojoService;
import com.mitchell.esparza.dojos_and_ninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
    @Autowired
    DojoService dojoService;

    @Autowired
    NinjaService ninjaService;

    //Dojo controller routes
    @GetMapping("/dojos/new") //this route will display the form for creating a new dojo
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model) {
        return "newDojo.jsp";
    }
    @PostMapping("/dojos/create") //this route will process the creation of a dojo
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "newDojo.jsp";
        }
        Dojo newDojo = dojoService.createDojo(dojo);
        //redirects to the specific dojo page that was created
        System.out.printf("New Dojo: %s, New Dojo id: %d", newDojo, newDojo.getId());
        return "redirect:/dojos/" + dojo.getId();
    }
    @GetMapping("/dojos/{dojoId}") //this route will display a specific dojo
    public String showDojo(@PathVariable("dojoId") Long dojoId, Model model) {
        Dojo dojo = dojoService.findDojo(dojoId);
        model.addAttribute("dojo", dojo); //allows us to display the dojo info l
        return "showDojo.jsp";
    }



    //Ninja controller routes
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "newNinja.jsp";
    }

    @PostMapping("/ninjas/create") //this route will process the creation of a ninja
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println( "ERROR:" + result.toString());
            return "newNinja.jsp";
        }
        ninjaService.createNinja(ninja);
        //redirects to the specific dojo that the ninja was assigned to
        System.out.printf("New Ninja: %s, New Ninja id: %d", ninja, ninja.getId());
        return "redirect:/dojos/" + ninja.getDojo().getId(); //calling the dojo id from the ninja object
    }

    //delete a ninja from a dojo
    @GetMapping("/ninjas/{ninjaId}/delete")
    public String deleteNinja(@PathVariable("ninjaId") Long ninjaId) {
        Long dojoId = ninjaService.findNinja(ninjaId).getDojo().getId(); //getting the dojo id before deleting so it can be redirected
        ninjaService.deleteNinja(ninjaId);
        return "redirect:/dojos/" + dojoService.findDojo(dojoId).getId();
    }
    
}
