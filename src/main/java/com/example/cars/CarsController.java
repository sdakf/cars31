package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarsController {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public CarDto add(@RequestBody CarDto carDto) {
        return carService.add(carDto);
    }

    @GetMapping("/cars")
    public List<CarDto> list(@RequestParam(required = false) String q){
        return carService.find(q);
    }
}
