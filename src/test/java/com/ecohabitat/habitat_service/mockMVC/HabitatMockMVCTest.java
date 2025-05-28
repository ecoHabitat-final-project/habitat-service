package com.ecohabitat.habitat_service.mockMVC;


import com.ecohabitat.habitat_service.controllers.HabitatController;
import com.ecohabitat.habitat_service.models.Habitat;
import com.ecohabitat.habitat_service.repositories.HabitatRespository;
import com.ecohabitat.habitat_service.service.HabitatService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HabitatController.class)
public class HabitatMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HabitatService habitatService;

    private Habitat testHabitat;

    @BeforeEach
    void setUp() throws Exception {
        testHabitat = new Habitat();
        testHabitat.setId(333L);
        testHabitat.setLocation("LozoyaTest");
        testHabitat.setType("ChaletTest");
    }

    @Test
    @DisplayName("Get /api/habitat/{habitatId}")
    void testGetHabitatById() throws Exception {
        given(habitatService.getHabitatById(333L)).willReturn(testHabitat);
        mockMvc.perform(get("/api/habitat/333"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location").value("LozoyaTest"))
                .andExpect(jsonPath("$.type").value("ChaletTest"));

    }


}


