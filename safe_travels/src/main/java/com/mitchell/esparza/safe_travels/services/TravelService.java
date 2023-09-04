package com.mitchell.esparza.safe_travels.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mitchell.esparza.safe_travels.models.Travel;
import com.mitchell.esparza.safe_travels.repositories.TravelRepository;


@Service
public class TravelService {
    //adding the travel repository as a dependency
    private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    //returns all the travels
    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }

    //creates a travel
    public Travel createTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    //retrieves a travel
    public Travel findTravel(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    //deletes a travel by its id
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
    
    //updates a travel and takes in the id of the travel to be updated and the new information for the travel
    public Travel updateTravel(Travel travel) {
        return travelRepository.save(travel);
    }
    
}
