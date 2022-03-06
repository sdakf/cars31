package com.example.cars;

import com.example.cars.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    private String model;

    private Long mileage;

    public static Car create(CarDto carDto) {
        Car car = new Car();
        car.mileage = carDto.getMileage();
        car.model = carDto.getModel();
        return car;
    }

    public CarDto toDto() {
        Long ownerId = owner == null ? null : owner.getId();
        return new CarDto(this.id, model, mileage, ownerId);
    }

    public void update(CarDto carDto, User owner) {
        this.model = carDto.getModel();
        this.mileage = carDto.getMileage();
        this.owner = owner;
    }
}
