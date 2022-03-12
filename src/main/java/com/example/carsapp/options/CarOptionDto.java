package com.example.carsapp.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarOptionDto {

    private Long id;
    private String optionName;
    private String optionCode;


}
