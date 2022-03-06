package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarsController {

    private PersonService personService = new PersonService();

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<CarDto> add(@RequestBody CarDto carDto) {
        CarDto car = carService.add(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> list(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) Long ownerId) {
        List<CarDto> carFind = carService.find(q, ownerId);
        return ResponseEntity.ok(carFind);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long id, @RequestBody CarDto carDto){
        CarDto savedCar = carService.updateCar(id, carDto);
        return ResponseEntity.ok(savedCar);
    }
}
