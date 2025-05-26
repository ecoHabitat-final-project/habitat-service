package com.ecohabitat.habitat_service.models;

import com.ecohabitat.habitat_service.dto.OwnerDTO;
import com.ecohabitat.habitat_service.repositories.HabitatRespository;
import com.ecohabitat.habitat_service.service.HabitatService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.AutoConfigureGraphQl;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HabitatTest {
    @Autowired
    private HabitatService habitatService;

    @Autowired
    private HabitatRespository habitatRespository;

    Habitat habitat;


//    @BeforeEach
//    void setUp() {
//        habitat = new Habitat();
//        habitat.setOwnerId(1L);
//        habitat.setLocation("Sevilla");
//        habitat.setType("Chalet dos plantas");
//
//        habitatRespository.save(habitat);
//    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test find habitat id")
    void testGetId() {
        habitat = habitatService.getHabitatById(1L);
        assertNotNull(habitat);
    }

    @Test
    @DisplayName("Test get all habitats")
    void testGetHabitats() {
        List<Habitat> habitats = habitatService.getHabitats();
        assertNotNull(habitats);
    }

    @Test
    @DisplayName("Patch ownerId")
    void testPatchOwner() {
        habitat = habitatService.getHabitatById(1L);
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setOwnerId(2L);
        habitat.setOwnerId(ownerDTO.getOwnerId());
        assertEquals(habitat.getOwnerId(), ownerDTO.getOwnerId());
    }
}