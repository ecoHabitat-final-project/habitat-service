package com.ecohabitat.habitat_service.service;

import com.ecohabitat.habitat_service.dto.OwnerDTO;
import com.ecohabitat.habitat_service.exceptions.HabitatNotFoundException;
import com.ecohabitat.habitat_service.exceptions.HabitatsNotFoundException;
import com.ecohabitat.habitat_service.models.Habitat;
import com.ecohabitat.habitat_service.repositories.HabitatRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitatService {
    @Autowired
    private HabitatRespository habitatRepository;


    public Habitat getHabitatById(long id) {
        return habitatRepository.findById(id).
                orElseThrow(() -> new HabitatNotFoundException("Habitat id: " + id+ " not found"));
    }


    public List<Habitat> getHabitats() {
        if(habitatRepository.findAll().isEmpty()) {
            throw new HabitatsNotFoundException("Habitats are empty");

        }else{
            return habitatRepository.findAll();
        }
    }


    public Habitat getHabitatByOwnerId(long id){

        return habitatRepository.findHabitatByOwnerId(id).
                orElseThrow(() -> new HabitatNotFoundException("Habitat id: " + id+ " not found"));
    }

    public Habitat createHabitat(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public void deleteHabitat(long id) {
        habitatRepository.deleteById(id);
    }

    public Habitat updateOwner(long ownerId, OwnerDTO ownerDTO){
        Habitat habitat = habitatRepository.findById(ownerId)
                .orElseThrow(() -> new HabitatNotFoundException("User id " + ownerId + " not found"));
        habitat.setOwnerId(ownerDTO.getOwnerId());
        return habitatRepository.save(habitat);

    }



}



