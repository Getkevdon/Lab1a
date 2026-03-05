package com.example.lab1a.api;

import com.example.lab1a.domain.Category;
import com.example.lab1a.domain.Location;
import com.example.lab1a.domain.Restaurant;
import com.example.lab1a.service.CategoryService;
import com.example.lab1a.service.LocationService;
import com.example.lab1a.service.MenuItemService;
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
    private final CategoryService categoryService;
    private final MenuItemService menuItemService;

    public AdminController(LocationService locationService, RestaurantService restaurantService, CategoryService categoryService, MenuItemService menuItemService) {
        this.locationService = locationService;
        this.restaurantService = restaurantService;
        this.categoryService=categoryService;
        this.menuItemService=menuItemService;
    }

    @GetMapping
    public List<Location> getAll() {
        return locationService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    @GetMapping("restaurants/{locationId}")
    public List<Restaurant> findRestaurantByLocationId(@PathVariable Long locationId) {
        return restaurantService.getRestaurantsByLocation(locationId);
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant, Long locationId) {
        return restaurantService.addRestaurant(locationId, restaurant);
    }

    @GetMapping("restaurants/{restaurantId}/categories")
    public List<Category> getCategoriesByRestaurantId(@PathVariable Long restaurantId){
        return categoryService.getCategoriesByRestaurantId(restaurantId);
    }

    @PostMapping("/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category, Long restaurantId ){
        return categoryService.addCategory(restaurantId, category);
    }
}
