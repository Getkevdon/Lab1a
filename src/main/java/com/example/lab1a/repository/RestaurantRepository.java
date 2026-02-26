package com.example.lab1a.repository;

import com.example.lab1a.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByLocationId(Long locationId);
    long countByLocationId(Long locationId);
}
