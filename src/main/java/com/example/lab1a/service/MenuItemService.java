package com.example.lab1a.service;

import com.example.lab1a.domain.Category;
import com.example.lab1a.domain.MenuItem;
import com.example.lab1a.repository.CategoryRepository;
import com.example.lab1a.repository.MenuItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;
    private final CategoryRepository categoryRepository;

    public MenuItemService(MenuItemRepository menuItemRepository, CategoryRepository categoryRepository){
        this.menuItemRepository=menuItemRepository;
        this.categoryRepository=categoryRepository;
    }

    public MenuItem addMenuItem(Long categoryId, MenuItem menuItem){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,  "Category not found with id " + categoryId));
        menuItem.setCategory(category);
        return menuItemRepository.save(menuItem);
    }
}
