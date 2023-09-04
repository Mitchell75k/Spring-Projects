package com.mitchell.esparza.burger_tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.mitchell.esparza.burger_tracker.models.Burger;
import com.mitchell.esparza.burger_tracker.repositories.BurgerRepository;

@Service
public class BurgerService {
    //adding the burger repository as a dependency
    private final BurgerRepository burgerRepository;

    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    //returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    //creates a burger
    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    //retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }

    //deletes a burger by its id
    public void deleteBurger(Long id) {
        burgerRepository.deleteById(id);
    }
    
    //updates a burger and takes in the id of the burger to be updated and the new information for the burger
    public Burger updateBurger(Burger burger) {
        return burgerRepository.save(burger);
    }
}
