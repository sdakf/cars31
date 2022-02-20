package com.example.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.model like concat('%', ?1,'%')")
    List<Car> findByModel(String query);
}
