package com.mitchell.esparza.book_club.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mitchell.esparza.book_club.models.User;
import com.mitchell.esparza.book_club.models.LoginUser;
import com.mitchell.esparza.book_club.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO - Reject values or register if no errors:
        // Reject if email is taken (present in database):
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "This email is already taken!");
            return null;
        }
        // Reject if password doesn't match confirmation:
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "Passwords do not match!");
            return null;
        }    
        // or else Hash and set password, save user to database if no errors
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
        }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	// Find user in the DB by email
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if(!potentialUser.isPresent()) { //if user email not found in DB:
            result.rejectValue("email", "Matches", "Invalid email/password");
            return null;
        }

        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
            result.rejectValue("password", "Matches", "Invalid email/password");
            return null;
        }
    
        // Otherwise, return the user object
        return potentialUser.get();
    }

    public User findUserById(Long id) {
        Optional<User> u = userRepo.findById(id);
        
        if(u.isPresent()) {
            return u.get();
        } else {
            return null;
        }
    }
}