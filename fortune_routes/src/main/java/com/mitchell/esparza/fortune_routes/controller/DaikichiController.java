package com.mitchell.esparza.fortune_routes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;


@Controller //this annotation is needed to make this class a controller, to use lines 18-68 use @RestController instead 

@RequestMapping("/daikichi") //we add this annotation to the class to make the path for all methods start with /daikichi
public class DaikichiController {
    // @RequestMapping("")
    // public String index() {
    //     return "Welcome! Let me tell you your fortune! \n Just type in '/today' or '/tomorrow' at the end of the URL to get your fortune!";
    // }
    // @RequestMapping("/today")
    // public String today() {
    //     return "Today you will literally explode into 43 pieces of stone. There will be no way to stop this. \n You will be missed.";
    // }
    // @RequestMapping ("/tomorrow")
    // public String tomorrow() {
    //     return "Tomorrow you will find a bag of money worth 42 quintillion yen on the street. \n Then you will explode right after.";
    // }

    // //-------------create a route that can take in a city name as a path variable to display a message about traveling to that city-----------------
    // @RequestMapping("/travel/{city}") 
    // public String travel(@PathVariable("city") String city) {
    //     String congrats = "Congratulations! You will soon travel to " + city + "!";
    //     String nope = "Sorry but you will never travel to " + city + ". Do to sheer bad luck, you have just been banned by " + city + "'s government from ever entering the country for no reason.";
    //     //randomly generate one of the two strings above to be returned
    //     int randint = (int) (Math.random() * 2); //generates a random number between 0 and 1
    //     if (randint == 0) {                     //this gives it a 50/50 chance of returning either string
    //         return congrats;
    //     }
    //     else {
    //         return nope;
    //     }
    // } 
    // //-----------------create a 'lotto' route that will display a select number of fortunes based on wether the user input in the URL is even or odd-----------------
    // @RequestMapping("/lotto/{num}")
    // public String lotto(@PathVariable("num") int num) { //if num is even, return one of the following strings
    //     if (num % 2 == 0) {                            //if num is a multiple of 2, it is even
    //         String[] even =
    //             {
    //             "You will win whatever your current balance is in your bank account, times 100!", 
    //             "You will stumble across some of the most delicious food you have ever tasted in your life!", 
    //             "You will encounter a shooting star very soon, and your wish will come true!"
    //             };
    //         int randint = (int) (Math.random() * 3); //generates a random number between 0 and 2, selects one of the strings above to be returned based on the random number and the index of the array
    //         return even[randint];
    //     }
    //     else { //if num is odd, return one of the following strings
    //         String[] odd =
    //             {
    //             "You will have a fight-til-the-death battle with a bear in the near future. You will survive, but you will always have to watch your back, as a large-scale bear crime syndicate will now always be on your tail.",
    //             "You will step on a lego, and you might not survive.",
    //             "Your next cigarette will be be a stick of dynamite that just so happens to look like a cigarette. Yikes...",
    //             };
    //         int randint = (int) (Math.random() * 2);
    //         return odd[randint];
    //     }
    // }

//----------------------------------------------OMOKUJI FORM ASSIGNMENT-------------------------------------------------
//1.remder a route to render the home page that shows the Omikuji form
    @GetMapping("/omikuji/form")
    public String form() {
        return "form.jsp";
        }
//2.create a route that processes the form submission
    @PostMapping("/omikuji/process") //Post mapping is used to process the form submission
    public String process(HttpSession session, //adding HttpSession to use session in our jsp file
        @RequestParam(value="number") String number, //the request param is used to get the value of the input with the name "number" from the form
        @RequestParam(value="city") String city,    //then use the session.setAttribute method to set the value of the input to the session
        @RequestParam(value="name") String name,
        @RequestParam(value="profession") String profession,
        @RequestParam(value="thing") String thing,
        @RequestParam(value="comment") String comment) {
            session.setAttribute("number", number); 
            session.setAttribute("city", city);
            session.setAttribute("name", name);
            session.setAttribute("profession", profession);
            session.setAttribute("thing", thing);
            session.setAttribute("comment", comment);
            return "redirect:/daikichi/show"; //redirect to the results route
        }
        
        @GetMapping("/show") //Get mapping is used to display the results of the form submission
        public String results(HttpSession session) {//to use display the input values from the form, we need to use the session.getAttribute method to get the values from the session
            session.getAttribute("number");
            session.getAttribute("city");
            session.getAttribute("name");
            session.getAttribute("profession");
            session.getAttribute("thing");
            session.getAttribute("comment");
            return "results.jsp";
        }
    }
