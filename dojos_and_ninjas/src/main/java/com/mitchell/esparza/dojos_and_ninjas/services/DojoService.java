package com.mitchell.esparza.dojos_and_ninjas.services;

import org.springframework.stereotype.Service;
import com.mitchell.esparza.dojos_and_ninjas.models.Dojo;
import com.mitchell.esparza.dojos_and_ninjas.repositories.DojoRepository;
import java.util.List;

@Service
public class DojoService {
    private final DojoRepository dojoRepository; //create an instance of the DojoRepository

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    // returns all the dojos from the database
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }

    // creates a dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    // retrieves a dojo
    public Dojo findDojo(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

    // deletes a dojo by its id
    public void deleteDojo(Long id) {
        dojoRepository.deleteById(id);
    }

    // updates a dojo
    public Dojo updateDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    
}
