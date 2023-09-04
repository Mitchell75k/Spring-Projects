package com.mitchell.esparza.relationships.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mitchell.esparza.relationships.models.Person;
import com.mitchell.esparza.relationships.repositories.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // returns all the persons and their license info 
    public List<Person> allPersons() {
        return personRepository.findAll();
    }

    // creates a person
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    // retrieves a person
    public Person findPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    // deletes a person by its id
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    // updates a person
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
