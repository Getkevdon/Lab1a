package com.example.lab1a.service;

import com.example.lab1a.domain.Location;
import com.example.lab1a.repository.LocationRepository;
import com.example.lab1a.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final RestaurantRepository restaurantRepository;
    public LocationService(LocationRepository locationRepository, RestaurantRepository restaurantRepository) {
        this.locationRepository = locationRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }
    public Location findByLocationId(Long locationId) {
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found with id " + locationId));
    }

    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }


}
