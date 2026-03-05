package com.example.lab1a.repository;

import com.example.lab1a.domain.MenuItem;
import com.example.lab1a.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> fingByCategoryId(Long categoryId);
    long countByCategoryId(Long categoryId);


}
