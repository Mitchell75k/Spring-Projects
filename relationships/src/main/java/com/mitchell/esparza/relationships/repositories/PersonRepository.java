package com.mitchell.esparza.relationships.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mitchell.esparza.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll(); //this method retrieves all the persons from the database

}