package com.example.cars;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Long mileage;

    public CarDto toDto() {
        return new CarDto(id, model, mileage);
    }

    public void update(CarDto carDto) {
        this.model = carDto.getModel();
        this.mileage = carDto.getMileage();
    }
}
