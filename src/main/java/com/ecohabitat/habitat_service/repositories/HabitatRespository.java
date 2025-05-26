package com.ecohabitat.habitat_service.repositories;

import com.ecohabitat.habitat_service.models.Habitat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitatRespository extends JpaRepository<Habitat, Long> {
}
