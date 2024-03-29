package com.example.carsapp.cars;

import com.example.carsapp.EntityNotFoundException;
import com.example.carsapp.options.CarOptionsService;
import com.example.carsapp.users.User;
import com.example.carsapp.users.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service //bean -> SINGLETON
//@Component//bean -> SINGLETON
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarOptionsService carOptionsService;

    public CarDto add(CarDto carDto) {
        Car car = Car.create(carDto);
        Car saved = carRepository.save(car);
        return saved.toDto();
    }

    public List<CarDto> find(String model, Long ownerId) {
        if (StringUtils.isBlank(model) && ownerId == null) {  // null ""   "  "
            return carRepository.findAll().stream()
                    .map(c -> c.toDto())
                    .collect(Collectors.toList());
        }
        if (StringUtils.isNotBlank(model) && ownerId != null) {  // null ""   "  "
            return carRepository.findByOwnerAndModel(model, ownerId).stream()
                    .map(c -> c.toDto())
                    .collect(Collectors.toList());
        }
        if (StringUtils.isNotBlank(model)) {
            return carRepository.findByModel(model).stream()
                    .map(Car::toDto)
                    .collect(Collectors.toList());
        }
        return carRepository.findByOwner(ownerId).stream()
                .map(Car::toDto)
                .collect(Collectors.toList());
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public CarDto updateCar(Long id, CarDto carDto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        User user = userRepository.findById(carDto.getOwnerId())
                .orElseThrow(() -> new EntityNotFoundException(carDto.getOwnerId()));

        List<Long> optionIds = carDto.getOptionIds();
        BigDecimal sum = carOptionsService.fetchPrices(optionIds);

        car.update(carDto, user,sum);
        Car saved = carRepository.save(car);
        return saved.toDto();
    }
}
