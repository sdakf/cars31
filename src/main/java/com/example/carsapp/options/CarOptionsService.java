package com.example.carsapp.options;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Access;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarOptionsService {
    @Autowired
    private OptionsRepository optionsRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<CarOptionDto> getCarOptions() {
        return optionsRepository.findAll()
                .stream().map(e -> e.toDto())
                .collect(Collectors.toList());
    }

    public BigDecimal fetchPrices(List<Long> optionIds) {
        BigDecimal sum = new BigDecimal(0);
        List<CarOption> options = optionsRepository.findAllById(optionIds);
        for (CarOption option : options) {
            ResponseEntity<BigDecimal> price = restTemplate.getForEntity("http://localhost:9090/equipment/" + option.getOptionCode(), BigDecimal.class);
            sum = sum.add(price.getBody());
        }
        return sum;
    }
}
