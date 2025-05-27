package com.ecohabitat.habitat_service.repositories;

import com.ecohabitat.habitat_service.models.Habitat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HabitatRespository extends JpaRepository<Habitat, Long> { }

