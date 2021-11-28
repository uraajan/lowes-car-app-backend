package test.lowes.assignment.car.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.lowes.assignment.car.constants.CarConstants;
import test.lowes.assignment.car.entity.Car;
import test.lowes.assignment.car.repository.CarRepository;

@Service
public class CarService {

	private static Logger log = LoggerFactory.getLogger(CarService.class);

	@Autowired
	private CarRepository carRepository;

	public List<Car> getCars() throws SQLSyntaxErrorException {
		log.info(CarConstants.LogConstants.METHOD_ENTER + "getCars()");
		return carRepository.findAll();
	}

	public Car getCarById(int carId) throws NoSuchElementException {
		log.info(CarConstants.LogConstants.METHOD_ENTER + "getCarById()");
		return carRepository.findById(carId).get();
	}

}
