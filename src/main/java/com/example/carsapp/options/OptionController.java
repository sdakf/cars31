package com.example.carsapp.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {
    @Autowired
    private CarOptionsService carOptionsService;

    @GetMapping("/car-options")
    public ResponseEntity<List<CarOptionDto>> getCarOptions() {
        return ResponseEntity.ok(carOptionsService.getCarOptions());
    }
}
