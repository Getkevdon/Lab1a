package com.example.lab1a.service;

import com.example.lab1a.domain.Location;
import com.example.lab1a.domain.Restaurant;
import com.example.lab1a.repository.LocationRepository;
import com.example.lab1a.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final LocationRepository locationRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, LocationRepository locationRepository){
        this.restaurantRepository = restaurantRepository;
        this.locationRepository = locationRepository;
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }
    public List<Restaurant> getRestaurantsByLocation(Long locationId){
        if (!locationRepository.existsById(locationId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Location not found with id " + locationId);
        }
        return restaurantRepository.findByLocationId(locationId);
    }

    public Restaurant createRestaurant(Long locationId, Restaurant restaurant){
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Location not found with id " + locationId));

        restaurant.setLocation(location);
        return restaurantRepository.save(restaurant);
    }
}
