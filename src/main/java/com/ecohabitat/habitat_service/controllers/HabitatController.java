package com.ecohabitat.habitat_service.controllers;


import com.ecohabitat.habitat_service.dto.TypeDTO;
import com.ecohabitat.habitat_service.models.Habitat;
import com.ecohabitat.habitat_service.service.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitat")
public class HabitatController {

    @Autowired
    private HabitatService habitatService;

    @GetMapping("")
    ResponseEntity<?> getHabitats() {
        List<Habitat> habitats = habitatService.getHabitats();
        return new ResponseEntity<>(habitats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getHabitatById(@PathVariable("id") int id) {
        Habitat habitatFound = habitatService.getHabitatById(id);
        return new ResponseEntity<>(habitatFound, HttpStatus.OK);
    }


    @PostMapping("")
    ResponseEntity<?> createHabitat(@RequestBody Habitat habitat) {
        habitatService.createHabitat(habitat);
        return new ResponseEntity<>(habitat, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{habitatId}")
    ResponseEntity<?> deleteHabitat(@PathVariable ("habitatId") Long habitatId) {
        habitatService.deleteHabitat(habitatId);
        return new ResponseEntity<> ("Deleted Habitat", HttpStatus.OK);
    }
    @PatchMapping("/update/{habitatId}")
    ResponseEntity<?> updateType(@PathVariable("habitatId") Long userId,
                                  @RequestBody TypeDTO typeDTO) {

        Habitat habitatUpdated =habitatService.updateHabitat(userId, typeDTO);
        return new ResponseEntity<>(habitatUpdated, HttpStatus.OK);
    }

}
