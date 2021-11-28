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
import test.lowes.assignment.car.entity.Company;
import test.lowes.assignment.car.service.CompanyService;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

	private static Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@GetMapping("/")
	public ResponseEntity<?> getCompanies() {
		if (log.isDebugEnabled()) {
			log.debug(CarConstants.LogConstants.METHOD_ENTER + "getCompanies()");
		}
		try {
			List<Company> companiesList = companyService.getCompanies();
			log.info("Companies count: " + companiesList.size());
			if (log.isDebugEnabled()) {
				log.debug(CarConstants.LogConstants.METHOD_EXIT + "getCompanies()");
			}
			return new ResponseEntity<>(companiesList, HttpStatus.OK);
		} catch (SQLSyntaxErrorException ssee) {
			log.error(CarConstants.ErrorLogConstants.SQL_SYNTAX_ERROR_EXCEPTION, ssee);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.SQL_SYNTAX_ERROR_EXCEPTION, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable("id") String companyId) {
		if (log.isDebugEnabled()) {
			log.debug(CarConstants.LogConstants.METHOD_ENTER + "getCompanyById()");
		}
		try {
			Company company = new Company();
			if (companyId != null && !companyId.isEmpty()) {
				company = companyService.getCompanyById(Integer.parseInt(companyId));
				log.info("Company: " + company.toString());
				if (log.isDebugEnabled()) {
					log.debug(CarConstants.LogConstants.METHOD_EXIT + "getCompanyById()");
				}
			}
			return new ResponseEntity<>(company, HttpStatus.OK);
		} catch (NumberFormatException nfe) {
			log.error(CarConstants.ErrorLogConstants.INVALID_COMPANY_ID, nfe);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.INVALID_COMPANY_ID, HttpStatus.BAD_REQUEST);
		} catch (NoSuchElementException nsee) {
			log.error(CarConstants.ErrorLogConstants.COMPANY_NOT_FOUND_FOR_ID, nsee);
			return new ResponseEntity<>(CarConstants.ErrorResponseConstants.COMPANY_NOT_FOUND_FOR_ID, HttpStatus.BAD_REQUEST);
		}
	}

}
