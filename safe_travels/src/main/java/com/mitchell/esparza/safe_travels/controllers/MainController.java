package com.mitchell.esparza.safe_travels.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.mitchell.esparza.safe_travels.models.Travel;
import com.mitchell.esparza.safe_travels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class MainController {
    
        @Autowired
        TravelService travelService; //creating a travel object that'll store created travels from our form
    
        @GetMapping("/") //this route is: localhost:8080/travels since we are using the @RequestMapping annotation to apply the /travels route to all the other routes in the TravelController class
        public String index(Model model, @ModelAttribute("travel") Travel travel) { //creating a travel object that'll store created travels from our form 
            List<Travel> travels = travelService.allTravels();
            model.addAttribute("travels", travels);     //adding the travels to the model so that we can access them in the index.jsp file like ${travel.title} and ${travel.description}
            return "index.jsp";
        }

        @PostMapping("/travels/create")
        public String create(
            @Valid @ModelAttribute("travel") Travel travel,
            BindingResult result, Model model) { //adding Model model to access the travel object we create
            if (result.hasErrors()) {             //if there are any errors in the form according to the validations set in the Travel class, return back to the index.jsp
                List<Travel> travels = travelService.allTravels();
                model.addAttribute("travels", travels);
                return "index.jsp";
            }
            travelService.createTravel(travel);
            return "redirect:/";
        }

        @GetMapping("/travels/{id}/edit") //brings a specific travel to edit via an edit form
        public String edit(
            @PathVariable("id") Long id,
            Model model) {
                Travel travel = travelService.findTravel(id);
                model.addAttribute("travel", travel);
                return "edit.jsp";
            }
        
        @PostMapping("/travels/{id}/update") //the route that processes the update 
        public String update(
            @Valid @ModelAttribute("travel") Travel travel,
            BindingResult result) {
                if (result.hasErrors()) {
                    return "edit.jsp";
                }
                travelService.updateTravel(travel);
                return "redirect:/";
            }

        @DeleteMapping("/travels/{id}/delete") //deletes a travel by its id
        public String delete(
            @PathVariable("id") Long id) {
                travelService.deleteTravel(id);
                return "redirect:/";
            }
        
        @GetMapping("/travels/{id}") //shows a specific travel
        public String show(
            @PathVariable("id") Long id,
            Model model) {
                Travel travel = travelService.findTravel(id);
                model.addAttribute("travel", travel);
                return "show.jsp";
            }
}
