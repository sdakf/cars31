package com.example.cars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private Long mileage;

    public CarDto(Long id, String model, Long mileage) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
    }
}
