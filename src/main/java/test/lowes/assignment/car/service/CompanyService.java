package test.lowes.assignment.car.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.lowes.assignment.car.constants.CarConstants;
import test.lowes.assignment.car.entity.Company;
import test.lowes.assignment.car.repository.CompanyRepository;

@Service
public class CompanyService {

	private static Logger log = LoggerFactory.getLogger(CarService.class);

	@Autowired
	private CompanyRepository companyRepository;

	public List<Company> getCompanies() throws SQLSyntaxErrorException {
		log.info(CarConstants.LogConstants.METHOD_ENTER + "getCompanies()");
		return companyRepository.findAll();
	}

	public Company getCompanyById(int companyId) throws NoSuchElementException {
		log.info(CarConstants.LogConstants.METHOD_ENTER + "getCompanyById()");
		return companyRepository.findById(companyId).get();
	}

}
