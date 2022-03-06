package com.example.carsapp.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.model like concat('%', ?1,'%')")
    List<Car> findByModel(String query);

    @Query("select c from Car c where c.model like concat('%', ?1,'%') and c.owner.id = ?2")
    List<Car> findByOwnerAndModel(String model, Long ownerId);

    @Query("select c from Car c where c.owner.id = ?1")
    List<Car> findByOwner(Long ownerId);
}
