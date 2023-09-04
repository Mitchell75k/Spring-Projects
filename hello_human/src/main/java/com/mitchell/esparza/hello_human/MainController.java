package com.mitchell.esparza.hello_human;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController //this annotation is needed to make this class a controller
public class MainController { 
    @RequestMapping("/") 
    public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String lname, @RequestParam(value = "times", required = false) String times) { //we include the @RequestParam annotation to get the query string parameter
        
        if (times == null) {
            if( name == null && lname == null ) //if name and last name are not present in the query string parameter return the following string
                return "Hello Human!";
            else if ( name == null) //if last name is present and name is not present in the query string parameter return the following string
                return "Hello " + lname + "!";
            else if (lname == null) //if name is present and last name is not present in the query string parameter return the following string
                return "Hello " + name + "!"; //&& stands for AND, & stands for OR
            else
                return "Hello " + name + " " + lname + "!";
            }
        
        else; //if times != null, return "hello human" times number of times
            int num = Integer.parseInt(times); //converting the string to an integer to be able to use it in the for loop 
            String str = "";                  //empty string to store the string to be returned
            for (int i = 0; i < num; i++) {  //for looping to concatenate the string to be returned
                if( name == null && lname == null ) 
                    str += "Hello Human! "; 
                else if ( name == null)
                    str += "Hello " + lname + "! ";
                else if ( lname == null) 
                    str += "Hello " + name + "! "; 
                else
                    str += "Hello " + name + " " + lname + "! ";
            }
            return str;
        }
}
