package com.example.lab1a.api;

import com.example.lab1a.domain.Location;
import com.example.lab1a.domain.Restaurant;
import com.example.lab1a.service.LocationService;
import com.example.lab1a.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {
    private final LocationService locationService;
    private final RestaurantService restaurantService;

    public AdminController(LocationService locationService, RestaurantService restaurantService) {
        this.locationService = locationService;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable Long id){
        return locationService.findByLocationId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @GetMapping("restaurants/{locationId}")
    public List<Restaurant> findRestaurantByLocationId(@PathVariable Long locationId) {
        return restaurantService.getRestaurantsByLocation(locationId);
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant, Long locationId) {
        return restaurantService.createRestaurant(locationId, restaurant);
    }
}
