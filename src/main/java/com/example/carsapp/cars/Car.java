package com.example.carsapp.cars;

import com.example.carsapp.options.CarOption;
import com.example.carsapp.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    private String model;

    private Long mileage;

    @ManyToMany
    @JoinTable(name = "cars_options")
    private List<CarOption> option;

    private BigDecimal optionsPrice;

    public static Car create(CarDto carDto) {
        Car car = new Car();
        car.mileage = carDto.getMileage();
        car.model = carDto.getModel();
        return car;
    }

    public CarDto toDto() {
        Long ownerId = owner == null ? null : owner.getId();
        return new CarDto(this.id, model, mileage, ownerId, optionsPrice);
    }

    public void update(CarDto carDto, User owner, BigDecimal sum) {
        this.model = carDto.getModel();
        this.mileage = carDto.getMileage();
        this.owner = owner;
        this.optionsPrice = sum;
    }
}
