package com.example.lab1a.api;

import com.example.lab1a.domain.Location;
import com.example.lab1a.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {
    private final LocationSer
    ;;;vice locationService;

    public AdminController(LocationService locationService) {
        this.locationService = locationService;
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
}
