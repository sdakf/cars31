package com.example.carsapp.cars;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private Long mileage;
    private Long ownerId;
    private List<Long> optionIds;

    public CarDto(Long id, String model, Long mileage, Long ownerId) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
        this.ownerId = ownerId;
    }
}
