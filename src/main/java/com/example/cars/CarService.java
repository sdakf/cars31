package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //bean -> SINGLETON
//@Component//bean -> SINGLETON
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDto add(CarDto carDto) {
        Car car = new Car();
        car.setModel(carDto.getModel());
        Car saved = carRepository.save(car);
        return new CarDto(saved.getId(), saved.getModel());
    }

    public List<CarDto> find(String query) {
        if(query == null || query.isBlank()) {
            return carRepository.findAll().stream()
                    .map(c -> new CarDto(c.getId(), c.getModel()))
                    .collect(Collectors.toList());
        }
        return carRepository.findByModel(query).stream()
                .map(c -> new CarDto(c.getId(), c.getModel()))
                .collect(Collectors.toList());
    }
}
