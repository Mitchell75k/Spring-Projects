package com.mitchell.esparza.dojos_and_ninjas.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.mitchell.esparza.dojos_and_ninjas.models.Ninja;
import com.mitchell.esparza.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    public Ninja findNinja(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }
    public void deleteNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
    public Ninja updateNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    
}
