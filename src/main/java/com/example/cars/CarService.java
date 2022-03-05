package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //bean -> SINGLETON
//@Component//bean -> SINGLETON
public class CarService {

    private PersonService personService;

    @Autowired
    private CarRepository carRepository;

    public CarDto add(CarDto carDto) {
        Car car = new Car();
        car.setModel(carDto.getModel());
        car.setMileage(carDto.getMileage());
        Car saved = carRepository.save(car);
        return saved.toDto();
    }

    public List<CarDto> find(String query) {
        if (query == null || query.isBlank()) {
            return carRepository.findAll().stream()
                    .map(c -> c.toDto())
                    .collect(Collectors.toList());
        }
        return carRepository.findByModel(query).stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        car.update(carDto);
        Car saved = carRepository.save(car);
        return saved.toDto();
    }
}
