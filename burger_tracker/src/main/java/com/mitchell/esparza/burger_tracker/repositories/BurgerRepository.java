package com.mitchell.esparza.burger_tracker.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mitchell.esparza.burger_tracker.models.Burger;

@Repository
//create a BurgerRepository, we will only need a "findAll" query for now
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    List<Burger> findAll(); //this method retrieves all the burgers from the database

}