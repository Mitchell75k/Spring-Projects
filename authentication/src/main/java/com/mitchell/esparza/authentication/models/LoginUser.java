package com.mitchell.esparza.authentication.models;

//this model will be used for validating input from our login form
//we will never save LoginUser instances to the database, we're only using it to validate input

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/*
 * Notice how this model does not have the @Entity annotation, and it only has email and password as those are the fields a user must fill in to log into our app. 
 * Although we still will utilize validation constraints, it's a bit more like a plain old OOP Java class. 
 * It is not an entity in our database, and we only use it temporarily to validate the form input when the user logs in. 
 * After form input passes or doesn't pass validation and authentication, that LoginUser instance disappears.
 */

public class LoginUser {
    
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotEmpty(message="Password is required!")
    @Size(min=4, max=128, message="Password must be between 4 and 128 characters")
    //if password is not found in the database display an error:
    
    private String password;
    
    public LoginUser() {
        //empty constructor to instantiate objects in the controller
    }
    
    // TODO - Don't forget to generate getters and setters

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
