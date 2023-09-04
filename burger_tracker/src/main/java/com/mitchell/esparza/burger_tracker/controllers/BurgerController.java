package com.mitchell.esparza.burger_tracker.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mitchell.esparza.burger_tracker.models.Burger;
import com.mitchell.esparza.burger_tracker.services.BurgerService;

import jakarta.validation.Valid;

//to apply a route to all the other routes in the BurgerController class, we can use the @RequestMapping annotation

@Controller
public class BurgerController {

    @Autowired
    BurgerService burgerService;

    @GetMapping("/") //this route is: localhost:8080/burgers since we are using the @RequestMapping annotation to apply the /burgers route to all the other routes in the BurgerController class
    
    public String index(Model model, @ModelAttribute("burger") Burger burger) { //creating a burger object that'll store created burgers from our form 
        List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);     //adding the burgers to the model so that we can access them in the index.jsp file like ${burger.title} and ${burger.description}
        return "/burgers/index.jsp";
    }

    // @GetMapping("/burgers/{id}")                     //shows a specific burger
    // public String show(
    //     @PathVariable("id") Long id, 
    //     Model model) {
    //         Burger burger = burgerService.findBurger(id);
    //         model.addAttribute("burger", burger);
    //         model.addAttribute("id", id);
    //         return "/burger/show.jsp";
    //     }


    @PostMapping("burgers/create")
    public String create(
        @Valid @ModelAttribute("burger") Burger burger, 
        BindingResult result, Model model) { //adding Model model to access the burger object we create
            if (result.hasErrors()) {             //if there are any errors in the form according to the validations set in the Burger class
                List<Burger> burgers = burgerService.allBurgers();
                model.addAttribute("burgers", burgers); //adding model and list to access the burgers in our table like we do in our index route
                return "/burgers/index.jsp";
            }
            burgerService.createBurger(burger);
            return "redirect:/";
            }

        @GetMapping("burgers/{id}/edit")                     //shows a specific burger to edit
        public String edit(
            @PathVariable("id") Long id, 
            Model model) {
                Burger burger = burgerService.findBurger(id);
                model.addAttribute("burger", burger); //adding the burger to the model so that we can access it in the edit.jsp file like ${burger.title} 
                return "/edit/edit.jsp";
            }

        @PostMapping("burgers/{id}/update")              //updates a burger (processor method)
        public String update(      
            @Valid @ModelAttribute("burger") Burger burger, 
            BindingResult result, Model model) {
                if (result.hasErrors()) {             //if there are any errors in the form according to the validations set in the Burger class
                    List<Burger> burgers = burgerService.allBurgers();
                    model.addAttribute("burgers", burgers); //adding model and list to access the burgers in our form like {burger.title} and {burger.description}
                    return "/edit/edit.jsp";
                    //even though we should never render on a post request, the validations we set prevent data from being submitted twice if it 
                    //doesnt pass validation. Plus it allows our form to hold user input so they dont have to type it all over again if they refresh
                }
                burgerService.updateBurger(burger);
                return "redirect:/";
            }
        @DeleteMapping("burgers/{id}/delete")                     //deletes a burger
        public String delete(
            @PathVariable("id") Long id) {
                burgerService.deleteBurger(id);
                return "redirect:/";
            }
        
}
