package com.mitchell.esparza.safe_travels.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.mitchell.esparza.safe_travels.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
    List<Travel> findAll(); //this method retrieves all the travels from the database


}
