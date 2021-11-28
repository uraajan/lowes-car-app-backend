package test.lowes.assignment.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.lowes.assignment.car.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
