package com.ecohabitat.habitat_service.models;

import com.ecohabitat.habitat_service.exceptions.HabitatNotFoundException;
import com.ecohabitat.habitat_service.exceptions.HabitatsNotFoundException;
import com.ecohabitat.habitat_service.repositories.HabitatRespository;
import com.ecohabitat.habitat_service.service.HabitatService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class HabitatTest {
    @Autowired
    private HabitatService habitatService;

    @Autowired
    private HabitatRespository habitatRespository;

    Habitat testHabitat;


    @BeforeEach
    void setUp() {
        testHabitat = new Habitat();
        testHabitat.setLocation("Unknown");
        testHabitat.setType("Chalet Testing");
        habitatRespository.save(testHabitat);
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    @DisplayName("Test find habitat id")
    void testGetId() {
       Habitat habitat = habitatService.getHabitatById(testHabitat.getId());
        assertNotNull(habitat);
        assertEquals(testHabitat.getId(), habitat.getId());
    }

    @Test
    @DisplayName("Test get all habitats")
    void testGetHabitats() {
        List<Habitat> habitats = habitatService.getHabitats();
        assertNotNull(habitats);
    }

    @Test
    @DisplayName ("Exception throws test")
    void testHabitatNotFound() {

        HabitatNotFoundException exc= assertThrows(
                HabitatNotFoundException.class,
                () -> habitatService.getHabitatById(999L),
                "Expect Habitat id: 999 not found Message");
        assertEquals(HabitatNotFoundException.class, exc.getClass());


    }

}