package com.example.carsapp.cars;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CarDto {
    private Long id;
    private String model;
    private Long mileage;
    private Long ownerId;

    private List<Long> optionIds;

    private BigDecimal optionsPrice;

    public CarDto(Long id, String model, Long mileage, Long ownerId, BigDecimal optionsPrice) {
        this.id = id;
        this.model = model;
        this.mileage = mileage;
        this.ownerId = ownerId;
        this.optionsPrice = optionsPrice;
    }
}
