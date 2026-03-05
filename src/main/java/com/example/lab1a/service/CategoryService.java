package com.example.lab1a.service;

import com.example.lab1a.domain.Category;
import com.example.lab1a.domain.Restaurant;
import com.example.lab1a.repository.CategoryRepository;
import com.example.lab1a.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final RestaurantRepository restaurantRepository;

    public CategoryService(CategoryRepository categoryRepository, RestaurantRepository restaurantRepository){
        this.categoryRepository = categoryRepository;
        this.restaurantRepository=restaurantRepository;
    }

    public List<Category> getCategoriesByRestaurantId(Long restaurantId){
        if (!restaurantRepository.existsById(restaurantId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found with id " + restaurantId);
        }
        return categoryRepository.findByRestaurantId(restaurantId);
    }

    public Category addCategory(Long restaurantId, Category category){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Restaurant not found with id " + restaurantId));
        category.setRestaurant(restaurant);
        return categoryRepository.save(category);
    }


}
