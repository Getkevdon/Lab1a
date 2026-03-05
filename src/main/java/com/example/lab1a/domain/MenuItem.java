package com.example.lab1a.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menuItem")
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuItemId;

    private String itemName;
    private String description;
    private double price;
    private boolean available;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoryId")
    @JsonBackReference
    private Category category;

}
