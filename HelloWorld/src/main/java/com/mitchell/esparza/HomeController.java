package com.mitchell.esparza;

import org.springframework.stereotype.Controller; //import this annotation to make this class a controller to be able to render jsp files from your controller
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model; //import this class to be able to pass data INTO the jsp file 



@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) { 										 //pass in the Model object, "model", to be able to pass data into the jsp file
	model.addAttribute("dojoName", "Burbank"); //add the attribute "dojoName" to the model object, and set its value to "burbank". 
																		   //To have it display in the jsp file, we need to use the ${} syntax in the jsp file (see demo.jsp)
		return "demo.jsp";		//this is the index.jsp file that will be rendered when the user goes to the root route, instead of us having to manually type in the path to the file like we would with a @RestController
	}
}