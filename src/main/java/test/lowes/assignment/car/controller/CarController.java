package test.lowes.assignment.car.controller;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.lowes.assignment.car.constants.CarConstants;
import test.lowes.assignment.car.entity.Car;
import test.lowes.assignment.car.service.CarService;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "*")
public class CarController {

	private static Logger log = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@GetMapping("/")
	public ResponseEntity<?> getCars() {
		if (log.isDebugEnabled()) {
			log.debug(CarConstants.LogConstants.METHOD_ENTER + "getCars()");
		}
		try {
			List<Car> carsList = carService.getCars();
			log.info("Cars count: " + carsList.size());
			if (log.isDebugEnabled()) {
				log.debug(CarConstants.LogConstants.METHOD_EXIT + "getCars()");
			}
			return new ResponseEntity<>(carsList, HttpStatus.OK);
		} catch (SQLSyntaxErrorException ssee) {
			log.error(CarConstants.ErrorLogConstants.SQL_SYNTAX_ERROR_EXCEPTION, ssee);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.SQL_SYNTAX_ERROR_EXCEPTION, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCarById(@PathVariable("id") String carId) {
		if (log.isDebugEnabled()) {
			log.debug(CarConstants.LogConstants.METHOD_ENTER + "getCarById()");
		}
		try {
			Car car = new Car();
			if (carId != null && !carId.isEmpty()) {
				car = carService.getCarById(Integer.parseInt(carId));
				log.info("Car: " + car.toString());
				if (log.isDebugEnabled()) {
					log.debug(CarConstants.LogConstants.METHOD_EXIT + "getCarById()");
				}
			}
			return new ResponseEntity<>(car, HttpStatus.OK);
		} catch (NumberFormatException nfe) {
			log.error(CarConstants.ErrorLogConstants.INVALID_CAR_ID, nfe);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.INVALID_CAR_ID, HttpStatus.BAD_REQUEST);
		} catch (NoSuchElementException nsee) {
			log.error(CarConstants.ErrorLogConstants.CAR_NOT_FOUND_FOR_ID, nsee);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.CAR_NOT_FOUND_FOR_ID, HttpStatus.BAD_REQUEST);
		}
	}

}
