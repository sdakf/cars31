package com.example.cars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;

    public CarDto(Long id, String model) {
        this.id = id;
        this.model = model;
    }
}
