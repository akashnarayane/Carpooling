package jbr.springmvc.service;



import jbr.springmvc.model.Driver;


public interface DriverService {
	
	int driverRegister(Driver driver);
	Driver validateDriver(Driver driver);	
}
