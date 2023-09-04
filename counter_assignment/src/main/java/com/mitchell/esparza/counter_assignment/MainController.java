package com.mitchell.esparza.counter_assignment;

import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("count") == null){ // if session is empty
            session.setAttribute("count", 0); // set count to 0
        }
        else{
            Integer count = (Integer) session.getAttribute("count"); // get count from session
            count++; // increment count
            session.setAttribute("count", count); // set count to session to be used in jsp
        }
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model){
        model.addAttribute("count", session.getAttribute("count")); // add count to model to be used in jsp
        return "counter.jsp";
    }
}
