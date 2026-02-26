package com.example.lab1a.repository;

import com.example.lab1a.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long locationId);
}
