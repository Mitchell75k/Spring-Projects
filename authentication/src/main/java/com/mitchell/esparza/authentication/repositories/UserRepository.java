package com.mitchell.esparza.authentication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitchell.esparza.authentication.models.User;

/*
 * IMPORTANT:
 * we do not need to make a repository for the LoginUser class as we only want to save instances of User to the database.
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
}
